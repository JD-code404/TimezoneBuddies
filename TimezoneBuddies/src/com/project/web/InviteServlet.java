package com.project.web;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import com.project.dao.InviteDao;
import com.project.model.Invite;

@WebServlet("/invite")
public class InviteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private InviteDao inviteDao;

    public void init() {
        inviteDao = new InviteDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sender = (String) request.getSession().getAttribute("username");
        String receiver = request.getParameter("receiver");
        int meetingId = Integer.parseInt(request.getParameter("meetingId"));
        inviteDao.sendInvite(sender, receiver, meetingId);
        response.sendRedirect("meetinglist.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        List<Invite> invites = inviteDao.getInvitesForUser(username);
        request.setAttribute("invites", invites);
        RequestDispatcher dispatcher = request.getRequestDispatcher("invites.jsp");
        dispatcher.forward(request, response);
    }
}
