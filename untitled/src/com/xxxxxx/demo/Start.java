package com.xxxxxx.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/start")
public class Start extends HttpServlet {
  @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.sendRedirect("login.jsp");
    }
}
