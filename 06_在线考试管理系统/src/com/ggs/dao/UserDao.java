package com.ggs.dao;

import com.ggs.entity.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    // 用户注册
    public int add(Users user) {

        int result = 0;
        Connection c = null;
        PreparedStatement ps = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ggs", "root", "a578173534");
            //将自动提交机制修改为手动提交
            c.setAutoCommit(false);//开启事务
            //获取预编译的数据库操作对象
            ps = c.prepareStatement("insert into users(userName,password,sex,email) values (?,?,?,?)");
            //给？传值
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getSex());
            ps.setString(4, user.getEmail());
            result = ps.executeUpdate();
            //程序能够走到这里说明以上程序没有异常，事务结束，手动提交数据
            c.commit();//提交事务
        } catch (Exception e) {
            //回滚事务
            if (c != null) {
                try {
                    c.rollback();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return result;
    }

    // 查询所有用户信息
    public List findAll() {
        Connection c = null;
        Statement ps = null;
        ResultSet rs = null;
        List<Users> userList = new ArrayList();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ggs", "root", "a578173534");
            ps = c.createStatement();
            rs = ps.executeQuery("select * from users");
            while (rs.next()) {
                Integer userId = rs.getInt("userId");
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String sex = rs.getString("sex");
                String email = rs.getString("email");
                Users users = new Users(userId, userName, password, sex, email);
                userList.add(users);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return userList;
    }

    // 根据用户编号删除用户信息
    public int delete(String userId) {
        Connection c = null;
        PreparedStatement ps = null;
        int result = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ggs", "root", "a578173534");
            c.setAutoCommit(false);
            ps = c.prepareStatement("delete from users where userId=?");
            ps.setInt(1, Integer.valueOf(userId));
            result = ps.executeUpdate();
            c.commit();
        } catch (Exception e) {
            if (c != null) {
                try {
                    c.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    // 登录验证
    public int login(String userName, String password) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ggs", "root", "a578173534");
            ps = c.prepareStatement("select count(*) from users where userName=? and password=?");
            ps.setString(1, userName);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getInt("count(*)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
