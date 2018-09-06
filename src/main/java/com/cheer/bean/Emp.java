package com.cheer.bean;

public class Emp {
    private Integer empno;
    private String  ename;
    private String job;
    private Integer mgr;
    private String hiredate;
    private double sal;
    private double com;
    private  Integer deptno;
   // private Dept dept;
    public Emp(){}

    public Emp(Integer empno, String ename, String job, Integer mgr, String hiredate, double sal, double com, Integer deptno) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.com = com;
        this.deptno = deptno;
       // this.dept = dept;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public double getCom() {
        return com;
    }

    public void setCom(double com) {
        this.com = com;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

/*    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }*/

    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", mgr=" + mgr +
                ", hiredate='" + hiredate + '\'' +
                ", sal=" + sal +
                ", com=" + com +
                ", deptno=" + deptno +
                '}';
    }
}
