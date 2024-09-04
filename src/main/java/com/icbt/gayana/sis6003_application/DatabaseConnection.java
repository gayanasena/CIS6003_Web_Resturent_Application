package com.icbt.gayana.sis6003_application;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {
    DatabaseConnection(){

    }

    public String getloginData(String username, String password) {
        String returnData = null;
        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/cis6003_resturent_application");
            String data = "";

            Connection conn = ds.getConnection();

            // Prepare SQL query
            String sql = "SELECT * FROM login WHERE username = ? AND password = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                // Login successful
                if(rs.getString("user_type").equals("Admin")){
                    returnData = rs.getString("user_type");
                }else if(rs.getString("user_type").equals("Admin")){
                    returnData = rs.getString("user_type");
                }else{
                    returnData = "Guest";
                }

            } else {
                // Login failed
                returnData = "<html><body><h1>Login Failed</h1></body></html>";
            }

            rs.close();
            statement.close();
            conn.close();

            return returnData;
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
            return "No data error";
        }
    }
}

