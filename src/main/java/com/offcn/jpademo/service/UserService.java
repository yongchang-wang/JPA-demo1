package com.offcn.jpademo.service;

import com.offcn.jpademo.pojo.User;

import java.util.List;

public interface UserService {
    //新增
    public  void addUser(User user);
    //查找
    public List<User> findAll();
    //根据名字查找
    public User findUserById(Long id);
    //删除
    public void deleteUser(Long id);
    //修改
    public  void updateUser( Long id,User user);

}
