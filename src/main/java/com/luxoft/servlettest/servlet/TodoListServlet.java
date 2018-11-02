package com.luxoft.servlettest.servlet;

import com.luxoft.servlettest.entity.Todo;
import com.luxoft.servlettest.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TodoListServlet extends HttpServlet {

    private List<Todo> todoList;

    public TodoListServlet(List<Todo> todoList) {
        this.todoList = todoList;
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PageGenerator pageGenerator = PageGenerator.instance();
        Map<String, Object> params = new HashMap<>();
        params.put("todoList", todoList);

        String page = pageGenerator.getPage("todoList.html", params);
        System.out.println("sending page: " + page);
        resp.getWriter().write(page);
    }

}
