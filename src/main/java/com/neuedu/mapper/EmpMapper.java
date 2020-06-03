package com.neuedu.mapper;

import com.neuedu.po.Emp;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EmpMapper {

    /*@Select("SELECT * FROM emp WHERE empno = #{empno}")*/
    public Emp selectEmp(int empno);

   /* @Select("SELECT * FROM emp")*/
    public List<Emp> selectAllEmp();

    public List<Emp> selectEmpByName(String ename);

    public void insertEmp(Emp e);
}
