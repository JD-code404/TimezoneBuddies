package com.project.web;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import com.project.dao.UserDao;
import com.project.model.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao;

    public void init() {
        userDao = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String timezone = request.getParameter("timezone");

        User user = new User(name, email, username, password);
        user.setTimezone(timezone);

        try {
            userDao.registerUser(user);
            response.sendRedirect("login.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}