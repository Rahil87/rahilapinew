package az.rahil.factorymethodpattern.product;

public class Teacher implements Model {

    public  String name;
    public  String surname;
    public String address;

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
}
