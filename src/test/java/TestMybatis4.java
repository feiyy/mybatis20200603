import com.neuedu.mapper.EmpMapper;
import com.neuedu.po.Emp;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.swing.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class TestMybatis4 {

    @Test
    public void test()
    {
        SqlSession session =  DBUtil.getSqlSession();
        EmpMapper empMapper = session.getMapper(EmpMapper.class);

        Emp condition = new Emp();
        condition.setEmpno(7369);
        condition.setEname("%S%");

        List<Emp> list = empMapper.getEmpDynamic(condition);
        list.forEach(emp -> {
            System.out.println(emp.getEname());
        });
    }

    @Test
    public void test2()
    {
        SqlSession session =  DBUtil.getSqlSession();
        EmpMapper empMapper = session.getMapper(EmpMapper.class);

        Emp e = new Emp();
        e.setEmpno(7937);
        e.setEname("YYYY");
        e.setHiredate(Date.valueOf("2020-05-05"));

        empMapper.updateEmpDynamic(e);

        session.commit();
    }

    @Test
    public void test3()
    {
        SqlSession session =  DBUtil.getSqlSession();
        EmpMapper empMapper = session.getMapper(EmpMapper.class);

        int[] empnos = new int[5];
        empnos[0] = 7369;
        empnos[1] = 7499;
        empnos[2] = 7521;
        empnos[3] = 7566;
        empnos[4] = 7654;

        List<Emp> list = empMapper.getEmpByIds(empnos);
        list.forEach(emp -> {
            System.out.println(emp.getEname());
        });

    }

    @Test
    public void test4()
    {
        SqlSession session =  DBUtil.getSqlSession();
        EmpMapper empMapper = session.getMapper(EmpMapper.class);

        List<Integer> empnos = new ArrayList<>();
        empnos.add(7369);
        empnos.add(7499);
        empnos.add(7521);

        List<Emp> list = empMapper.getEmpByIds2(empnos);
        list.forEach(emp -> {
            System.out.println(emp.getEname());
        });

    }
}
