package com.example.todo.api;

import com.example.petstore.api.PetsApi;
import com.example.petstore.model.Pet;
import com.example.todo.model.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoImpl implements TodosApiDelegate {

    private final PetsApi petsApi;

    @Override
    public ResponseEntity<Void> createTodo(Todo todo, Boolean completed) {
        return new ResponseEntity<>(HttpStatus.valueOf(201));
    }

    @Override
    public ResponseEntity<Void> deleteTodo(String todoId) {
        return new ResponseEntity<>(HttpStatus.valueOf(204));
    }

    @Override
    public ResponseEntity<Todo> getTodo(String todoId) {
        try {
            Pet pet = petsApi.showPetById(todoId);
            Todo todo = new Todo()
                    .lastUpdated(OffsetDateTime.now().toString())
                    .firstName(pet.getName())
                    .description(pet.getTag())
                    .completed(true)
                    .date(OffsetDateTime.now());
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(todo);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<List<Todo>> getTodos(Boolean completed) {
        Todo todo = new Todo()
                .firstName("todo")
                .completed(true)
                .description("todo description")
                .date(OffsetDateTime.now());
        return ResponseEntity.ok(List.of(todo));
    }

    @Override
    public ResponseEntity<Void> updateTodo(String todoId, Todo todo) {
        return new ResponseEntity<>(HttpStatus.valueOf(202));
    }
}
