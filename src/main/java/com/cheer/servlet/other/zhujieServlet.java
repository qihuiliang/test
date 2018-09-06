package com.cheer.servlet.other;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "zhujie" ,value="/servlet/zhujie")
public class zhujieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost方法被调用");
        /*response.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.print("这是用注解的方式写的代码");*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet方法被调用！");
        this.doPost(request,response);
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("servlet被销毁！");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("初始化方法被调用！");
    }

    public zhujieServlet(){
        System.out.println("构造方法被调用！");
    }
}
