package com.project.web;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import com.project.dao.MeetingDao;

@WebServlet("/scheduleMeeting")
public class ScheduleMeetingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MeetingDao meetingDao;

    public void init() {
        meetingDao = new MeetingDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = (String) request.getSession().getAttribute("username");
        String participant = request.getParameter("participant");
        String date = request.getParameter("date");
        String topic = request.getParameter("topic");
        meetingDao.scheduleMeeting(user, participant, date, topic);
        response.sendRedirect("meetings");
    }
}
