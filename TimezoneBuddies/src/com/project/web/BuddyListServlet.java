package com.project.web;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import com.project.dao.BuddyDao;
import com.project.model.Buddy;

@WebServlet("/buddies")
public class BuddyListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BuddyDao buddyDao;

    public void init() {
        buddyDao = new BuddyDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        List<Buddy> buddies = buddyDao.getBuddyList(username);
        request.setAttribute("buddies", buddies);
        RequestDispatcher dispatcher = request.getRequestDispatcher("buddylist.jsp");
        dispatcher.forward(request, response);
    }
}