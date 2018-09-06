package com.cheer.servlet;

import com.cheer.bean.Emp;
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

@WebServlet(name = "DeleteEmp",value = "/servlet/DeleteEmp")
public class DeleteEmp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter printWriter = response.getWriter();
        EmpDao empDao = new EmpDaoImpl();
        Emp emp = new Emp();
        int empno = Integer.parseInt(request.getParameter("empno"));
        empDao.delete(empno);
        Gson gson = new Gson();
        String json = gson.toJson(emp);
        printWriter.print(json);
        response.sendRedirect("../Employee.html");
        printWriter.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
