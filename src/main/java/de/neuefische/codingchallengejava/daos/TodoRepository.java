package de.neuefische.codingchallengejava.daos;

import de.neuefische.codingchallengejava.models.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends MongoRepository<Todo, String> {
}
