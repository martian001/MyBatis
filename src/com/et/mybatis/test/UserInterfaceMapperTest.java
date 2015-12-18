package com.et.mybatis.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.et.mybatis.Mapper.UserInterfaceMapper;
import com.et.mybatis.bean.User;

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
 *定义sql映射的接口(通过注解实现)
 */
public class UserInterfaceMapperTest {

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
    * 通过注解添加
    */
   private static void add() {
      SqlSession sqlSession = sessionFactory.openSession(true);
      UserInterfaceMapper mapper = sqlSession.getMapper(UserInterfaceMapper.class);
      mapper.addUser(new User("梁衍君", 21));
      sqlSession.close();
   }

   /**
    * 通过注解查询所有
    */
   private static void select() {
      SqlSession sqlSession = sessionFactory.openSession();
      UserInterfaceMapper mapper = sqlSession.getMapper(UserInterfaceMapper.class);
      mapper.deleteUserById(6);
      System.out.println(mapper.getAllUser());
      sqlSession.close();
   }

   public static void main(String[] args) {
      // add();
      select();
   }

}
