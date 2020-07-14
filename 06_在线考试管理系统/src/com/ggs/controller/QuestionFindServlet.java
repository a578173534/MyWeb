package com.ggs.controller;

import com.ggs.dao.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class QuestionFindServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDao dao = new QuestionDao();
        //1.调用DAO对象将查询命令推送到数据库中得到试题信息【List】
        List questionList = dao.findAll();
        //2.通过请求转发，向Tomcat索要question.jsp，将试题信息写入到响应体
        request.setAttribute("key", questionList);
        request.getRequestDispatcher("/question.jsp").forward(request, response);
    }
}
