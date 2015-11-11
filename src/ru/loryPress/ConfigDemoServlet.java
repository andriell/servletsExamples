package ru.loryPress;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by andriell on 11.11.15.
 */
public class ConfigDemoServlet implements Servlet {
    ServletConfig servletConfig;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
        Enumeration parameters = servletConfig.getInitParameterNames();
        while (parameters.hasMoreElements()) {
            String parameterName = (String) parameters.nextElement();
            System.out.println("Parameter name: " + parameterName);
            System.out.println("Parameter value: " + servletConfig.getInitParameter(parameterName));
        }
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        PrintWriter out = servletResponse.getWriter();
        Enumeration parameters = getServletConfig().getInitParameterNames();
        while (parameters.hasMoreElements()) {
            String parameterName = (String) parameters.nextElement();
            out.println("Parameter name: " + parameterName);
            out.println("Parameter value: " + servletConfig.getInitParameter(parameterName));
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
