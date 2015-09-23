package infamous.team.Servlets;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ResultTreeType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Home on 9/16/2015.
 */
@WebServlet(name = "FrontPosts")
public class FrontPosts extends HttpServlet {

    String dburl = "jdbc:mysql://localhost:3306/teaminf";
    String dbclass = "com.mysql.jdbc.Driver";
    String query = "SELECT * FROM articles;";
    String username = "kyle";
    String password = "barry1";



    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<String> articles = new LinkedList<String>();
        String tmp = "";
        try{

            Class.forName(dbclass);
            Connection conn = DriverManager.getConnection(dburl, username, password);
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            articles.add("Empty");
            while(rs.next()){
                    tmp = rs.getString("title");
                    articles.add(tmp);
            }

        } catch (ClassNotFoundException e){ e.printStackTrace(); }
        catch (SQLException e) { e.printStackTrace(); }


        req.setAttribute("articles",articles);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(req,resp);



    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
