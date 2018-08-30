package com.hsw.demofeibo01.service;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

//import org.apache.commons.httpclient.HttpClient;

@Service
public class CourseService {
    public String getCourse(String url ,String authorization) {

        StringBuilder builder = new StringBuilder();
//       final Static String sfdAthorization;
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);
        request.addHeader("Authorization", authorization);
        try {
            CloseableHttpResponse response = client.execute(request);

            String result = EntityUtils.toString(response.getEntity());//可以很好的处理中文，保证中文没有乱码
            //System.out.println("得到CRM内容:"+result);
//            result.
            return result;

        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "";
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "";
        }
    }

    public class HttpTest {

        public Boolean isRequestSuccessful(HttpResponse httpresponse){
            return httpresponse.getStatusLine().getStatusCode()==200;
        }
        public String HttpPost(String param1,String param2,String url) throws Exception{
            Map<String,String> personMap = new HashMap<String,String>();
            personMap.put("param1",param1);
            personMap.put("param1",param2);
            List<BasicNameValuePair> list = new LinkedList<>();
            for(Entry<String,String> entry:personMap.entrySet()){
                list.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));
            }
            HttpPost httpPost = new HttpPost(url);
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(list,"utf-8");
            httpPost.setEntity(formEntity);
//            HttpClient httpCient = HttpClients.CreatDefault();
            HttpResponse httpresponse = null;
            try{
//                httpresponse = httpClient.execute(httpPost);
                HttpEntity httpEntity = httpresponse.getEntity();
                String response = EntityUtils.toString(httpEntity, "utf-8");
                return response;
            }catch(ClientProtocolException e){
                System.out.println("http请求失败，uri{},exception{}");
            }catch(IOException e){
                System.out.println("http请求失败，uri{},exception{}");
            }
            return null;
        }

    }



}
