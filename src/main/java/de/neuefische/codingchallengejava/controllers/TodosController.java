package de.neuefische.codingchallengejava.controllers;

import de.neuefische.codingchallengejava.daos.TodoRepository;
import de.neuefische.codingchallengejava.models.Todo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping(value = "todos")
public class TodosController {

    private final TodoRepository todoRepository;

    public TodosController(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    @GetMapping(value = "")
    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

//    public Todo updateTodo(){
//        todoRepository.findand
//    }
}
