package com.luxoft.servlettest.entity;

import java.time.LocalDate;

public class Todo {
    private int id;
    private String name;
    private LocalDate dueDate;
    private int priority;

    public Todo() {
    }

    public Todo(int id, String name, LocalDate dueDate, int priority) {
        this.id = id;
        this.name = name;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dueDate=" + dueDate +
                ", priority=" + priority +
                '}';
    }
}
