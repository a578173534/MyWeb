<%@ page import="com.ggs.entity.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/13
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--制造数据-->
<%
    Student stu1 = new Student(10, "mike");
    Student stu2 = new Student(20, "allen");
    Student stu3 = new Student(30, "smith");
    List<Student> list = new ArrayList<>();
    list.add(stu1);
    list.add(stu2);
    list.add(stu3);
%>
<!--数据输出-->
<table border="2" align="center">
    <tr>
        <td>学员编号</td>
        <td>学员姓名</td>
    </tr>
    <%
        for (Student stu : list) {
    %>
    <tr>
        <td><%=stu.getSid()%></td>
        <td><%=stu.getSname()%></td>
    </tr>
    <%
        }
    %>
</table>

