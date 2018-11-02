package com.luxoft.servlettest.entity;

import java.util.List;

public final class TodoUtils {
    public static Todo getTodoById(List<Todo> todoList, int id) {
        for(Todo todo : todoList) {
            if (todo.getId() == id) {
                return todo;
            }
        }

        return null;
    }
}
