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
        return null;
    }

    @Override
    public Optional<NoteDto> findById(Long id) {
        return null;
    }

    @Override
    public NoteDto addNote(NoteDto noteDto) {  return null;
    }

    @Override
    public List<NoteDto> getNotes() {
        return null;
    }

    @Override
    public void deleteById(Long id) { ;
    }

    @Override
    public List<NoteDto> historyById(Long id) {
        return null;
    }
}
