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

@WebServlet(name = "InsertEmp",value = "/servlet/InsertEmp")
public class InsertEmp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = response.getWriter();

        //前台插入数据传到后台数据库
        EmpDao empDao = new EmpDaoImpl();
        Emp emp = new Emp();
        emp.setEmpno(Integer.parseInt(request.getParameter("empno")));
        emp.setEname(request.getParameter("ename"));
        emp.setJob(request.getParameter("job"));
        emp.setMgr(Integer.parseInt(request.getParameter("mgr")));
        emp.setHiredate(request.getParameter("hiredate"));
        emp.setSal(Double.parseDouble(request.getParameter("sal")));
        emp.setCom(Integer.parseInt(request.getParameter("com")));
        emp.setDeptno(Integer.parseInt(request.getParameter("deptno")));
        empDao.insert(emp);

        // 转化成json格式
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
