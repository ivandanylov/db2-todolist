package com.luxoft.servlettest.servlet;

import com.luxoft.servlettest.entity.Todo;
import com.luxoft.servlettest.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class AddTaskServlet extends HttpServlet {

    List<Todo> todoList;
    int nextId = 1;

    public AddTaskServlet(List<Todo> todoList) {
        this.todoList = todoList;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PageGenerator pageGenerator = PageGenerator.instance();
        String page = pageGenerator.getPage("addTask.html", null);

        resp.getWriter().write(page);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int priority = Integer.parseInt(req.getParameter("priority"));

        Todo todo = new Todo(nextId, name, LocalDate.now().plusDays(1), priority);
        todoList.add(todo);

        resp.sendRedirect("/todolist");
    }
}
