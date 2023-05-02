package de.neuefische.codingchallengejava.daos;

import de.neuefische.codingchallengejava.models.Todo;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TodoDALImpl implements TodoDAL {

    @Autowired
    @Setter //for Testability
    private MongoTemplate mongoTemplate;
    @Override
    public List<Todo> getAllTodos() {
        return mongoTemplate.findAll(Todo.class);
    }

    @Override
    public Optional<Todo> updateTodoById(String id, Todo todo) {
        return Optional.empty();
    }


}
