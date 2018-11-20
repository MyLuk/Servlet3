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

@WebServlet("/operation")
public class OperationControllerServlet extends HttpServlet {

    @Resource(name = "jdbc/project")
    private DataSource dataSource;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page").toLowerCase();
        switch (page) {
            case "listusers":
                listUsers(request, response);
                break;
            case "adduser":
                addUserFormLoader(request, response);
            case "updateuser":
                updateUserFormLoader(request, response);
            default:
                errorPage(request, response);
        }
    }

    private void updateUserFormLoader(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Update user");
        request.getRequestDispatcher("updateUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operation = request.getParameter("form").toLowerCase();
        switch (operation) {
            case "adduseroperation":
                User newUser = new User(request.getParameter("username"),request.getParameter("email"));
                addUserOperation(newUser);
                listUsers(request, response);
                break;
            case "updateuseroperation":
                User updatedUser = new User(Integer.parseInt(request.getParameter("usersId")),request.getParameter("username"),request.getParameter("email"));
                updateUserOperation(updatedUser);
                listUsers(request, response);
                break;
            default:
                errorPage(request, response);
                break;
        }
    }

    private void updateUserOperation(User updatedUser) {
        new UserModel().updateUser(dataSource, updatedUser);
    }

    private void addUserOperation(User newUser) {
        new UserModel().addUser(dataSource,newUser);

    }

    private void errorPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Error page");
        request.getRequestDispatcher("error.jsp").forward(request, response);
    }


    private void addUserFormLoader(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Add user");
        request.getRequestDispatcher("addUser.jsp").forward(request, response);
    }

    private void listUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> listUsers = new UserModel().listUsers(dataSource);
        request.setAttribute("listUsers", listUsers);
        request.setAttribute("title", "List of Users");
        request.getRequestDispatcher("listUsers.jsp").forward(request, response);
    }
}
