import com.neuedu.mapper.DeptMapper;
import com.neuedu.mapper.EmpMapper;
import com.neuedu.mapper.SalgradeMapper;
import com.neuedu.mapper.ScoreMapper;
import com.neuedu.po.*;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMybatis3 {

    @Test
    public void test()
    {
       SqlSession session =  DBUtil.getSqlSession();

       SalgradeMapper salgradeMapper = session.getMapper(SalgradeMapper.class);

       List<Salgrade> list = salgradeMapper.getSalAllSalgrade();

       list.forEach(salgrade -> {
           System.out.println(salgrade.getRank()+"\t" + salgrade.getLowsalary()+"\t"+salgrade.getHighsalary());
       });

    }

    @Test
    public void test2()
    {
        SqlSession session =  DBUtil.getSqlSession();

        EmpMapper empMapper = session.getMapper(EmpMapper.class);

        List<HashMap<String, Object>> list = empMapper.getEmpWithDept();

        list.forEach(map -> {
            System.out.println(map.get("empno")+"\t"+map.get("ename") +"\t" + map.get("deptno") +"\t"+map.get("dname"));
        });

    }

    @Test
    public void test3()
    {
        SqlSession session =  DBUtil.getSqlSession();

        EmpMapper empMapper = session.getMapper(EmpMapper.class);

        List<Emp> list = empMapper.getEmpWithDept2();

        list.forEach(e -> {
            System.out.println(e.getEmpno()+"\t"+e.getEname()+"\t"+e.getDept().getDeptno()+"\t"+e.getDept().getDname());
        });

    }

    @Test
    public void test4()
    {
        SqlSession session =  DBUtil.getSqlSession();

        DeptMapper deptMapper = session.getMapper(DeptMapper.class);

        List<Dept> list = deptMapper.getDeptWithEmp();

        list.forEach(d -> {
            System.out.println(d.getDeptno()+"\t"+d.getDname());

            List<Emp> emps = d.getEmps();

            emps.forEach(emp -> {
                System.out.println(emp.getEmpno()+"\t"+emp.getEname());
            });

            System.out.println("============================");
        });

    }

    @Test
    public void test5()
    {
        SqlSession session =  DBUtil.getSqlSession();

        EmpMapper empMapper = session.getMapper(EmpMapper.class);

        List<Emp> list = empMapper.getEmpWidthDeptLazy();

        list.forEach(e -> {
            System.out.println(e.getEmpno()+"\t"+e.getEname());

            Dept d = e.getDept();

            System.out.println(d.getDname());

        });

    }

    @Test
    public void test6()
    {
        SqlSession session =  DBUtil.getSqlSession();

        ScoreMapper scoreMapper = session.getMapper(ScoreMapper.class);
        Student student = scoreMapper.getStudentScores(1);

        student.getScores().forEach(score -> {
            System.out.println(score.getCourse().getCname()+"\t" + score.getScore());
        });

    }

    @Test
    public void test7()
    {
        SqlSession session =  DBUtil.getSqlSession();

        ScoreMapper scoreMapper = session.getMapper(ScoreMapper.class);
        Course course = scoreMapper.getCourseScores(100);

       course.getScores().forEach(score -> {
           System.out.println(score.getStudent().getSname()+"\t"+score.getScore());
       });

    }


}
