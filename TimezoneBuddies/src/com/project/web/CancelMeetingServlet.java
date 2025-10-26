package com.project.web;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import com.project.dao.MeetingDao;

@WebServlet("/cancelMeeting")
public class CancelMeetingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MeetingDao meetingDao;

    public void init() {
        meetingDao = new MeetingDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("meetingId"));
        meetingDao.cancelMeeting(id);
        response.sendRedirect("meetings");
    }
}
