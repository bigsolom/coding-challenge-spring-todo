package de.neuefische.codingchallengejava.daos;

import de.neuefische.codingchallengejava.models.Todo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataMongoTest
@ExtendWith(SpringExtension.class)
public class TodoDALImplTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    private TodoDALImpl todoDAL;

    @BeforeEach
    void setUp() throws Exception{
        todoDAL = new TodoDALImpl();
        todoDAL.setMongoTemplate(mongoTemplate);
    }

    @Test
    void givenAnExistingTodoWhenUpdateIsCalledWithValidIdThenTodoIsUpdated() throws Exception{

        var todo = mongoTemplate.insert(new Todo("old"));
        todo.setTitle("new");

        var result = todoDAL.updateTodoById(todo.getId(), todo);

//        Query query = new Query();
//        query.addCriteria(Criteria.where("id").is(todo.getId()));
//        var result = mongoTemplate.findOne(query, Todo.class);
        assertTrue(result.isPresent());
        assertEquals("two", result.get().getTitle());
    }

    @AfterEach
    void clearDB(){
        mongoTemplate.getDb().drop();
    }
}
