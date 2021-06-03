package com.xxxxxx.demo;


import javax.lang.model.element.NestingKind;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;


@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");

        if (uname == null || "".equals(uname.trim())) {
            request.setAttribute("msg", "用户姓名不能为空");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        if (upwd == null || "".equals(upwd.trim())) {
            request.setAttribute("msg", "用户密码不能为空");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        if (!link(uname, upwd)) {
            request.setAttribute("msg", "登陆失败");
            request.getRequestDispatcher("fail.jsp").forward(request, response);
            return;
        }
        request.getSession().setAttribute("uname", uname);
        response.sendRedirect("index.jsp");
    }



    public boolean link(String uname, String upwd) {
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
