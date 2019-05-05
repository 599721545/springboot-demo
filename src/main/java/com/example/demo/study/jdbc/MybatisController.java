package com.example.demo.study.jdbc;

import com.example.demo.study.jdbc.bean.User;
import com.example.demo.study.jdbc.service.MybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MybatisController {
    @Autowired
    private MybatisService mybatisService;

    @ResponseBody
    @RequestMapping(value = "/mybatis/findByName")
    public Map<String,Object> findByName(String name){
        Map<String,Object> resultMap=new HashMap<String,Object>();
        User user=mybatisService.findByName("袁亚洲");
        resultMap.put("errorCode","00000");
        resultMap.put("errorMsg","查询成功");
        return  resultMap;
    }

    @ResponseBody
    @RequestMapping(value = "/mybatis/insert")
    public Map<String,Object> insert(String name){
        Map<String,Object> resultMap=new HashMap<String,Object>();
        mybatisService.insert("袁亚洲",22);
        resultMap.put("errorCode","00000");
        resultMap.put("errorMsg","新增成功");
        return  resultMap;
    }

}
