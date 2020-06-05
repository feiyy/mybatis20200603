import com.neuedu.mapper.EmpMapper;
import com.neuedu.po.Emp;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

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
}
