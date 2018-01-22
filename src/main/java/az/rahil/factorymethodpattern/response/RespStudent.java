package az.rahil.factorymethodpattern.response;

public class RespStudent implements RespModel {


    private RespStatus respStatus;

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void setPassword(String password) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public String getSurname() {
        return null;
    }

    @Override
    public void setSurname(String surname) {

    }

    public void setRespStatus(RespStatus respStatus) {
        this.respStatus = respStatus;
    }
}
