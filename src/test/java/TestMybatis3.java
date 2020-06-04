import com.neuedu.mapper.SalgradeMapper;
import com.neuedu.po.Salgrade;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

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
}
