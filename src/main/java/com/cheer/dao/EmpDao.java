package com.cheer.dao;

import com.cheer.bean.Emp;
import com.cheer.util.Page;

import java.util.List;

public interface EmpDao {

    void insert(Emp emp);

    void update(Emp emp);

    void delete(Integer empno);

    Emp select(Integer empno);

    List<Emp> selectAll();

    List<Emp> getPage(Page page);

    int getCount();
}
