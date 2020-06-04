import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DBUtil {

    public static SqlSession getSqlSession()
    {
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream("mybatis-config.xml");

            //create sqlSessionFactory
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

            //get sqlsession using this factory
            SqlSession session = factory.openSession();

            return session;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
