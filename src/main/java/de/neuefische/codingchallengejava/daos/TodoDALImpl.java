package de.neuefische.codingchallengejava.daos;

import de.neuefische.codingchallengejava.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoDALImpl implements TodoDAL {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public List<Todo> getAllTodos() {
        return mongoTemplate.findAll(Todo.class);
    }
}
