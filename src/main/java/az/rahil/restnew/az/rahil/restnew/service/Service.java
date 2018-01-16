package az.rahil.restnew.az.rahil.restnew.service;

import az.rahil.restnew.az.rahil.restnew.product.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



         public class Service {
            public static void main(String[] args) {

               ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
              Student student= (Student) context.getBean("studentCreator2");
               System.out.println( student.getName()+"---"+student.getSurname()+"--" +student.getAddress());

   }

}