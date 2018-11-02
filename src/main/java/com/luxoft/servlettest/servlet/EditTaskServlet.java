package com.luxoft.servlettest.servlet;

import com.luxoft.servlettest.entity.Todo;
import com.luxoft.servlettest.entity.TodoUtils;
import com.luxoft.servlettest.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EditTaskServlet extends HttpServlet {
    List<Todo> todoList;

    public EditTaskServlet(List<Todo> todoList) {
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

        Map<String, Object> params = new HashMap<>();
        params.put("id", todo.getId());
        params.put("name", todo.getName());
        params.put("dueDate", todo.getDueDate());
        params.put("priority", todo.getPriority());

        PageGenerator pageGenerator = PageGenerator.instance();

        String page = pageGenerator.getPage("editTask.html", params);
        resp.getWriter().write(page);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(req.getParameter("dueDate"), formatter);

        int priority = Integer.parseInt(req.getParameter("priority"));

        Todo todo = TodoUtils.getTodoById(todoList, id);

        if (todo != null) {
            todoList.set(todoList.indexOf(todo), new Todo(todo.getId(), name, date, priority));
        }

        resp.sendRedirect("/todolist");
    }
}
