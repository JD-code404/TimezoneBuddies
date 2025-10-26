package com.project.web;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import com.project.dao.BuddyDao;

@WebServlet("/addBuddy")
public class AddBuddyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BuddyDao buddyDao;

    public void init() {
        buddyDao = new BuddyDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String currentUser = (String) request.getSession().getAttribute("username");
        String friend = request.getParameter("friend");
        buddyDao.addBuddy(currentUser, friend);
        response.sendRedirect("buddies");
    }
}