package az.rahil.factorymethodpattern.service;

import az.rahil.factorymethodpattern.factory.TeacherCreator;
import az.rahil.factorymethodpattern.product.Teacher;
import az.rahil.factorymethodpattern.factory.Factory;
import az.rahil.factorymethodpattern.product.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



         public class Service {
            public static void main(String[] args) {

               ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
                Student student= (Student) context.getBean("studentCreator2");
                System.out.println( student.getName()+"---"+student.getSurname()+"--" +student.getAddress());

        //factory classini kreator modele menimsedirik
                Factory factory= new TeacherCreator();
        //burada ise kreator class(TeacherCreator) return type Teacher classi(Model)oldugu ucun getData metodunu Calisdirdiq
                Teacher teacher= (Teacher) factory.getData();

   }

}