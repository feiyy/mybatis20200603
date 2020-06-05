import com.neuedu.mapper.EmpMapper;
import com.neuedu.po.Emp;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestMybatis5 {

    @Test
    public void test(){
        SqlSession session =  DBUtil.getSqlSession();

        EmpMapper empMapper = session.getMapper(EmpMapper.class);
        List<Emp> list = empMapper.selectAllEmp();//send sql
        System.out.println(list.size());

        session.commit();

        SqlSession session2 =  DBUtil.getSqlSession();
        EmpMapper empMapper2 = session2.getMapper(EmpMapper.class);
        List<Emp> list2 = empMapper2.selectAllEmp();//don't send sql
        System.out.println(list2.size());
        List<Emp> list3 =empMapper2.selectAllEmp();//don't send sql
        System.out.println(list3.size());

    }

    @Test
    public void test2(){
        SqlSession session =  DBUtil.getSqlSession();

        EmpMapper empMapper = session.getMapper(EmpMapper.class);

        Emp e1 = empMapper.selectEmp(7369);//send sql

        Emp e2 = empMapper.selectEmp(7499);//send sql again

        Emp e3 = empMapper.selectEmp(7369);//don't send sql



    }
}
