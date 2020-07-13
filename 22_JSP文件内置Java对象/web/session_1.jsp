<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/13
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--
JSP文件内置对象:session
类型:HttpSession
作用：JSP文件在运行时，可以session指向当前用户私人储物柜，添加
共享数据，或则读取共享数据
-->

<!--将共享数据添加到当前用户私人储物柜-->
<%
    session.setAttribute("key1", 200);
%>
