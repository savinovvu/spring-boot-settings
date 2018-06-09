package ru.inbox.savinov_vu.webrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.inbox.savinov_vu.webrest.model.Comment;


//@RepositoryRestResource(path = "people", rel = "people") customize spring data rest repository
@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
