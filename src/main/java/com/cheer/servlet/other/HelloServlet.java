package com.cheer.servlet.other;

import com.cheer.bean.Emp;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        String username = request.getParameter("qihuiliang");
        String password = request.getParameter("123456");
        if(username.equals("qihuiliang")&&password.equals("123456")){
            System.out.println("查询成功");
            response.sendRedirect("../html/ajax.html");
        }else{
            System.out.println("查询失败");
            response.sendRedirect("../html/Form.html");
        }
/*        Emp emp1 = new Emp(7369,"1","1",1,"2018",1,1,1);
        List<Emp> list = new ArrayList<Emp>();
        list.add(emp1);
        Gson gson = new Gson();
        String json = gson.toJson(list);*/
//        后台将数据响应给前端
        /*printWriter.print(json);
        printWriter.close();*/

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
