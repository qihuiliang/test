package com.cheer.dao.impl;

import com.cheer.bean.Dept;
import com.cheer.bean.Emp;
import com.cheer.dao.EmpDao;
import com.cheer.util.DBUtil;
import com.cheer.util.Page;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    public void insert(Emp emp) {
        String insertSql = "insert into tbl_emp values(?,?,?,?,?,?,?,?)";
        Connection connection = DBUtil.getInstance().getConnection();
        PreparedStatement preparedStatement= null;
        try {
            preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setInt(1,emp.getEmpno());
            preparedStatement.setString(2,emp.getEname());
            preparedStatement.setString(3,emp.getJob());
            preparedStatement.setInt(4,emp.getMgr());
            preparedStatement.setString(5,emp.getHiredate());
            preparedStatement.setDouble(6,emp.getSal());
            preparedStatement.setDouble(7,emp.getCom());
            preparedStatement.setInt(8,emp.getDeptno());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.getInstance().closeAll(connection,preparedStatement,null);
        }
    }

    public void update(Emp emp) {
        String updateSql = "update tbl_emp set ename=?,job=?,mgr=?,hiredate=?,sal=?,com=?,deptno=? where empno=?";
        Connection connection = DBUtil.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(updateSql);
            preparedStatement.setString(1,emp.getEname());
            preparedStatement.setString(2,emp.getJob());
            preparedStatement.setInt(3,emp.getMgr());
            preparedStatement.setString(4,emp.getHiredate());
            preparedStatement.setDouble(5,emp.getSal());
            preparedStatement.setDouble(6,emp.getCom());
            preparedStatement.setInt(7,emp.getDeptno());
            preparedStatement.setInt(8,emp.getEmpno());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.getInstance().closeAll(connection,preparedStatement,null);
        }
    }

    public void delete(Integer empno) {
        String deleteSql = "delete from tbl_emp where empno=?";
        Connection connection = DBUtil.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1,empno);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Emp select(Integer empno) {
        String selectSql = " select * from tbl_emp where empno =?";
        Connection connection = DBUtil.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet= null;
        Emp emp = null;
       // Dept dept = new Dept();
        try {
            preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1,empno);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                emp = new Emp();
                emp.setEmpno(resultSet.getInt("empno"));
                emp.setEname(resultSet.getString("ename"));
                emp.setJob(resultSet.getString("job"));
                emp.setMgr(resultSet.getInt("mgr"));
                emp.setHiredate(resultSet.getString("hiredate"));
                emp.setSal(resultSet.getInt("sal"));
                emp.setCom(resultSet.getDouble("com"));
                emp.setDeptno(resultSet.getInt("deptno"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.getInstance().closeAll(connection,preparedStatement,resultSet);
        }
        return emp;
    }

    public List<Emp> selectAll() {
        String selectAllSql = "select * from tbl_emp e left join tbl_dept d on e.deptno = d.deptno";
        Connection connection = DBUtil.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Emp> empList = new ArrayList<Emp>();
        Emp emp = null;
        Dept dept = null;
        try{
            preparedStatement = connection.prepareStatement(selectAllSql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                emp = new Emp();
                empList.add(emp);
                emp.setEmpno(resultSet.getInt("empno"));
                emp.setEname(resultSet.getString("ename"));
                emp.setJob(resultSet.getString("job"));
                emp.setMgr(resultSet.getInt("mgr"));
                emp.setHiredate(resultSet.getString("hiredate"));
                emp.setSal(resultSet.getInt("sal"));
                emp.setCom(resultSet.getDouble("com"));
                emp.setDeptno(resultSet.getInt("deptno"));
                /*dept = new Dept();
                emp.setDept(dept);
                dept.setDeptno(resultSet.getInt("deptno"));
                dept.setDname(resultSet.getString("dname"));
                dept.setLoc(resultSet.getString("loc"));*/
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.getInstance().closeAll(connection,preparedStatement,resultSet);
        }
        return empList;
    }

    public List<Emp> getPage(Page page) {
        List<Emp> empList = new ArrayList<Emp>();
        Emp emp  = null;
        String getPageSql = "select * from tbl_emp e order by e.empno limit ?,?";
        Connection connection = DBUtil.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(getPageSql);
            //起始行
            preparedStatement.setInt(1,page.getStartRow());
            // 每页显示条数
            preparedStatement.setInt(2,page.getPageSize());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                emp = new Emp();
                emp.setEmpno(resultSet.getInt("empno"));
                emp.setEname(resultSet.getString("ename"));
                emp.setJob(resultSet.getString("job"));
                emp.setMgr(resultSet.getInt("mgr"));
                emp.setHiredate(resultSet.getString("hiredate"));
                emp.setSal(resultSet.getInt("sal"));
                emp.setCom(resultSet.getDouble("com"));
                emp.setDeptno(resultSet.getInt("deptno"));
                empList.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.getInstance().closeAll(connection,preparedStatement,resultSet);
        }
        return empList;
    }

    public int getCount() {
        String getCountSql = "select count(*) from tbl_emp";
        Connection connection = DBUtil.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int result=0;
        try {
            preparedStatement = connection.prepareStatement(getCountSql);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                result = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.getInstance().closeAll(connection,preparedStatement,resultSet);
        }
        return result;
    }
}
