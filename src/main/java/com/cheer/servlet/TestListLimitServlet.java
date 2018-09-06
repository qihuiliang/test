package com.cheer.servlet;

import com.cheer.bean.Emp;
import com.cheer.dao.EmpDao;
import com.cheer.dao.impl.EmpDaoImpl;
import com.cheer.util.Page;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "TestListLimitServlet", value = "/servlet/TestListLimitServlet")
public class TestListLimitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter  = response.getWriter();
        EmpDao empDao = new EmpDaoImpl();
        String size = request.getParameter("option");
        String number = request.getParameter("no");
        System.out.println("选中了" + size + "当前页是：" + number);
        Integer pageNum = Integer.valueOf(size);
        Integer pageSize = Integer.valueOf(number);
        Page page = new Page(pageNum, pageSize, empDao.getCount());
        List<Emp> empList = empDao.getPage(page);
        Gson gson  = new Gson();
        String json = gson.toJson(empList);
        printWriter.print(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
