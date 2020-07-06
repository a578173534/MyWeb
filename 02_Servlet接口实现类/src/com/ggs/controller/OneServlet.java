package com.ggs.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * 抽象类作用：降低接口实现类对接口实现过程难度
 *            将接口中不需要使用抽象方法交给抽象类进行完成
 *            这样接口实现类只需要对接口需要方法进行重写
 *      servlet接口：
 *                  init
 *                  getServletConfig
 *                  getServletInfo
 *                  destroy-------------------四个方法对于Servlet接口实现类没有
 *
 *                  service()------有用
 *
 *   Tomcat根据Servlet规范调用Servlet接口实现类规则：
 *                  1.Tomcat有权创建Servlet接口实现类实例对象
 *                  Servlet oneServlet = new OneServlet();
 *                  2.Tomcat根据实例对象调用service方法处理当前请求
 *                  oneServlet.service()
 *                  extends                            extends                          implements
 *    oneServlet--------------->(abstract)HttpServlet-------->(abstract)GenericServlet--------->servlet接口
 *                                                                    init
 *                                                                    destory
 *                                                                    getServletInfo
 *                                                                    getServletConfig
 *
 *  通过父类决定在何种情况下调用子类中方法------------【设计模式】-------模板设计模式
 */
public class OneServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(" OneServlet类针对浏览器发送GET请求方式处理");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(" OneServlet类针对浏览器发送POST请求方式处理");
    }
}
