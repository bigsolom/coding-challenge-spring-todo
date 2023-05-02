package de.neuefische.codingchallengejava.daos;

import de.neuefische.codingchallengejava.models.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoDAL {
    List<Todo> getAllTodos();

    Optional<Todo> updateTodoById(String id, Todo todo);
}
