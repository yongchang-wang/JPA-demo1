package com.offcn.jpademo.controller;

import com.offcn.jpademo.pojo.User;
import com.offcn.jpademo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.model.IModel;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Controller
public class CaseController {
    @Autowired
    private UserService userService;

    @GetMapping(path="findAll")
    public String findAll(Model model){
        List<User> list = userService.findAll();
        model.addAttribute("userList",list);
        return "indexPage";
    }
    //用户点击add按钮，跳转页面
    @RequestMapping("/toAddUser")
    public String addUserPage(){
        return "add";
    }
    //保存新用户
    @PostMapping(path="save")
    public String  saveUser(User user){
        userService.addUser(user);
        return "redirect:/findAll";
    }

    //回显
    @RequestMapping("/backShow/{id}")
    public String backShow(Model model,@PathVariable("id") Long id){
        User u = userService.findUserById(id);
        model.addAttribute("user",u);
        return "update";
    }
    //修改
  @RequestMapping("update")
       public  String update(User user){
        userService.updateUser(user.getId(),user);
        return "redirect:/findAll";
    }
    //删除、
    @RequestMapping ("delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "redirect:/findAll";
    }
    //根据id获取用户
    @GetMapping(path="findUserById")
    public String searchUser(Long id,Model model){
        User user = userService.findUserById(id);
        model.addAttribute("userList",user);
        return "indexPage";
    }



}
