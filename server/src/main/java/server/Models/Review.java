package server.Models;

public class Review {
    private int review_id;
    private int course_id;
    private String course_name;
    private int ranking;
    private String condition;
    private String value;
    private String pace;
    private String amenities;
    private String difficulty;

    public int getReview_id() {
        return review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPace() {
        return pace;
    }

    public void setPace(String pace) {
        this.pace = pace;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Review() {
    }

    public Review(int review_id, int course_id, String course_name, int ranking, String condition, String value, String pace, String amenities, String difficulty) {
        this.review_id = review_id;
        this.course_id = course_id;
        this.course_name = course_name;
        this.ranking = ranking;
        this.condition = condition;
        this.value = value;
        this.pace = pace;
        this.amenities = amenities;
        this.difficulty = difficulty;
    }
}
