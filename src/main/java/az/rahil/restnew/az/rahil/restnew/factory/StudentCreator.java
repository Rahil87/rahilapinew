package az.rahil.restnew.az.rahil.restnew.factory;

import az.rahil.restnew.az.rahil.restnew.factory.Factory;
import az.rahil.restnew.az.rahil.restnew.product.Model;
import az.rahil.restnew.az.rahil.restnew.product.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class StudentCreator implements Factory {


    DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /*Bu metodun iwi konkrete(Student) modelin datalarini database(mysql-database) den getirerek
     Student()obyektine yigmaqdir*/

    public Model getData() {
        JdbcTemplate jdbcTemplate= new JdbcTemplate(dataSource);
        String query="SELECT name,surname,address,idStudent FROM studentdb.student";
         jdbcTemplate.query(query,new BeanPropertyRowMapper<>(Student.class));
         return  new Student();
    }


}
