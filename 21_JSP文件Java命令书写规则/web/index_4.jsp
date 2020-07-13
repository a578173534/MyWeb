<%@ page import="com.ggs.entity.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/13
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    //创建一个Student类型对象
    Student stu = new Student(10, "mike");
    List list = new ArrayList();
%>

学员编号:<%=stu.getSid()%><br/>
学员姓名:<%=stu.getSname()%>
