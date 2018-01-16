package az.rahil.restnew.az.rahil.restnew.factory;

import az.rahil.restnew.az.rahil.restnew.product.Model;
import az.rahil.restnew.az.rahil.restnew.product.Teacher;

public class TeacherCreator implements  Factory {
    @Override
    public Model getData() {



        
        return  new Teacher();
    }
}
