package ru.loryPress;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by andriell on 14.11.15.
 */
public class LoginFilter implements Filter {
    private FilterConfig filterConfig;
    private String login = "";
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        login = filterConfig.getInitParameter("login");
        System.out.println("LoginFilter.init " + login);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("LoginFilter.doFilter");
        if (! (servletRequest instanceof HttpServletRequest && servletResponse instanceof HttpServletResponse)) {
            filterChain.doFilter(servletRequest, servletResponse);
        }

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String login = (String) request.getSession().getAttribute("login");
        login = login == null ? "" : login;

        if (login.equals(this.login)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            filterConfig.getServletContext().getRequestDispatcher("/login").forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("LoginFilter.destroy");
    }
}
