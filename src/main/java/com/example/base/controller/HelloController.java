package com.example.base.controller;

import com.example.base.entity.UserOrgRelation;
import com.example.base.vo.ResponseVO;
import org.apache.commons.compress.utils.Lists;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 测试接口
 *
 * @Author zjw
 * @Version 1.0
 * @Date 2020/4/27 10:34
 */
@Validated
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }

    @GetMapping("/string")
    public String sayString() {
        return "string";
    }

    @GetMapping("/int")
    public int sayInt() {
        return 1;
    }

    @GetMapping("/boolean")
    public boolean sayBoolean() {
        return true;
    }

    @GetMapping("/long")
    public long sayLong() {
        return 5L;
    }

    @GetMapping("/vo")
    public ResponseVO sayVo() {
        return ResponseVO.success(56);
    }

    @GetMapping("/exception")
    public long sayException() {
        int num = ThreadLocalRandom.current().nextInt(2, 8);
        if (num < 5) {
            throw new RuntimeException();
        }
        return 5L;
    }

    @GetMapping("/getUser")
    public UserOrgRelation getUser() {
        UserOrgRelation relation = new UserOrgRelation();
        relation.setId(1);
        relation.setUserId("A454");
        relation.setOrgId("Org78");
        return relation;
    }

    @GetMapping("/getUsers")
    public List<UserOrgRelation> getUsers() {
        List<UserOrgRelation> relationList = Lists.newArrayList();
        UserOrgRelation relation = new UserOrgRelation();
        relation.setId(1);
        relation.setUserId("A454");
        relation.setOrgId("Org78");
        relationList.add(relation);
        return relationList;
    }

    @GetMapping("/date")
    public String date(Date date1, Date date2,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate local1,
                       @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime local2) {
        System.out.println(date1);
        System.out.println(date2);
        System.out.println(local1);
        System.out.println(local2);
        return "hello";
    }


    @GetMapping("/valid")
    public String valid(@NotBlank(message = "姓名不能为空") String name, @NotBlank String name2) {
        System.out.println(name);
        System.out.println(name2);
        return "hello";
    }
}
