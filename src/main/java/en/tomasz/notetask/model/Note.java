package en.tomasz.notetask.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "notes")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Note extends ParentEntity{


    private String title;
    private String content;
    private Integer version;
    private Long originalId;

    @Override
    public String toString() {
        return "Note{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", version=" + version +
                ", originalId=" + originalId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(title, note.title) && Objects.equals(content, note.content) && Objects.equals(version, note.version) && Objects.equals(originalId, note.originalId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content, version, originalId);
    }
}
