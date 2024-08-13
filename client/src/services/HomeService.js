import axios from "axios";

const http = axios.create({
    baseURL: "http://localhost:8080"
});

export default{
    getCourses(){
        return http.get(`/courses`);
    },
    postCourse(data){
        return http.post('/courses', data);
    },
    details(courseId) {
      return http.get(`/courses/${courseId}`)
    },
}