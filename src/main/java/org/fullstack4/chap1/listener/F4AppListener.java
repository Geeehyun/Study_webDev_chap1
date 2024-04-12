package org.fullstack4.chap1.listener;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@Log4j2
@WebListener
public class F4AppListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("===========int===========");

        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("appName", "Fullstack4");
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("===========destroyed===========");
    }
}
