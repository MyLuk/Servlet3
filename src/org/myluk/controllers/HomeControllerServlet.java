package org.myluk.controllers;

import org.myluk.entity.User;
import org.myluk.model.UserModel;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeControllerServlet extends HttpServlet {

    @Resource(name = "jdbc/project")
    private DataSource dataSource;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page").toLowerCase();
        switch (page) {
            case "home":
                request.setAttribute("title", "Homepage");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case "listusers":
                List<User> listUsers = new UserModel().listUsers(dataSource);
                request.setAttribute("listUsers", listUsers);
                request.setAttribute("title", "List of Users");
                request.getRequestDispatcher("listUsers.jsp").forward(request, response);
                break;
            default:
                request.setAttribute("title", "Error page");
                request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
