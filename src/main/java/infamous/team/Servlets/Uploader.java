package infamous.team.Servlets;

import infamous.team.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.io.*;

public class Uploader extends HttpServlet
{
    private static final Logger log = LoggerFactory.getLogger(Uploader.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        // Allow casual multi-part parsing
        // https://stackoverflow.com/questions/8047173/how-to-enable-multipart-form-data-in-tomcat-7-0-8-server
        resp.setContentType("text/html;charset=UTF-8");

        final Part filePart = req.getPart("file");
        final String fileName = getFileName(filePart);

        File file = new File(Config.fileDirectory + File.separator + fileName);

        // TODO: return error saying file exists
        if(file.exists())
        {
            resp.setStatus(resp.SC_BAD_REQUEST);
            req.getRequestDispatcher("/").forward(req, resp);
            return;
        }

        OutputStream out = null;
        InputStream fileContent = null;
        final PrintWriter writer = resp.getWriter();

        try
        {
            out = new FileOutputStream(new File(Config.fileDirectory + File.separator
                    + fileName));
            fileContent = filePart.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = fileContent.read(bytes)) != -1)
                out.write(bytes, 0, read);

            log.info("File {} being uploaded to {}", fileName, Config.fileDirectory);
        }
        catch (FileNotFoundException fne)
        {
            log.error("Problems during file upload. Error: {}", fne.getMessage());
        }
        finally
        {
            req.getRequestDispatcher("/").forward(req, resp);
            if (out != null)
                out.close();
            if (fileContent != null)
                fileContent.close();
            if (writer != null)
                writer.close();
        }
    }

    private String getFileName(final Part part)
    {
        final String partHeader = part.getHeader("content-disposition");
        log.info("Part Header = {}", partHeader);
        for (String content : part.getHeader("content-disposition").split(";"))
        {
            if (content.trim().startsWith("filename"))
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
        }
        return null;
    }

}
