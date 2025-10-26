package com.project.web;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import com.project.dao.MeetingDao;
import com.project.model.Meeting;

@WebServlet("/meetings")
public class MeetingListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MeetingDao meetingDao;

    public void init() {
        meetingDao = new MeetingDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = (String) request.getSession().getAttribute("username");
        List<Meeting> meetings = meetingDao.getMeetings(user);
        request.setAttribute("meetings", meetings);
        request.getRequestDispatcher("meetinglist.jsp").forward(request, response);
    }
}
