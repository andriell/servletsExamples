package ru.loryPress;

import javax.servlet.*;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by andriell on 14.11.15.
 */
public class LogListener implements ServletContextListener,
        ServletContextAttributeListener,
        HttpSessionListener, HttpSessionAttributeListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContextListener.contextInitialized");

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContextListener.contextDestroyed");
    }


    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("ServletContextAttributeListener.attributeAdded");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("ServletContextAttributeListener.attributeRemoved");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("ServletContextAttributeListener.attributeReplaced");
    }


    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("HttpSessionListener.sessionCreated");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("HttpSessionListener.sessionDestroyed");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("HttpSessionAttributeListener.attributeAdded");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("HttpSessionAttributeListener.attributeRemoved");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("HttpSessionAttributeListener.attributeReplaced");
    }
}
