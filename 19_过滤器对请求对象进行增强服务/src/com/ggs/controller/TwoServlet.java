package com.ggs.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TwoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //直接从请求体读取请求参数
        String userName = request.getParameter("userName");

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print("TwoServlet 从请求体得到参数 " + userName);
    }
}
