package com.project.web;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import com.project.dao.ProfileDao;
import com.project.model.Profile;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProfileDao profileDao;

    public void init() {
        profileDao = new ProfileDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        Profile profile = profileDao.getProfile(username);
        request.setAttribute("profile", profile);
        RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String timezone = request.getParameter("timezone");
        String username = (String) request.getSession().getAttribute("username");
        profileDao.updateProfile(username, email, phone, timezone);
        response.sendRedirect("profile?updated=true");
    }
}
