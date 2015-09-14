package infamous.team.Servlets;

import infamous.team.Config;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ResourceViewer extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        List<String> files = new LinkedList<String>();

        File resourcesDir = new File(Config.fileDirectory);

        for(File f : resourcesDir.listFiles())
            files.add(f.getName());

        req.setAttribute("files",files);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/viewfiles.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        doGet(req, resp);
    }
}
