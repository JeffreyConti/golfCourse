package server.Models;

public class Courses {
    private int courseId;
    private String name;
    private String city;
    private String state;
    private String designer;
    private String open;
    private int holes;
    private int par;
    private int length;
    private int rating;
    private int slope;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public int getHoles() {
        return holes;
    }

    public void setHoles(int holes) {
        this.holes = holes;
    }

    public int getPar() {
        return par;
    }

    public void setPar(int par) {
        this.par = par;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getSlope() {
        return slope;
    }

    public void setSlope(int slope) {
        this.slope = slope;
    }
    public Courses(){

    }
    public Courses(int courseId, String name, String city, String state, String designer, String open, int holes, int par, int length, int rating, int slope) {
        this.courseId = courseId;
        this.name = name;
        this.city = city;
        this.state = state;
        this.designer = designer;
        this.open = open;
        this.holes = holes;
        this.par = par;
        this.length = length;
        this.rating = rating;
        this.slope = slope;
    }
}

