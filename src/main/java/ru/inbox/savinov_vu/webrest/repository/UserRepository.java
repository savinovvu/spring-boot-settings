package ru.inbox.savinov_vu.webrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.inbox.savinov_vu.webrest.model.User;



@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}