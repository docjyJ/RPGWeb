package fr.docjyj.rpgweb.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;

@WebServlet("/file/*")
public class GetFile extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        File file = new File(request.getServletContext().getRealPath("/") + "WEB-INF/file/" + URLDecoder.decode(request.getPathInfo().substring(1), "UTF-8"));
        response.setHeader("Content-Type", request.getServletContext().getMimeType(file.getPath()));
        response.setHeader("Content-Length", String.valueOf(file.length()));
        response.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
        Files.copy(file.toPath(), response.getOutputStream());
    }
}
