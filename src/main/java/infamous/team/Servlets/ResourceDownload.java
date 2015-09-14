package infamous.team.Servlets;

import infamous.team.Config;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class ResourceDownload extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String fileName = req.getPathInfo();
        File file = new File(Config.fileDirectory + File.separator + fileName);

        if(!file.exists())
        {
            resp.setStatus(resp.SC_BAD_REQUEST);
            return;
        }

        OutputStream out = resp.getOutputStream();
        InputStream in = new FileInputStream(file);

        try
        {
            byte [] buffer = new byte[1024];

            int len = 0;
            while((len = in.read(buffer, 0, 1024)) > 0)
                out.write(buffer, 0, len);

            out.flush();

            resp.setStatus(resp.SC_OK);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            resp.setStatus(resp.SC_BAD_REQUEST);
        }
        finally
        {
            if(out != null)
                out.close();
            if(in != null)
                in.close();
        }
    }
}
