package org.geekhub.taras;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/admin/LogoutServlet")
public class LogoutServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //invalidate the session if exists
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }
        response.sendRedirect(request.getContextPath() + "/loginPage.html");
    }
}
