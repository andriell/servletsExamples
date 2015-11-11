package ru.loryPress;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by andriell on 11.11.15.
 */
public class WriteContextServlet implements Servlet {
    ServletConfig servletConfig;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    public Object htmlEncode(Object o) {
        return o.toString().replaceAll("<", "&lt;").replaceAll(">", "&gt;");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        ServletContext servletContext = getServletConfig().getServletContext();
        servletContext.setAttribute("myGlobalParameter", "Этот параметр одинаков для всех сервлетов");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
