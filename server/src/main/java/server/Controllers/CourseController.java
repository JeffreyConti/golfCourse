package server.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import server.Daos.CourseDao;
import server.Models.Courses;
import server.Models.MessageBoard;

import java.util.List;

@RestController
@RequestMapping("/courses")
@CrossOrigin
public class CourseController {
    private CourseDao courseDao;
    public CourseController(CourseDao courseDao){
        this.courseDao = courseDao;
    }
    @GetMapping("")
    public List<Courses> listAllCourses(){
        return courseDao.getAllCourses();
    }
    @GetMapping("/{id}")
    public Courses courseById(@PathVariable int id){
        return courseDao.getCourseById(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Courses addMessage(@RequestBody Courses courses) {
        return courseDao.createCourse(courses);
    }
    @PutMapping("/{id}")
    public Courses updateCourse(@PathVariable int id, @RequestBody Courses courses){
        courses.setCourseId(id);
        return courseDao.updateCourseById(courses);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public int deleteCourse(@PathVariable int id){
        return courseDao.deleteCourse(id);
    }
}
