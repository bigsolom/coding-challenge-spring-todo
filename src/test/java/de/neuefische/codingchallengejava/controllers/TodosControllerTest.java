package de.neuefische.codingchallengejava.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.neuefische.codingchallengejava.daos.TodoDALImpl;
import de.neuefische.codingchallengejava.models.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TodosController.class)
public class TodosControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TodoDALImpl todoDAL;

    @Test
    void getAllTodosReturnsListOfTodos() throws Exception{
        when(todoDAL.getAllTodos()).thenReturn(Stream.of(new Todo("one"), new Todo("two")).collect(Collectors.toList()));
        mockMvc.perform(get("/todos")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    void updateTodoById() throws Exception{
        var id = "1";
        var title = "title";
        var todo = new Todo(title);
        todo.setStatus(Todo.TodoStatus.DONE);
        when(todoDAL.updateTodoById(anyString(),any())).thenReturn(Optional.of(todo));
        var request = put(String.format("/todos/%s", id))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(new ObjectMapper().writeValueAsString(todo));
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is(title)));

    }

    @Test
    void updateTodo() throws Exception{

    }
}
