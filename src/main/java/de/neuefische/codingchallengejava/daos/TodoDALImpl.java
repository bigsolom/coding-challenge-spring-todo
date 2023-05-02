package de.neuefische.codingchallengejava.daos;

import de.neuefische.codingchallengejava.models.Todo;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        var options = new FindAndModifyOptions().returnNew(true);

        var updates = new Update().set("title", todo.getTitle())
                .set("status", todo.getStatus());

        var result = mongoTemplate.findAndModify(query, updates, options, Todo.class);
        return Optional.of(result);
    }


}
