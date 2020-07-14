package com.ggs.controller;

import com.ggs.dao.QuestionDao;
import com.ggs.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionAddServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDao dao = new QuestionDao();
        //1.调用请求对象读取请求信息，得到新增信息内容
        String title = request.getParameter("title");
        String optionA = request.getParameter("optionA");
        String optionB = request.getParameter("optionB");
        String optionC = request.getParameter("optionC");
        String optionD = request.getParameter("optionD");
        String answer = request.getParameter("answer");
        //2.调用Dao对象将Insert命令推送到数据库，并得到处理结果
        Question question = new Question(null, title, optionA, optionB, optionC, optionD, answer);
        int result = dao.add(question);
        //3.通过请求转发，向Tomcat索要info.jsp将处理结果写入到响应体
        if (result == 1) {
            request.setAttribute("info", "添加试题成功");
        } else {
            request.setAttribute("info", "添加试题失败");
        }
        request.getRequestDispatcher("/info.jsp").forward(request, response);
    }
}
