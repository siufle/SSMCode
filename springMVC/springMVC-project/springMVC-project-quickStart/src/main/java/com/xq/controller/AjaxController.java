package com.xq.controller;

import com.xq.pojo.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//@RestController 相当于 @Controller+@ResponseBody
@Controller
@RequestMapping("demo2")
public class AjaxController {

    @RequestMapping("testAjax")
    public @ResponseBody Account testAjax(@RequestBody Account account) {
        account.setName("james");
        account.setMoney(1500.0);
        return account;
    }
    /*public void testAjax(@RequestBody Map<String,Object> map) {
        System.out.println(map);
    }*/

    @RequestMapping("testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity) {
        System.out.println(requestEntity.getBody());
        return "success";
    }

    @RequestMapping("findAll")
    public ResponseEntity<List<Account>> findAll() {
        try {
            List<Account> accountList = new ArrayList<>();
            accountList.add(new Account(1001,"li1",800.0));
            accountList.add(new Account(1001,"li2",800.0));
            accountList.add(new Account(1001,"li3",800.0));
            if(CollectionUtils.isEmpty(accountList)){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.ok(accountList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
