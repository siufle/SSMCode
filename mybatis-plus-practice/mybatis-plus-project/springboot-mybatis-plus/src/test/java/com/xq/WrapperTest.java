package com.xq;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xq.mapper.UserMapper;
import com.xq.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class WrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //select * from tb_user where is_delete = 0 and name like ? and age between 20 and 30
        queryWrapper.like("name","a")
                .between("age",20,30);
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void test2() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql("uid","select uid from tb_user where uid <= 3");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void test3() {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("name","jane")
                .set("email","jane@qq.com")
                .eq("uid",1);
        userMapper.update(null,updateWrapper);
    }

    @Test
    public void test4() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        String username = null;
        Integer ageBegin = 18;
        Integer ageEnd = 28;
        queryWrapper.like(StringUtils.isNotBlank(username),"name",username)
                .ge(ageBegin != null,"age",ageBegin)
                .le(ageEnd != null,"age",ageEnd);
        userMapper.selectList(queryWrapper).forEach(System.out::println);
    }

    @Test
    public void test5() {
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(User::getAge,18)
                .set(User::getEmail,"admin@qq.com")
                .like(User::getUserName,"jane")
                .and(i->i.le(User::getAge,20).eq(User::getUid,1));
        userMapper.update(null,updateWrapper);
    }
}
