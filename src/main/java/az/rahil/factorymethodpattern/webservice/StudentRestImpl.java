package az.rahil.factorymethodpattern.webservice;

import az.rahil.factorymethodpattern.factory.StudentCreator;
import az.rahil.factorymethodpattern.product.Student;
import az.rahil.factorymethodpattern.response.RespModel;
import az.rahil.factorymethodpattern.response.RespStatus;
import az.rahil.factorymethodpattern.response.RespStudent;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

public class StudentRestImpl implements FactoryRest {

    @Autowired
    StudentCreator studentCreator;

    @Override
    @GET
    @Path("/getListData")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})

    public List<? extends RespModel> getListData() {
       List<RespStudent>respStudentList= new ArrayList<>();
       RespStudent respStudent= new RespStudent();
         List<Student>studentList=studentCreator.getListData();    //EXCEPTION VERIR!!!
        for (Student student:studentList) {
          respStudent.setName(student.getName());
          respStudent.setSurname(student.getSurname());
            respStudentList.add(respStudent);
        }
            return respStudentList;
    }

    @Override
    @GET
    @Path("/checkUser")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public RespModel checkUser(@QueryParam("username") String username, @QueryParam("password") String password) {
        RespStudent response = new RespStudent();
        Student student = studentCreator.checkUser(username,password);    //EXCEPTION VERIR!!!
             try {
            if (student != null) {
                response.setName(student.getName());
                RespStatus respStatus = new RespStatus();
                respStatus.setStatusCode(200);
                respStatus.setStatusMessage("success");
                response.setRespStatus(respStatus);
            } else {
                RespStatus respStatus = new RespStatus();
                respStatus.setStatusCode(404);
                respStatus.setStatusMessage("User not exists");
                response.setRespStatus(respStatus);
            }
        } catch (Exception ex) {
            RespStatus respStatus = new RespStatus();
            respStatus.setStatusMessage("Internal Exception");
            response.setRespStatus(respStatus);
            ex.printStackTrace();
        }

        return response;
    }

}
