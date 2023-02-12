package org.geekhub.taras;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private final String username = "admin";
    private final String password = "password";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setHeader("Content-Type", "text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"US-ASCII\">\n" +
                "    <title>Login Page</title>\n" +
                "    <h1>Please login to continue</h1>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<form action=\"LoginServlet\" method=\"post\">\n" +
                "\n" +
                "    Username: <input type=\"text\" name=\"username\">\n" +
                "    <br>\n" +
                "    Password: <input type=\"password\" name=\"pwd\">\n" +
                "    <br><br>\n" +
                "    <input type=\"submit\" value=\"Login\">\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        // get request parameters for username and password
        String username = request.getParameter("username");
        String password = request.getParameter("pwd");

        if (this.username.equals(username) && this.password.equals(password)) {
            //get the old session and invalidate
            HttpSession oldSession = request.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }
            //generate a new session
            HttpSession newSession = request.getSession(true);

            //setting session to expiry in 5 mins
            newSession.setMaxInactiveInterval(5*60);

            Cookie message = new Cookie("message", "Welcome");
            response.addCookie(message);
            response.sendRedirect("LoginSuccess.jsp");
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/loginPage.html");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Either username or password is wrong.</font>");
            rd.include(request, response);
        }
    }
}
