package en.tomasz.notetask.service;

import en.tomasz.notetask.dto.NoteDto;

import java.util.List;
import java.util.Optional;

public interface NoteServiceI {


    NoteDto updateNote(NoteDto noteDto);

    Optional<NoteDto> findById(Long id);

    NoteDto addNote(NoteDto noteDto);

    List<NoteDto> getNotes();

    void deleteById(Long id);

    List<NoteDto> historyById(Long id);
}
