package en.tomasz.notetask.repository;


import en.tomasz.notetask.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
