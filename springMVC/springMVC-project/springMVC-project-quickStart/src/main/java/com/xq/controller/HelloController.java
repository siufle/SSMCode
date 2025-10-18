package com.xq.controller;

import com.xq.pojo.Account;
import com.xq.pojo.Student;
import com.xq.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("demo1") //一级路径
@SessionAttributes(value = {"username","password","age"}) //指定session域中存储的数据
public class HelloController {

    /**
     * @RequestMapping 最多可以有三个参数
     *   1.value/path 表示请求资源的url地址
     *   2.method 表示指定某个请求方法请求资源 如果不是指定的方法会报405异常
     *   3.params 表示请求资源时必须携带的参数 如果不携带会报400异常
     */
    @RequestMapping(value = "hello",method = RequestMethod.GET,params = {"name","age"})
    public String hello() {
        return "success";
    }

    @RequestMapping("getBasicParam")
    public String getBasicParam(String name ,Integer age) {
        System.out.println(name);
        System.out.println(age);
        return "success";
    }

    //获取前端提交的表单数据
    @RequestMapping("getPojoParams")
    public String getPojoParams(Account account) {
        System.out.println(account);
        return "success";
    }

    @RequestMapping("findUser")
    public String findUser(User user) {
        System.out.println(user);
        return "success";
    }

    //获取前端传递的日期类型的参数 @DateTimeFormat按照指定格式将数据转化为日期
    @RequestMapping("getDate")
    public String getDate(@DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        System.out.println(date);
        return "success";
    }

    //通过自定义数据转换器进行数据类型的转换
    @RequestMapping("getDate2")
    public String getDate2(Date date) {
        System.out.println(date);
        return "success";
    }

    @RequestMapping("testServletAPI")
    public void testServletAPI(HttpServletRequest request, HttpServletResponse response) {
        try {
            String name = request.getParameter("name");
            String age = request.getParameter("age");
            System.out.println(name + "-----" + age);
            response.sendRedirect("/pages/success.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @RequestParam注解 用于将前后端参数绑定
     *      value/name 表示前端所要绑定的参数的名称
     *      required 表示该参数是否是必须的 true表示必须 若缺少会报400的异常 false表示非必须
     *      defaultValue 表示为当前参数设定默认值 若前端没有提交该参数则使用默认值
     */
    @RequestMapping("testRequestParam")
    public String testRequestParam(@RequestParam(value = "username", required = false, defaultValue = "keven") String name,
                                   @RequestParam(value = "age", required = false, defaultValue = "18") Integer age) {
        System.out.println(name + "-----" + age);
        return "success";
    }

    //测试RequestBody注解
    @RequestMapping("testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println(body);
        return "success";
    }

    //测试testRequestHeader注解
    @RequestMapping("testRequestHeader")
    public String testRequestHeader(@RequestHeader("accept-language") String head){
        System.out.println(head);
        return "success";
    }

    //测试CookieValue注解的使用
    @RequestMapping("testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String cookie){
        System.out.println(cookie);
        return "success";
    }

    //存数据
    @RequestMapping("putSession")
    public String putSession(Model model){
        model.addAttribute("username","kobe");
        model.addAttribute("password","kobe123");
        model.addAttribute("age","38");
        return "success";
    }

    //获取数据
    @RequestMapping("getSession")
    public String getSession(ModelMap modelMap){
        Object username = modelMap.get("username");
        Object password = modelMap.get("password");
        Object age = modelMap.get("age");
        System.out.println(username);
        System.out.println(password);
        System.out.println(age);
        return "success";
    }

    //清空session域中的数据
    @RequestMapping("clearSession")
    public String clearSession(SessionStatus status){
        status.setComplete();//清空session域中的数据
        return "success";
    }

    @ModelAttribute //将前端传来的student缺失的部分补齐
    /*public Student showModel(String username,Integer age){
        System.out.println(username + "-----" + age);
        Student student = new Student();
        student.setUsername(username);
        student.setAge(age);
        student.setPassword("admin123");
        return student;
    }*/
    public void showModel(String username, Integer age, Map<String,Object> map){
        System.out.println(username + "-----" + age);
        Student student = new Student();
        student.setUsername(username);
        student.setAge(age);
        student.setPassword("admin123456");
        map.put("student",student);
    }

    @RequestMapping("showStudent")
    public String showStudent(@ModelAttribute("student") Student student){
        System.out.println(student);
        return "success";
    }

    //测试PathVariable注解
    @RequestMapping("testPathVariable/{id}/{username}")
    public String testPathVariable(@PathVariable("id") Integer id,@PathVariable("username") String username){
        System.out.println(id + "-----" + username);
        return "success";
    }

    @RequestMapping("testMatrixVariable/{id}")
    public String testMatrixVariable(@PathVariable("id") Integer id,
                                     @MatrixVariable("username") String username,
                                     @MatrixVariable("ages") List<Integer> ages){
        System.out.println(id);
        System.out.println(username);
        System.out.println(ages);
        return "success";
    }
}
