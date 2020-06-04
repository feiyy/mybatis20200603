package com.neuedu.mapper;

import com.neuedu.po.Emp;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

public interface EmpMapper {

    /*@Select("SELECT * FROM emp WHERE empno = #{empno}")*/
    public Emp selectEmp(int empno);

   /* @Select("SELECT * FROM emp")*/
    public List<Emp> selectAllEmp();

    public List<Emp> selectEmpByName(String ename);

    public void insertEmp(Emp e);

    public void updateEmp(@Param("ename") String ename, @Param("empno")int empno);

    public void deleteEmp(int empno);

    public List<Emp> selectEmpByCondition(@Param("column") String column, @Param("value")Object value);

    public List<Emp> selectEmpByCondition2(HashMap map);
}
