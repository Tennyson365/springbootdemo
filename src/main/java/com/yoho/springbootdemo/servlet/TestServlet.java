package com.yoho.springbootdemo.servlet;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author: Tennyson
 * E-Mail:wangxing@bailefen.com
 * Project:demo4boot
 * Package:com.yoho.demo.servlet
 * DateTime: 2017/12/19  15:40
 * Description:测试servlet
 */

//不指定name的情况下，name默认值为类全路径，即com.yoho.demo.servlet.TestServlet
@WebServlet(urlPatterns = "/demo/testServlet",displayName = "servlet说明")
@Log4j2
public class TestServlet extends HttpServlet{

    private static final long serialVersionUID = 1474500863728407157L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        log("===============================  doGet  ==============================");
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        log("===============================  doGet  ==============================");
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>servlet test</title>");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("<H1>Hello world!</H1>");
        pw.println("</body>");
        pw.println("</html>");

    }
}
