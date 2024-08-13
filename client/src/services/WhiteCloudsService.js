import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080"
});

export default {

    courseList() {
        return http.get(`/courses`)
    },
    courseDetails(courseId) {
        return http.get(`/courses/${courseId}`)
    }
}