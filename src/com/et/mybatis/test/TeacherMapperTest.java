package com.et.mybatis.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.et.mybatis.Mapper.TeacherMapper;
import com.et.mybatis.bean.Teacher;

/**
 ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年10月14日 下午4:14:09      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 *
 *测试接口绑定里面的接口和Sql分离
 */
public class TeacherMapperTest {

   private static SqlSessionFactory sessionFactory;
   static {
      try {
         String resource = "conf.xml";
         // 加载mybatis的配置文件（它也加载关联的映射文件）
         Reader reader = Resources.getResourceAsReader(resource);
         // 构建sqlSession的工厂
         sessionFactory = new SqlSessionFactoryBuilder().build(reader);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   /**
    * 测试接口绑定里面的接口和Sql分离：通过注解添加
    */
   private static void add() {
      SqlSession sqlSession = sessionFactory.openSession(true);
      TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
      teacherMapper.addTeacher(new Teacher("martian", 21));
   }

   /**
    * 测试接口绑定里面的接口和Sql分离：通过注解删除
    */
   private static void delete() {
      SqlSession sqlSession = sessionFactory.openSession(true);
      TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
      teacherMapper.deleteTeacherById(3);
   }

   /**
    * 测试接口绑定里面的接口和Sql分离：通过注解查询所有
    */
   private static void selectAll() {
      SqlSession sqlSession = sessionFactory.openSession();
      TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
      System.out.println(teacherMapper.getAllTeacher());
   }

   /**
    * 第一种方式： 一对多的联合查询方式 ，根据id查询老师
    */
   private static void getTeacherOneToMeny() {
      SqlSession sqlSession = sessionFactory.openSession();
      TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
      System.out.println(teacherMapper.getTeacherOneToMeny(1));
   }

   /**
    * 第二种方式:一对多嵌套查询 ，根据id查询老师
    */
   private static void getTeacherOneToMenyNest() {
      SqlSession sqlSession = sessionFactory.openSession();
      TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
      System.out.println(teacherMapper.getTeacherOneToMenyNest(1));
   }

   @Test
   public void testMethod() {
      // add();
      // delete();
      // selectAll();
      // getTeacherOneToMeny();
      getTeacherOneToMenyNest();
   }

}
