package groupId;

import com.alibaba.fastjson.JSON;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Demo {
    public static final String URL = "http://localhost:8080/sfm/project/exist";
    /*
     * HttpClient Get请求带参数
     */
    @Test
    public void fun1() throws ClientProtocolException, IOException {
//		1、创建httpClient
        CloseableHttpClient client = HttpClients.createDefault();
//		2、封装请求参数
        List<BasicNameValuePair> list = new ArrayList<>();
        list.add(new BasicNameValuePair("uscc", "1"));
        //3、转化参数
        String params = EntityUtils.toString(new UrlEncodedFormEntity(list, Consts.UTF_8));
        System.out.println(params);
        //4、创建HttpGet请求
        HttpGet httpGet = new HttpGet(URL+"?"+params);
        CloseableHttpResponse response = client.execute(httpGet);
        //5、获取实体
        HttpEntity entity = response.getEntity();
        //将实体装成字符串
        String string = EntityUtils.toString(entity);
        System.out.println(string);
        Map<String,Object> map = JSON.parseObject(string);
        // 设置数据
        Integer data = (Integer) map.get("data");
        System.out.println(data);
        /*RestResp resp = JSON.parseObject(string,RestResp.class);
        Integer data = resp.getData();
        System.out.println(data);*/

        response.close();
    }

}
