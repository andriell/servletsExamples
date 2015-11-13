package ru.loryPress;

import javax.servlet.*;
import java.io.*;

/**
 * Created by andriell on 12.11.15.
 */
public class SingleThreadedServlet implements Servlet {
    public int counter = 0;

    private  ServletConfig servletConfig;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service start " + Thread.currentThread().getName());

        int i = counter;
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        counter = i + 1;

        PrintWriter out = servletResponse.getWriter();
        out.println(counter);

        System.out.println("service end " + Thread.currentThread().getName());
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
