package com.et.mybatis.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.et.mybatis.bean.User;

/**
 ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年10月14日 下午4:11:39      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 *定义sql映射的接口(通过注解实现)
 */
public interface UserInterfaceMapper {
   /**
    * 添加
    * @param user
    */
   @Insert("insert into users(name, age) values(#{name}, #{age})")
   void addUser(User user);

   /**
    * 查询所有
    * @return
    */
   @Select("select * from users")
   List<User> getAllUser();

   @Delete("delete from users where id=#{id}")
   int deleteUserById(int id);

   @Update("update users set name=#{name},age=#{age} where id=#{id}")
   int updateUser(User user);

   @Select("select * from users where id=#{id}")
   User getUserById(int id);

}
