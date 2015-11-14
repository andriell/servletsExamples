package ru.loryPress;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * Created by andriell on 14.11.15.
 */
public class TrimFilter implements Filter {
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("TrimFilter.init");
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("TrimFilter.doFilter");
        if (! (servletRequest instanceof HttpServletRequest && servletResponse instanceof HttpServletResponse)) {
            filterChain.doFilter(servletRequest, servletResponse);
        }

        HttpServletRequest req = (HttpServletRequest) servletRequest;

        Enumeration<String> getParam = req.getParameterNames();
        while(getParam.hasMoreElements()) {
            String paramName = getParam.nextElement();
            String[] paramValues = req.getParameterValues(paramName);
            for (int i = 0; i < paramValues.length; i++) {
                paramValues[i] = paramValues[i].trim();
            }
            req.setAttribute(paramName + "_all", paramValues);
            req.setAttribute(paramName + "_first", paramValues[0]);
        }

        filterChain.doFilter(req, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("TrimFilter.destroy");
    }
}
