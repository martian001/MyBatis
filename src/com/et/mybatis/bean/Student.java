package com.et.mybatis.bean;

/**
 ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年10月15日 上午11:10:19      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */

public class Student {
   private int id;
   private String name;
   private Teacher teacher;
   private int teacherId;

   public Student() {
      super();
      // TODO Auto-generated constructor stub
   }

   public Student(String name, int teacherId) {
      super();
      this.name = name;
      this.teacherId = teacherId;
   }

   public Student(int id, String name, int teacherId) {
      super();
      this.id = id;
      this.name = name;
      this.teacherId = teacherId;
   }


   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Teacher getTeacher() {
      return teacher;
   }

   public void setTeacher(Teacher teacher) {
      this.teacher = teacher;
   }

   public int getTeacherId() {
      return teacherId;
   }

   public void setTeacherId(int teacherId) {
      this.teacherId = teacherId;
   }

   @Override
   public String toString() {
      return "Student [id=" + id + ", name=" + name + ", teacher=" + teacher + ", teacherId=" + teacherId + "]";
   }


}
