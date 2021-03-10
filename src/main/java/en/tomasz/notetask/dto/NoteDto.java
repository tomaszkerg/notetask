package en.tomasz.notetask.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoteDto {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime created;
    private LocalDateTime modified;
}
