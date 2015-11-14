package ru.loryPress;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * Created by andriell on 12.11.15.
 */
public class RequestInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Enumeration<String> headNames = req.getHeaderNames();
        String url = req.getRequestURI();
        if (req.getQueryString() != null) {
            url += "?" + req.getQueryString();
        }
        out.println(req.getMethod() + " " + url + " "  + req.getProtocol());
        while (headNames.hasMoreElements()) {
            String headName = headNames.nextElement();
            out.println(headName + ": " + req.getHeader(headName));
        }
        out.println();
        out.println("Parameters");
        Enumeration<String> getParam = req.getParameterNames();
        while(getParam.hasMoreElements()) {
            String paramName = getParam.nextElement();
            String[] paramValues = req.getParameterValues(paramName);
            String paramValue = paramValues[0];
            if (paramValues.length > 1) {
                paramValue = Arrays.toString(paramValues);
            }
            out.println(paramName + " = " + paramValue);
        }

        out.println();
        out.println("Attributes");
        Enumeration<String> getAttr = req.getAttributeNames();
        while(getAttr.hasMoreElements()) {
            String paramName = getAttr.nextElement();
            out.println(paramName + " = " + req.getAttribute(paramName));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);

    }
}
