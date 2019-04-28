package com.example.demo;

import com.example.demo.study.jdbc.bean.User;
import com.example.demo.study.jdbc.service.JdbcService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private JdbcService jdbcService;

    @Test
    public void create() throws Exception {
        // 插入5个用户
        jdbcService.create("a", 1,"男");
        jdbcService.create("b", 2,"男");
        jdbcService.create("c", 3,"男");
        jdbcService.create("d", 4,"男");
        jdbcService.create("e", 5,"男");
    }

    @Test
    public void findAll() {
        List<User> userList = jdbcService.findAll();
        for(User user:userList) {
            System.out.println("用户:"+user);
        }
    }
    /* 运行结果：
        用户:User [userId=1, userName=zoey222, userAge=18, userSex=女]
        用户:User [userId=2, userName=小白xiaobai, userAge=19, userSex=男]
        用户:User [userId=3, userName=小鱼, userAge=20, userSex=女]
        用户:User [userId=4, userName=小黑, userAge=21, userSex=男]
        用户:User [userId=5, userName=a, userAge=1, userSex=男]
        用户:User [userId=6, userName=b, userAge=2, userSex=男]
        用户:User [userId=7, userName=c, userAge=3, userSex=男]
        用户:User [userId=8, userName=d, userAge=4, userSex=男]
        用户:User [userId=10, userName=新增, userAge=1, userSex=男]
     */
    @Test
    public void findById() {
        User user = jdbcService.findById(1);
        System.out.println("用户:"+user);
    }
    /* 运行结果：
            用户:User [userId=1, userName=zoey222, userAge=18, userSex=女]
     */
    @Test
    public void update() {
        int result = jdbcService.update("修改", 100, "男",3);
        if(result == 1) {
            System.out.println("修改成功!");
            User user = jdbcService.findById(3);
            System.out.println(user);
        }else {
            System.out.println("修改失败!");
        }
    }
    /* 运行结果：
           修改成功!
           User [userId=3, userName=修改, userAge=100, userSex=男]
     */
    @Test
    public void delete() {
        int result = jdbcService.delete(8);
        if(result == 1) {
            System.out.println("删除成功!");
        }else {
            System.out.println("删除失败!");
        }
    }
	/* 运行结果：
	   	删除成功!
	 */
}
