package com.cheer.servlet;

import com.cheer.bean.Emp;
import com.cheer.dao.impl.EmpDaoImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SelectAllEmp", value="/servlet/SelectAllEmp")
public class SelectAllEmp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("这是一个doPost方法！");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("这是一个doGet方法！");
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter printWriter = response.getWriter();
        // 把数据库中的值拿过来
        EmpDaoImpl empDao = new EmpDaoImpl();
        //转化json对象
        Gson gson = new Gson();
        Emp emp = new Emp();
       // emp.getEmpno();
        String json = gson.toJson(empDao.selectAll());
        //打印到页面上
        printWriter.print(json);
        // 关闭资源流
        printWriter.close();
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("servlet销毁");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("初始化成功！");
    }

    public SelectAllEmp(){
        System.out.println("构造方法被调用！");
    }
}
