package server.Daos;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import server.Models.Review;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Component
public class ReviewDao {
    private JdbcTemplate jdbcTemplate;
    public ReviewDao(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate();
    }
    public Review mapRowToReview(ResultSet rowSet, int rowNumber) throws SQLException{
        Review review = new Review();
        review.setReview_id(rowSet.getInt("review_id"));
        review.setCourse_name(rowSet.getString("course_name"));
        review.setRanking(rowSet.getInt("ranking"));
        review.setCondition(rowSet.getString("condition"));
        review.setValue(rowSet.getString("value"));
        review.setPace(rowSet.getString("pace"));
        review.setAmenities(rowSet.getString("amenities"));
        review.setDifficulty(rowSet.getString("difficulty"));
        return review;
    }
}
