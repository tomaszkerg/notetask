package en.tomasz.notetask.repository;


import en.tomasz.notetask.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findAllByDeletedIsFalse();

    List<Note> findAllByOriginalId(Long id);

}
