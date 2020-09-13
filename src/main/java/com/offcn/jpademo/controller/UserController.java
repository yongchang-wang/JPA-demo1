package com.offcn.jpademo.controller;

import com.offcn.jpademo.dao.UserRepository;
import com.offcn.jpademo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "addUser")
    public void addUser(@RequestBody User user){
        userRepository.save(user);
    }
    @GetMapping(path="findAll")
    public List<User> findAll(){
        return userRepository.findAll();
    }
    @PutMapping(path="updateUser")
    public void updateUser(@RequestBody User user ){
        userRepository.saveAndFlush(user);
    }
    @DeleteMapping(path="deleteUser")
    public void deleteUser(@RequestParam Long id){
      userRepository.deleteById(id);
    }
    //复杂的接口调用findByNameIs
    @GetMapping(path="findByNameIs")
    public  User findByNameIs(@RequestParam String name){
        return userRepository.findByNameIs(name);
    }
    //自定义的接口
    @GetMapping("/findUserByName")
    public  User findUserByName(@RequestParam String name){
        return userRepository.findUserByName(name);
    }
    @GetMapping("/findUserLike")
    public  User findUserLike(@RequestParam String name){
        return userRepository.findUserLike(name);
    }

}
