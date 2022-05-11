package com.example.todo.api;

import com.example.todo.model.Todo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoImpl implements TodosApiDelegate {

    @Override
    public ResponseEntity<Void> createTodo(Todo todo, Boolean completed) {
        return TodosApiDelegate.super.createTodo(todo, completed);
    }

    @Override
    public ResponseEntity<Void> deleteTodo(String todoId) {
        return TodosApiDelegate.super.deleteTodo(todoId);
    }

    @Override
    public ResponseEntity<Todo> getTodo(String todoId) {
        return TodosApiDelegate.super.getTodo(todoId);
    }

    @Override
    public ResponseEntity<List<Todo>> getTodos(Boolean completed) {
        return TodosApiDelegate.super.getTodos(completed);
    }

    @Override
    public ResponseEntity<Void> updateTodo(String todoId, Todo todo) {
        return TodosApiDelegate.super.updateTodo(todoId, todo);
    }
}
