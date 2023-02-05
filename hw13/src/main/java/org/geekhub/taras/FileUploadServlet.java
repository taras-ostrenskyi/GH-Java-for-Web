package org.geekhub.taras;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FileUploadServlet", urlPatterns = { "/fileuploadservlet" })
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)

public class FileUploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setHeader("Content-Type", "text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html> \n" +
                "<html> \n" +
                "<head> \n" +
                "<title> Java File Upload Servlet </title> \n" +
                "</head> \n" +
                "<body>\n" +
                "\n" +
                "  <form method=\"post\" action=\"fileuploadservlet\" enctype=\"multipart/form-data\">\n" +
                "    <input type=\"file\" name=\"file\" />\n" +
                "    <input type=\"submit\" value=\"Upload\" />\n" +
                "  </form>\n" +
                "\n" +
                "</body>\n" +
                "</html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        for (Part part : request.getParts()) {
            part.write("C:\\upload\\" + fileName);
        }
        response.getWriter().print("The file uploaded successfully.");
    }
}