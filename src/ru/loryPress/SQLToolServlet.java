package ru.loryPress;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by andriell on 13.11.15.
 */
public class SQLToolServlet extends HttpServlet {
    String username = "username";
    String password = "password";
    String url = "jdbc:mysql://localhost:3306/test";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletConfig().getServletContext().getRequestDispatcher("/sql-form.html").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PrintWriter out = resp.getWriter();

            String sql = req.getParameter("sql");

            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            if (sql.toUpperCase().trim().startsWith("SELECT")) {
                ResultSet resultSet = statement.executeQuery(sql);
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();

                out.println("<table>");
                out.println("<tr>");
                for (int i = 1; i <= columnCount; i++) {
                    out.println("<td><b>" + metaData.getColumnName(i) + "</b></td>");
                }
                out.println("</tr>");
                while (resultSet.next()) {
                    out.println("<tr>");
                    for (int i = 1; i <= columnCount; i++) {
                        out.println("<td>" + resultSet.getString(i) + "</td>");
                    }
                    out.println("</tr>");
                }
                out.println("</table>");
                resultSet.close();
            } else {
                int i = statement.executeUpdate(sql);
                out.println("Record(s) affected: " + i);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
