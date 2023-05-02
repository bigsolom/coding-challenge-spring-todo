package de.neuefische.codingchallengejava.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "todosCollection")
@RequiredArgsConstructor
@AllArgsConstructor
public class Todo {
    public enum TodoStatus{
        NEW,
        IN_PROGRESS,
        ON_HOLD,
        DONE
    }
    @Id
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    @NonNull
    private String title;

    @Getter
    @Setter
    private TodoStatus status = TodoStatus.NEW;

}
