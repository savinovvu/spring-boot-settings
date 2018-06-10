package ru.inbox.savinov_vu.test;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
@Profile("default")
public interface UserRepository extends JpaRepository<User, Integer> {


}
