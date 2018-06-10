package ru.inbox.savinov_vu.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;



@RestController
public class TodoRestController {

    @Autowired
    private TodoRepository todoRepository;


    @GetMapping("/api/todos/{id}")
    public Optional<Todo> findById(@PathVariable Integer id) {
        return todoRepository.findById(id);
    }
}
