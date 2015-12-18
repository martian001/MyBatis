package com.et.mybatis.manager;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.et.mybatis.bean.User;

/**
 ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年10月14日 下午2:39:49      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class UserCRUD {
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
    * 查询单个
    */
   private static void seleteOneTest() {
      // 创建能执行映射文件中sql的sqlSession
      SqlSession session = sessionFactory.openSession();
      // 执行查询返回一个唯一user对象的sql
      User user = session.selectOne("userMapper.getUser", 1);
      System.out.println(user);
      session.close();
   }

   public static void main(String[] args) throws IOException {
      seleteOneTest();

   }

}
