import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.neuedu.mapper.ProvinceMapper;
import com.neuedu.po.City;
import com.neuedu.po.Province;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;

public class VirusTest {

    public List<Province> sendHttpRequest()
    {
        try {
            URL url = new URL("http://api.tianapi.com/txapi/ncovcity/index?key=229a8745b39d447b656d775df952443c");
            URLConnection conn =  url.openConnection();
            InputStream in = conn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            StringBuilder builder = new StringBuilder();
            String line = br.readLine();
            while(line!=null)
            {
                builder.append(line);
                line = br.readLine();
            }

            //System.out.println(builder.toString());

            //json str => hashmap
            HashMap map = JSON.parseObject(builder.toString(), HashMap.class);
            JSONArray jsonstr = (JSONArray)map.get("newslist");

            List<Province> list = JSON.parseArray(jsonstr.toJSONString(), Province.class);

            return list;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void test()
    {
       List<Province> list =  sendHttpRequest();

        SqlSession session = DBUtil.getSqlSession();
        ProvinceMapper provinceMapper = session.getMapper(ProvinceMapper.class);
        for(Province p:list)
        {
            provinceMapper.addProvince(p);

            List<City> cities = p.getCities();

            if(cities == null || cities.size() ==0)
            {
                continue;
            }

            for(City c: cities)
            {
                c.setPid(p.getPid());
            }
            //add cities
            provinceMapper.addCity(cities);

        }

        //commit
        session.commit();
    }
}
