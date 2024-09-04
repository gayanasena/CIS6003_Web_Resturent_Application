package com.icbt.gayana.sis6003_application;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "loginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {
    DatabaseConnection databaseConnection;
    public void init() {
        databaseConnection = new DatabaseConnection();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
//        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String loginResult = databaseConnection.getloginData(username,password);

        PrintWriter out = response.getWriter();

        if(loginResult != null){
            out.println(loginResult);
            if(loginResult.equals("Admin")){
                RequestDispatcher dispatcher = request.getRequestDispatcher("client_main.jsp");
                dispatcher.forward(request, response);
            }else{
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            }
        }else{
            out.println("<html><body><h1>Login data not found </h1></body></html>");
        }

    }

    public void destroy() {
    }
}