package en.tomasz.notetask.converter;


import en.tomasz.notetask.dto.NoteDto;
import en.tomasz.notetask.model.Note;

public class NoteConverter {

    public static NoteDto toDto(Note note){
        return NoteDto.builder()
                .title(note.getTitle())
                .content(note.getContent())
                .created(note.getCreated())
                .modified(note.getModified())
                .id(note.getId())
                .originalId(note.getOriginalId())
                .build();
    }

}
