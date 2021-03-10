package en.tomasz.notetask.service;



import en.tomasz.notetask.converter.NoteConverter;
import en.tomasz.notetask.dto.NoteDto;
import en.tomasz.notetask.model.Note;
import en.tomasz.notetask.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NoteService implements NoteServiceI {


    private final NoteRepository noteRepository;


    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }


    @Override
    public NoteDto updateNote(NoteDto noteDto) {
        Note note = noteRepository.getOne(noteDto.getId());
        note.setDeleted(true);
        noteRepository.save(note);
        Note noteToUpdate = new Note();
        noteToUpdate.setOriginalId(note.getOriginalId());
        noteToUpdate.setTitle(noteDto.getTitle());
        noteToUpdate.setContent(noteDto.getContent());
        noteToUpdate.setCreated(note.getCreated());
        noteToUpdate.setDeleted(false);
        noteToUpdate.setVersion(note.getVersion()+1);
        Note savedNote = noteRepository.save(noteToUpdate);
        return NoteConverter.toDto(savedNote);
    }

    @Override
    public Optional<NoteDto> findById(Long id) {
        return noteRepository.findById(id).map(NoteConverter::toDto);
    }

    @Override
    public NoteDto addNote(NoteDto noteDto) {
        Note note = Note.builder()
                .title(noteDto.getTitle())
                .content(noteDto.getContent())
                .build();
        note.setDeleted(false);
        note.setVersion(1);
        Note noteToUpdate = noteRepository.save(note);
        noteToUpdate.setOriginalId(noteToUpdate.getId());
        noteRepository.save(noteToUpdate);
        return NoteConverter.toDto(noteRepository.getOne(note.getId()));
    }

    @Override
    public List<NoteDto> getNotes() {
        return noteRepository.findAllByDeletedIsFalse().stream()
                .map(NoteConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        Note note = noteRepository.getOne(id);
        note.setDeleted(true);
        noteRepository.save(note);
    }

    @Override
    public List<NoteDto> historyById(Long id) {
        return noteRepository.findAllByOriginalId(id)
                .stream().map(NoteConverter::toDto)
                .collect(Collectors.toList());
    }
}
