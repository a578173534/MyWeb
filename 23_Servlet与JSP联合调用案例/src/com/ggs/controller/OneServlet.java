package com.ggs.controller;

import com.ggs.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OneServlet extends HttpServlet {
    //处理业务，得到处理结果-----查询学员信息
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student s1 = new Student(10, "mike");
        Student s2 = new Student(20, "allen");
        List<Student> stuList = new ArrayList<>();
        stuList.add(s1);
        stuList.add(s2);
        //将处理结果添加到请求作用域对象
        request.setAttribute("key", stuList);
        //通过请求转发方案，向Tomcat申请调用user_show.jsp
        //同时将request与response通过tomcat交给user_show.jsp使用
        request.getRequestDispatcher("/user_show.jsp").forward(request, response);
    }
}
