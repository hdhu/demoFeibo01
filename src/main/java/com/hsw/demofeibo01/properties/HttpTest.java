package com.hsw.demofeibo01.properties;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class HttpTest {

    public Boolean isRequestSuccessful(HttpResponse httpresponse){
        return httpresponse.getStatusLine().getStatusCode()==200;
    }
    public String HttpPost(String param1,String param2,String url) throws Exception{
        Map<String,String> personMap = new HashMap<String,String>();
        personMap.put("param1",param1);
        personMap.put("param1",param2);
        List<NameValuePair> list = new LinkedList<NameValuePair>();
        for(Entry<String,String> entry:personMap.entrySet()){
            list.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));
        }
        HttpPost httpPost = new HttpPost(url);
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(list,"utf-8");
        httpPost.setEntity(formEntity);
        CloseableHttpClient httpCient = HttpClients.createDefault();
        CloseableHttpClient httpClient=httpCient;
        HttpResponse httpresponse = null;
        try{
            httpresponse = httpClient.execute(httpPost);
//            httpresponse = httpCient.executeMethod(HostConfiguration.ANY_HOST_CONFIGURATION, );
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
