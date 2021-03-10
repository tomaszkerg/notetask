package en.tomasz.notetask.controller;


import en.tomasz.notetask.dto.NoteDto;
import en.tomasz.notetask.service.NoteServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Slf4j
@RestController
public class NoteController {

    private final NoteServiceI noteService;

    @Autowired
    public NoteController(NoteServiceI noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/note/list")
    public List<NoteDto> noteList(){
        return noteService.getNotes();
    }

    @GetMapping("/note/{id}")
    public ResponseEntity<NoteDto> getNoteById(@PathVariable Long id){
        return noteService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/note/{id}/history")
    public List<NoteDto> getHistoryById(@PathVariable Long id){
        return noteService.historyById(id);
    }

    @PostMapping("/note/add")
    public ResponseEntity<NoteDto> noteAdd(NoteDto noteDto){
        if(noteDto.getId() != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Zapisywany obiekt nie może mieć ustawionego id");
        NoteDto savedNote = noteService.addNote(noteDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedNote.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedNote);
    }


    @PutMapping("/note/edit/{id}")
    public ResponseEntity<NoteDto> noteEdit(NoteDto noteDto,@PathVariable Long id){
        if(!id.equals(noteDto.getId()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Aktualizowany obiekt musi mieć id zgodne z id w ścieżce zasobu");
        NoteDto updatedNote = noteService.updateNote(noteDto);
        return ResponseEntity.ok(updatedNote);
    }

    @DeleteMapping("/note/delete/{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable Long id) {
        log.info("Request to delete note: {}", id);
        noteService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
