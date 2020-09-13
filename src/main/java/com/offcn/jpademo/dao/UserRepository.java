package com.offcn.jpademo.dao;

import com.offcn.jpademo.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long> {
/**
 *  UserRepository 不仅有jpa的提供的一些简单的接口，还可以自定义一些自己需要的一些借口(命名需要规范)
 *   springboot 真正自己写接口需要用到@Query自定义一些jpql
 */
   //根据用户名进行查询用户
    public User findByNameIs(String name);

    //来了。真正的自定义接口 查询指定用户名的用户
    //参数
    @Query("select u from User u where u.name=:name")
    public User findUserByName(@Param("name") String name);
    @Query("select u from User u where u.name like %:name%")
    public  User findUserLike(@Param("name") String name);

}
