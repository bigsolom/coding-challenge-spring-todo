package de.neuefische.codingchallengejava.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {

    @Test
    void statusIsSetToNewByDefault() throws Exception{
        var todo = new Todo("title");
        assertEquals(Todo.TodoStatus.NEW, todo.getStatus());
    }
}
