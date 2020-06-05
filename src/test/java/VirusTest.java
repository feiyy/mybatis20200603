import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.neuedu.po.Province;
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

    @Test
    public void test()
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
            System.out.println(list.size());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
