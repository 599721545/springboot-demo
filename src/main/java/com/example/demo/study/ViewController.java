package com.example.demo.study;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@EnableAutoConfiguration
public class ViewController {

    @ResponseBody
    @RequestMapping("/view/exceptionHandler")
    public Map<String, Object> exceptionHandler() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("errorCode", "101");
        map.put("errorMsg", "系統错误!");
        return map;
    }

    @RequestMapping("/view/index")
    public String index(Map<String, Object> map) {
        map.put("name","美丽的天使...");
        return "index";
    }

    @RequestMapping("/view/index1")
    public String index1(Map<String, Object> map) {
        map.put("name","###蚂蚁课堂###");
        map.put("sex",1);
        List<String> userlist=new ArrayList<String>();
        userlist.add("余胜军");
        userlist.add("张三");
        userlist.add("李四");
        map.put("userlist",userlist);
        return "index1";
    }


    @RequestMapping("/view/login")
    public String index() {
        return "login";
    }

}
