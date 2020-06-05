import com.neuedu.mapper.EmpMapper;
import com.neuedu.po.Emp;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Date;
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
}
