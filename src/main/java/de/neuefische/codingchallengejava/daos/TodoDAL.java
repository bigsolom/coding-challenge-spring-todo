package de.neuefische.codingchallengejava.daos;

import de.neuefische.codingchallengejava.models.Todo;

import java.util.List;

public interface TodoDAL {
    List<Todo> getAllTodos();
}
