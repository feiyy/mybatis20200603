import com.neuedu.mapper.EmpMapper;
import com.neuedu.po.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;

public class TestMybatis2 {

    @Test
    public void test1() {
        //inputstream
        try {
           InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

           //create sqlSessionFactory
           SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

           //get sqlsession using this factory
           SqlSession session = factory.openSession();

           EmpMapper empMapper = session.getMapper(EmpMapper.class);

           //get one emp
           Emp e = empMapper.selectEmp(7369);

           System.out.println(e.getEmpno()+"\t" + e.getEname()+"\t"+e.getHiredate());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        //inputstream
        try {
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

            //create sqlSessionFactory
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

            //get sqlsession using this factory
            SqlSession session = factory.openSession();

            EmpMapper empMapper = session.getMapper(EmpMapper.class);

            //get one emp
            List<Emp> list = empMapper.selectEmpByName("SMITH");
            list.forEach(emp -> {
                System.out.println(emp.getEmpno() + "\t" + emp.getEname());
            });


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        //inputstream
        try {
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

            //create sqlSessionFactory
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

            //get sqlsession using this factory
            SqlSession session = factory.openSession();

            EmpMapper empMapper = session.getMapper(EmpMapper.class);

            Emp e = new Emp();
            e.setDeptno(10);
            e.setEname("test");
            e.setHiredate(new Date(System.currentTimeMillis()));
            e.setJob("security");
            e.setMgr(7369);
            e.setSal(5000);

            empMapper.insertEmp(e);

            System.out.println(e.getEmpno());

            //commit for insert, update, delete
            session.commit();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4() {
        //inputstream
        try {
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

            //create sqlSessionFactory
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

            //get sqlsession using this factory
            SqlSession session = factory.openSession();

            EmpMapper empMapper = session.getMapper(EmpMapper.class);

            empMapper.updateEmp("test2",7938);

            //commit for insert, update, delete
            session.commit();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test5() {
        //inputstream
        try {
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

            //create sqlSessionFactory
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

            //get sqlsession using this factory
            SqlSession session = factory.openSession();

            EmpMapper empMapper = session.getMapper(EmpMapper.class);

            empMapper.deleteEmp(7938);

            //commit for insert, update, delete
            session.commit();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test6() {
        //inputstream
        try {
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

            //create sqlSessionFactory
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

            //get sqlsession using this factory
            SqlSession session = factory.openSession();

            EmpMapper empMapper = session.getMapper(EmpMapper.class);

            List<Emp> emps = empMapper.selectEmpByCondition("empno",7369);

            for(Emp e :emps)
            {
                System.out.println(e.getEmpno()+"\t"+e.getEname());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}
