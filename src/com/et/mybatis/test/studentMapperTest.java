package com.et.mybatis.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.et.mybatis.bean.Student;

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
public class studentMapperTest {

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
    *方式一：演示了一对一的联合查询
    */
   private void getSydentOneToOneJoin() {
      SqlSession sqlSession = sessionFactory.openSession();
      System.out.println(sqlSession.selectOne("student.getSydentOneToOneJoin", 1));
   }

   /**
    *方式一：演示了一对一的嵌套查询 
    */
   private void getStudenttOneToOneNest() {
      SqlSession sqlSession = sessionFactory.openSession();
      System.out.println(sqlSession.selectOne("student.getStudenttOneToOneNest", 1));
   }

   /**
    *动态sql
    */
   private void getStudentByWhere() {
      SqlSession sqlSession = sessionFactory.openSession();
      System.out.println(sqlSession.selectList("student.getStudentByWhere", new Student(1, "zh", 1)));
   }

   private void add() {
      SqlSession sqlSession = sessionFactory.openSession();
      Student s = new Student("zhangsan", 1);
      sqlSession.insert("student.addStudent", s);
      sqlSession.commit();
      System.out.println(s);
   }
   private void getStudentByWhere2() {
      SqlSession sqlSession = sessionFactory.openSession();
      List<Object> selectList = sqlSession.selectList("student.getUserInfoDetil", "10000032700010");
      System.out.println(selectList.size());
   }
   @Test
   public void testMethod() {
      getStudentByWhere2();
//       add();
      // getSydentOneToOneJoin();
//      getStudenttOneToOneNest();
      // getStudentByWhere();
   }
}
