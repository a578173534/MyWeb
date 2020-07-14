package com.ggs.controller;

import com.ggs.dao.QuestionDao;
import com.ggs.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionUpdateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDao dao = new QuestionDao();
        //1.调用请求对象读取请求头参数信息
        String title = request.getParameter("title");
        String optionA = request.getParameter("optionA");
        String optionB = request.getParameter("optionB");
        String optionC = request.getParameter("optionC");
        String optionD = request.getParameter("optionD");
        String answer = request.getParameter("answer");
        String questionId = request.getParameter("questionId");
        //2.调用Dao实现更新操作
        Question question = new Question(Integer.valueOf(questionId), title, optionA, optionB, optionC, optionD, answer);
        int result = dao.update(question);
        //3.调用info.jsp将操作结果写入到响应体
        if (result == 1) {
            request.setAttribute("info", "试题更新成功");
        } else {
            request.setAttribute("info", "试题更新失败");
        }
        request.getRequestDispatcher("/info.jsp").forward(request, response);
    }
}
