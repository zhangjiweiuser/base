package com.example.base.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

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
