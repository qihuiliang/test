package com.cheer.servlet;

import com.cheer.dao.EmpDao;
import com.cheer.dao.impl.EmpDaoImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SelectEmp",value="/servlet/SelectEmp")
public class SelectEmp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter printWriter = response.getWriter();
        Gson gson = new Gson();
        EmpDao empDao = new EmpDaoImpl();
        //获取前台的empno
        Integer empno = Integer.parseInt(request.getParameter("empno"));
        // 获取数据对应的一条数据
        String json = gson.toJson(empDao.select(empno));
        // 获取的数据放到流中，也就是json中
        printWriter.print(json);
        printWriter.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
