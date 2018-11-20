package org.myluk.model;

import org.myluk.entity.User;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserModel {
    @Resource(name = "jdbc/project")
    private DataSource dataSource;

    public List<User> listUsers(DataSource dataSource) {
        List<User> listUsers = new ArrayList<>();
// 1. Initialize connection object
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
            while (rs.next()) {
                int id = rs.getInt("users_id");
                String name = rs.getString("username");
                String email = rs.getString("email");
                listUsers.add(new User(id, name, email));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listUsers;
    }
}
