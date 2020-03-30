package com.lang.dubbo.mapper;

import com.lang.dubbo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface IUserMapper {
    //通过用户名密码查找用户
    @Select("select * from user where username = #{name} and password = #{pass} limit 1")
    User findUser(@Param("name") String username, @Param("pass") String password);

    //插入用户
    @Insert("insert into user(username,birth_date,gender,address,password) values(#{username},#{birthDate},#{gender},#{address},#{password})")
    int insertUser(User user);
}
