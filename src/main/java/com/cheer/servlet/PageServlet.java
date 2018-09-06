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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "pageServlet",value = "/servlet/pageServlet")
public class PageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter printWriter = response.getWriter();
        // 前台获取的数据
      /*  Integer currentPage = Integer.parseInt(request.getParameter("currentPage"));
        Integer pageSize = Integer.parseInt(request.getParameter("pageSize"));*/
        Integer currentPage = 2;
        Integer pageSize = 3;
        // 后台数据
        EmpDao empDao = new EmpDaoImpl();
        Page page = new Page(pageSize,currentPage,empDao.getCount());
        List<Emp> pageList = empDao.getPage(page);

        //封装到Map集合中
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("currentPage",currentPage);
        map.put("pageSize",pageSize);
        map.put("pageList",pageList);
        map.put("totalPage",page.getTotalPage());

        // map转化成json格式
        Gson gson = new Gson();
        String json = gson.toJson(map);
        printWriter.print(json);
        response.sendRedirect("../Employee.html");
        printWriter.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
