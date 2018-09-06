package com.cheer.dao.impl;

import com.cheer.bean.Emp;
import com.cheer.dao.EmpDao;
import com.cheer.util.Page;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class EmpDaoImplTest {

    @Test
    public void insert() {
        EmpDaoImpl empDao = new EmpDaoImpl();
        Emp emp = new Emp();
        emp.setEmpno(15);
        emp.setEname("祁慧亮");
        emp.setJob("董事长");
        emp.setMgr(110);
        emp.setHiredate("1996-07-14");
        emp.setSal(20000.0);
        emp.setCom(50000.0);
        emp.setDeptno(10);
        empDao.insert(emp);
    }

    @Test
    public void update() {
        EmpDaoImpl empDao = new EmpDaoImpl();
        Emp emp = new Emp();
        emp.setEname("祁厅长");
        emp.setEmpno(15);
        empDao.update(emp);
    }

    @Test
    public void delete() {
        EmpDaoImpl empDao = new EmpDaoImpl();
        empDao.delete(15);
    }

    @Test
    public void select() {
        EmpDaoImpl empDao = new EmpDaoImpl();
        System.out.println(empDao.select(15));
    }

    @Test
    public void selectAll() {
        EmpDao empDao = new EmpDaoImpl();
        List<Emp> empList = empDao.selectAll();
        for (Object o:empList) {
            System.out.println(o);
        }
        Assert.assertEquals(15, empList.size());
    }

    @Test
    public void getPage(){
        EmpDao empDao = new EmpDaoImpl();

        // 参数依次为：每页有几条记录，当前是第几页，总共有多少条记录
        Page page = new Page(3,1,empDao.getCount());
        List<Emp> empList = empDao.getPage(page);
        System.out.println(empList);
        for (Object o:empList) {
            System.out.println(o);
        }
    }

    @Test
    public void getCount(){
        EmpDao empDao = new EmpDaoImpl();
        Page page = new Page(1,2,3);
        int a = empDao.getCount();
        System.out.println(a);
    }
}