package com.hsw.demofeibo01.service;


import com.hsw.demofeibo01.domain.stu;
import com.hsw.demofeibo01.enums.ResultEnum;
import com.hsw.demofeibo01.exception.StuException;
import com.hsw.demofeibo01.repository.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Optional;


@Service
public class stuService {
    @Autowired
    private stuRepository stuRepository;

    @Transactional
    public void insertTwo() {
        stu stu = new stu();
        stu.setAge(12);
        stuRepository.save(stu);
        stu stu1 = new stu();
        stu1.setAge(13);
        stuRepository.save(stu1);

    }

    public void getAge(Integer id) throws Exception {
      /*   stu stu=new stu();
        stu.setId(id);
        Example<stu> stuExample=Example.of(stu);
        return stuRepository().findOne(stuExample);*/
        Optional<stu> stu1 = stuRepository.findById(id);
        Integer age = stu1.get().getAge();
        if (age < 10) {

            throw new StuException(ResultEnum.PRIMARY_SCHOOL );
        } else if (10 < age && age < 16) {

            throw new StuException(ResultEnum.MIDDLE_SCHOOLE);
        }

    }

    public Optional<stu> findOne(Integer id){
        return  stuRepository.findById(id);
    }


    public String getHTTP(String url ,String authorization){
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


        public void register () {
//        stu stu=new stu();
//        stu.setAge(12);
//        stu.setClazz("e");
//        stuRepository.save(stu);
        }
        public void login (stu stu){
            Integer age = stu.getAge();
            String clazz = stu.getClazz();

        }

}