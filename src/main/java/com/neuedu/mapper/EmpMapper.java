package com.neuedu.mapper;

import com.neuedu.po.Emp;

import java.util.List;

public interface EmpMapper {

    public Emp selectEmp(int empno);

    public List<Emp> selectAllEmp();
}
