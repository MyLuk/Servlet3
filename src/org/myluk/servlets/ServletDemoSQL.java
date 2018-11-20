package org.myluk.servlets;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(value = "/ServletDemoSQL")
public class ServletDemoSQL extends HttpServlet {

    @Resource(name = "jdbc/project")
    private DataSource dataSource;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1. Initialize connection object
        PrintWriter out = response.getWriter();
        out.println("Hello");
        Connection connect = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            connect = dataSource.getConnection();
//        2. Create a SQL statement String
            String query = "Select * from users";
            stmt = connect.createStatement();
//        3. Execute SQL query
            rs = stmt.executeQuery(query);
//        4. Process the result set
            while (rs.next()) out.println(rs.getString("email"));


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
