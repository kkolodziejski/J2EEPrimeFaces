package pl.kkolodziejski.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class Listener implements ServletContextListener {
    ServletContext context;

    public void contextInitialized(ServletContextEvent contextEvent) {
        System.out.println("Context created");
        context = contextEvent.getServletContext();
    }

    public void contextDestroyed(ServletContextEvent contextEvent) {
        context = contextEvent.getServletContext();
        System.out.println("Context destroyed");
    }

}
