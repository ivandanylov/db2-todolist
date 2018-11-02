package com.luxoft.servlettest;


import com.luxoft.servlettest.entity.Todo;
import com.luxoft.servlettest.servlet.AddTaskServlet;
import com.luxoft.servlettest.servlet.DeleteTaskServlet;
import com.luxoft.servlettest.servlet.EditTaskServlet;
import com.luxoft.servlettest.servlet.TodoListServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Starter {
    public static void main(String[] args) throws Exception {
        // config store
        List<Todo> todoList = new ArrayList<>();
        todoList.add(new Todo(1, "Buy milk", LocalDate.of(2018, 10, 12), 5));
        todoList.add(new Todo(2, "Buy cookies", LocalDate.of(2018, 10, 17), 7));
        todoList.add(new Todo(3, "Feed dog", LocalDate.of(2018, 11, 12), 3));

        // config servlets
        TodoListServlet todoListServlet = new TodoListServlet(todoList);
        AddTaskServlet addTaskServlet = new AddTaskServlet(todoList);
        EditTaskServlet editTaskServlet = new EditTaskServlet(todoList);
        DeleteTaskServlet deleteTaskServlet = new DeleteTaskServlet(todoList);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(todoListServlet), "/todolist");
        context.addServlet(new ServletHolder(addTaskServlet), "/todolist/add");
        context.addServlet(new ServletHolder(editTaskServlet), "/todolist/edit");
        context.addServlet(new ServletHolder(deleteTaskServlet), "/todolist/delete");

        Server server = new Server(8081);
        server.setHandler(context);

        server.start();
    }
}
