package com.ggs.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 2020/7/10
 */
public class OneListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("全局作用域对象产生了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("全局作用域对象被销毁了");
    }
}
