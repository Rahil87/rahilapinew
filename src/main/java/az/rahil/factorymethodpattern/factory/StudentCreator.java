package az.rahil.factorymethodpattern.factory;

import az.rahil.factorymethodpattern.product.Model;
import az.rahil.factorymethodpattern.product.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class StudentCreator implements Factory {

    @Autowired
    DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /*Bu metodun iwi konkrete(Student) modelin datalarini database(mysql-database) den getirerek
     Student()obyektine yigmaqdir*/

        public List<Model> getListData() {
        JdbcTemplate jdbcTemplate= new JdbcTemplate(dataSource);
        String query="SELECT name,surname,address,idStudent FROM studentdb.student";
        List<Student>studentList=jdbcTemplate.query(query,new BeanPropertyRowMapper<>(Student.class));
        return new Student();
    }



}
