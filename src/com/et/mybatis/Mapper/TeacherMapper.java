package com.et.mybatis.Mapper;

import java.util.List;

import com.et.mybatis.bean.Teacher;

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
 *
 *
 *演示了接口绑定里面的接口和Sql分离,所以去掉了原来Sql的注解声明,Sql从配置文件去找
 */
public interface TeacherMapper {
   /**
    * 添加: //当前方法找的sql是sql映射文件里面节点的id
    * @param user
    */
   void addTeacher(Teacher Teacher);

   /**
    * 查询所有: //当前方法找的sql是sql映射文件里面节点的id
    * @return
    */
   List<Teacher> getAllTeacher();

   /**
    * 根基id删除
    * @param id
    */
   void deleteTeacherById(int id);

   void updateTeacher(Teacher teacher);

   Teacher getTeacherById(int id);

   /**
    * 第一种方式： 一对多的联合查询方式 ，根据id查询老师
    * @param id
    * @return
    */
   Teacher getTeacherOneToMeny(int id);

   /**
    * 第二种方式:一对多嵌套查询 ，根据id查询老师
    * @param id
    * @return
    */
   Teacher getTeacherOneToMenyNest(int id);

}
