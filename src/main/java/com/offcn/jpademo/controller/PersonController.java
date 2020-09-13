package com.offcn.jpademo.controller;

import com.offcn.jpademo.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;
@Controller
public class PersonController {
    @GetMapping(path="person")
    public String  indexPage(Model model){
        String message="hello,thymeleaf!";
        Person p =new Person();
        p.setId(1);
        p.setName("李总");
        p.setAge(18);

        Map<String,Object> map =new HashMap<>();
        map.put("src1","1.jpg");
        map.put("src2","2.jpg");

        model.addAttribute("message",message);
        model.addAttribute("person",p);
        model.addAttribute("map",map);
        return "index";
    }

}
