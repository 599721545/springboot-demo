package com.example.demo.study.jdbc;


import com.example.demo.study.jdbc.bean.User;
import com.example.demo.study.jdbc.service.JdbcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@EnableAutoConfiguration
public class JdbcController {
    @Autowired
    private JdbcService jdbcService;

    @ResponseBody
    @RequestMapping(value = "/jdbc/createUser")
    public Map<String,Object> createUser(String name, Integer age){
        Map<String,Object> resultMap=new HashMap<String,Object>();
        jdbcService.createUser("袁亚洲",2);
        resultMap.put("errorCode","00000");
        resultMap.put("errorMsg","新增成功");
        return  resultMap;
    }


    /**
     * @Description:查询所有用户信息
     * 访问地址：http://localhost:8080/users/findAll
     * @param request
     * @return
     */
    @RequestMapping("/users/findAll")
    public String findAll(HttpServletRequest request) {
        System.out.println("查询所有用户信息");
        List<User> userList = jdbcService.findAll();
        if(userList.size()>0) {
            System.out.println("查询用户信息成功");
        }
        request.setAttribute("userList", userList);
        return "list";
    }
    /**
     * @Description:根据用户ID查询用户信息
     * 访问地址：http://localhost:8080/users/findById?userId=xx
     * @param request
     * @param userId
     * @return 返回用户详情页面
     */
    @RequestMapping("/users/findById")
    public String findById(HttpServletRequest request,@RequestParam("userId") int userId) {
        System.out.println("根据用户ID查询用户信息");
        User user = jdbcService.findById(userId);
        if(user!=null) {
            System.out.println("查询用户成功！");
            request.setAttribute("user", user);
            request.setAttribute("message", "查询");
            return "details";
        }else {
            System.out.println("查询用户失败!");
            return "error";
        }
    }

    /**
     * @Description:转向新增页面
     * 访问地址：http://localhost:8080/users/insert
     * @return
     */
    @RequestMapping("/users/insert")
    public String insert() {
        System.out.println("转页面");
        return "insert";
    }

    /**
     * @Description:新增用户
     * 访问地址：http://localhost:8080/users/create
     * @param request
     * @param user 传递用户对象参数，在前台页面具体填写了用户的信息(用户名、年龄、性别)
     * @return 返回成功或者失败页面
     */
    @RequestMapping("/users/create")
    public String create(HttpServletRequest request,User user) {
        System.out.println("新增用户");
        int result = jdbcService.create(user.getUserName(), user.getUserAge(), user.getUserSex());
        if(result == 1) {
            System.out.println("新增用户成功！");
            request.setAttribute("message","新增");
            return "success";
        }else {
            System.out.println("新增用户失败!");
            return "error";
        }

    }

    /**
     * @Description:转向修改页面，获取列表页面传递过来的用户参数，然后保存，在修改页面获取展示，然后再进行修改
     * 访问地址：http://localhost:8080/users/toUpdate?userId=xx&userName=xx&userAge=xx&userSex=xx
     * @param request
     * @param userId
     * @param userName
     * @param userAge
     * @param userSex
     * @return 返回修改页面
     */
    @RequestMapping("/users/toUpdate")
    public String toUpdate(HttpServletRequest request, @RequestParam("userId") int userId, @RequestParam("userName") String userName,
                           @RequestParam("userAge") String userAge, @RequestParam("userSex") String userSex) {
        System.out.println("转向更新页面");
        //保存用户信息，传递到更新页面
        request.setAttribute("userId", userId);
        request.setAttribute("userName", userName);
        request.setAttribute("userAge", userAge);
        request.setAttribute("userSex", userSex);
        return "update";
    }

    /**
     * @Description:修改用户，获取用户的信息，先展示在页面上，然后用户进行修改
     * 访问地址：http://localhost:8080/users/update
     * @param user 获取页面的用户信息参数
     * @return 返回成功或者失败页面
     */
    @RequestMapping("/users/update")
    public String update(HttpServletRequest request,User user) {
        System.out.println("修改用户"+user);
        int result = jdbcService.update(user.getUserName(), user.getUserAge(), user.getUserSex(),user.getUserId());
        if(result == 1) {
            System.out.println("修改用户成功！");
            request.setAttribute("message","修改");
            return "success";
        }else {
            System.out.println("修改用户失败!");
            return "error";
        }
    }

    /**
     * @Description:根据用户ID删除用户信息
     * 访问地址：http://localhost:8080/users/delete?userId=xx
     * @param request
     * @param userId
     * @return
     */
    @RequestMapping("/users/delete")
    public String delete(HttpServletRequest request,@RequestParam("userId") int userId) {
        int result = jdbcService.delete(userId);
        if(result == 1) {
            System.out.println("删除用户成功!");
            request.setAttribute("message","删除");
            return "success";
        }else {
            System.out.println("删除用户失败!");
            return "error";
        }

    }
}
