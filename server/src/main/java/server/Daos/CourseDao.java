package server.Daos;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import server.Models.Courses;
import server.Models.MessageBoard;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class CourseDao {
    private JdbcTemplate jdbcTemplate;

    public CourseDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Courses> getAllCourses() {
        return jdbcTemplate.query("SELECT * FROM courses", this::mapRowToCourses);
    }

    public Courses getCourseById(int id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM courses where course_id = ?", this::mapRowToCourses, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Courses createCourse(Courses courses) {
        Courses newCourse;
        String sql = "INSERT INTO courses (name, city, state, designer, open, holes, par, length, rating, slope) VALUES(?,?,?,?,?,?,?,?,?,?) RETURNING course_id;";

        int newCourseId = jdbcTemplate.queryForObject(sql, int.class, courses.getName(), courses.getCity(), courses.getState(), courses.getDesigner(), courses.getOpen(), courses.getHoles(), courses.getPar(), courses.getLength(), courses.getRating(), courses.getSlope());
        newCourse = getCourseById(newCourseId);
        return newCourse;
    }

    public Courses updateCourseById(Courses courses) {
        Courses updatedCourse = null;
        String sql = "UPDATE courses SET name = ?, city = ?, state = ?, designer = ?, open = ?, holes =?, par = ?, length = ?, rating = ?, slope =? WHERE course_id = ?";
        jdbcTemplate.update(sql, courses.getName(), courses.getCity(), courses.getState(), courses.getDesigner(), courses.getOpen(), courses.getHoles(), courses.getPar(), courses.getLength(), courses.getRating(), courses.getSlope(), courses.getCourseId());
        updatedCourse = getCourseById(courses.getCourseId());
        return updatedCourse;
    }

    public int deleteCourse(int id) {
        String deleteCourseSql = "DELETE FROM courses WHERE course_id = ?";

        int numOfRows = jdbcTemplate.update(deleteCourseSql, id);
        System.out.println("The course has been deleted");
        return numOfRows;
    }

    public List<Courses> getCoursesByCity(String city) {
        return jdbcTemplate.query("SELECT * FROM courses where city =?", this::mapRowToCourses, city);
    }

    public Courses mapRowToCourses(ResultSet rowSet, int rowNumber) throws SQLException {
        Courses courses = new Courses();
        courses.setCourseId(rowSet.getInt("course_id"));
        courses.setName(rowSet.getString("name"));
        courses.setCity(rowSet.getString("city"));
        courses.setState(rowSet.getString("state"));
        courses.setDesigner(rowSet.getString("designer"));
        courses.setOpen(rowSet.getString("open"));
        courses.setHoles(rowSet.getInt("holes"));
        courses.setPar(rowSet.getInt("par"));
        courses.setLength(rowSet.getInt("length"));
        courses.setRating(rowSet.getInt("rating"));
        courses.setSlope(rowSet.getInt("slope"));

        return courses;
    }
}
