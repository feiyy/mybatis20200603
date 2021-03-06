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

    public List<HashMap<String,Object>> getEmpWithDept();

    public List<Emp> getEmpWithDept2();

    public List<Emp> getEmpWidthDeptLazy();

    public List<Emp> getEmpDynamic(Emp condition);

    public void updateEmpDynamic(Emp e);

    public List<Emp> getEmpByIds(int[] empnos);

    public List<Emp> getEmpByIds2(List<Integer> empnos);

    //empno in (), hiredate bwteen ? and ? => in a hashmap
    public List<Emp> getEmpByIds3(HashMap<String, Object> map);


}
