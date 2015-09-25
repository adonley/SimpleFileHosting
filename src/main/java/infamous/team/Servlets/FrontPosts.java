package infamous.team.Servlets;

import infamous.team.Config;

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

@WebServlet(name = "FrontPosts")
public class FrontPosts extends HttpServlet {

    protected String query = "SELECT * FROM articles;";

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<String> articles = new LinkedList<String>();
        String tmp = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Config.dburl, Config.username, Config.password);
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            articles.add("Empty");
            while(rs.next()){
                    tmp = rs.getString("title");
                    articles.add(tmp);
            }

        }
        catch (SQLException e) { e.printStackTrace(); }
        catch (ClassNotFoundException e) { e.printStackTrace(); }


        req.setAttribute("articles", articles);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(req,resp);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
