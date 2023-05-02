package de.neuefische.codingchallengejava.controllers;

import de.neuefische.codingchallengejava.daos.TodoDAL;
import de.neuefische.codingchallengejava.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "todos")
public class TodosController {

    @Autowired
    private TodoDAL todoDAL;

//    public TodosController(TodoRepository todoRepository){
//        this.todoRepository = todoRepository;
//    }

    @GetMapping(value = "")
    public ResponseEntity<List<Todo>> getAllTodos(){
        return new ResponseEntity<>(todoDAL.getAllTodos(), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable("id") String id, @RequestBody Todo todo){
        var result = todoDAL.updateTodoById(id, todo);
        if (result.isPresent()){
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
