package ru.inbox.savinov_vu.test.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
interface TodoRepository extends JpaRepository<Todo, Integer> {

}
