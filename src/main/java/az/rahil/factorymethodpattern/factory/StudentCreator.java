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

        public List<?extends Model> getListData() {
        JdbcTemplate jdbcTemplate= new JdbcTemplate(dataSource);
        String query="SELECT name,surname,address,idStudent FROM studentdb.student";
        List<Student>studentList=jdbcTemplate.query(query,new BeanPropertyRowMapper<>(Student.class));
            return studentList;
        }

    @Override
         public Model checkUser(String name, String password) {
            JdbcTemplate jdbcTemplate= new JdbcTemplate(dataSource);
            String query="SELECT s FROM Student s WHERE s.name = :name and s.password = :password";
            Student student=(Student) jdbcTemplate.queryForObject(query,new Object[]{name,password},new BeanPropertyRowMapper<>(Student.class));
        return student;
    }


}
