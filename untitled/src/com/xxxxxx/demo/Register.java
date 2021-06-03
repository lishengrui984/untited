package com.xxxxxx.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/register")
public class Register extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        String uname = request.getParameter("username");
        String upwdOne = request.getParameter("userpasswordOne");
        String upwdTwo = request.getParameter("userpasswordTwo");
        if (uname == null || "".equals(uname.trim())) {
            request.setAttribute("msg", "用户名不能为空");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }
        if (upwdOne == null || "".equals(uname.trim())) {
            request.setAttribute("msg", "密码不能为空");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }
        if (upwdTwo == null || "".equals(uname.trim()) || !upwdOne.equals(upwdTwo)) {
            request.setAttribute("msg", "密码错误");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }
        if(!add(uname,upwdOne)){
            request.setAttribute("msg", "用户已存在");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
        request.getSession().setAttribute("uname", uname);
        response.sendRedirect("login.jsp");
    }

    public boolean add(String name, String password) {
        boolean flag=existence(name,password);
        if(flag){
            return false;
        }
        Connection conn=null;
        PreparedStatement preStmt=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/work";
            conn = DriverManager.getConnection(url, "root", "root");
            String sql="INSERT INTO tb_user(userName,userPwd)"+"VALUES(?,?)";
            preStmt =conn.prepareStatement(sql);
            preStmt.setString(1,name);
            preStmt.setString(2,password);
            preStmt.executeUpdate();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            if(preStmt!=null){
                try{
                    preStmt.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
                preStmt=null;
            }
            if(conn!=null){
                try{
                    conn.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
                conn=null;
            }
            return true;
        }
    }

    public boolean existence(String uname, String upwd) {
        String name=null;
        String password=null;
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/work";
            conn = DriverManager.getConnection(url, "root", "root");
            stmt = conn.createStatement();
            String sql = "SELECT * FROM tb_user";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                if (rs.getString("userName").equals(uname)) {
                    name = rs.getString("userName");
                    password = rs.getString("userPwd");
                } else {
                    continue;
                }
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
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                stmt = null;
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                conn = null;
            }
            if(uname.equals(name)&&upwd.equals(password)){
                return true;
            }else{
                return false;
            }
        }
    }
}
