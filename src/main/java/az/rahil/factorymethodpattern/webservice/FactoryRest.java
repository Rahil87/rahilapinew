package az.rahil.factorymethodpattern.webservice;


import az.rahil.factorymethodpattern.response.RespModel;
import java.util.List;

    public interface FactoryRest {

    public List<? extends RespModel> getListData();
    RespModel checkUser(String name,String password);

    }

