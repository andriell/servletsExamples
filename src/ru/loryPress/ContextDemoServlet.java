package ru.loryPress;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by andriell on 11.11.15.
 */
public class ContextDemoServlet implements Servlet {
    ServletConfig servletConfig;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    public String htmlEncode(String str) {
        return str.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        PrintWriter out = servletResponse.getWriter();
        ServletContext servletContext = getServletConfig().getServletContext();
        Enumeration attributes = servletContext.getAttributeNames();
        out.print("<html>");
        out.print("<head>");
        out.print("</head>");
        out.print("<body>");
        out.print("<table>");
        while (attributes.hasMoreElements()) {
            String attributeName = (String) attributes.nextElement();
            out.print("<tr><td><b>");
            out.println(attributeName);
            out.print("</b></td><td><pre>");
            out.println(( servletContext.getAttribute(attributeName)));
            out.print("</pre></td></tr>");
        }
        out.print("<table>");
        out.println("<br>MajorVersion: " + servletContext.getMajorVersion());
        out.println("<br>MinorVersion: " + servletContext.getMinorVersion());
        out.println("<br>ServerInfo: " + servletContext.getServerInfo());
        out.print("</body>");
        out.print("</html>");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
