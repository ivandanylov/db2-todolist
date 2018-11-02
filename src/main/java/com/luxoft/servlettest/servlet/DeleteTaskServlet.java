package com.luxoft.servlettest.servlet;

import com.luxoft.servlettest.entity.Todo;
import com.luxoft.servlettest.entity.TodoUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DeleteTaskServlet extends HttpServlet {
    List<Todo> todoList;

    public DeleteTaskServlet(List<Todo> todoList) {
        this.todoList = todoList;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        Todo todo = TodoUtils.getTodoById(todoList, id);

        if (todo == null) {
            resp.sendRedirect("/todolist");

            return;
        }

        todoList.remove(todo);

        resp.sendRedirect("/todolist");
    }
}
