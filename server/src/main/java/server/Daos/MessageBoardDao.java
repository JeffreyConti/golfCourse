package server.Daos;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import server.Models.MessageBoard;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class MessageBoardDao {
    private JdbcTemplate jdbcTemplate;

    public MessageBoardDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<MessageBoard> getAllMessages() {
        return jdbcTemplate.query("SELECT * FROM message_board", this::mapRowToMessageBoard);
    }

    public MessageBoard getMessageById(int id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM message_board where message_id = ?", this::mapRowToMessageBoard, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public MessageBoard createMessage(MessageBoard messageBoard) {
        MessageBoard newMessage;
        String sql = "INSERT INTO message_board (title, message) VALUES (?,?) RETURNING message_id;";

        int newMessageId = jdbcTemplate.queryForObject(sql, int.class, messageBoard.getTitle(), messageBoard.getMessage());
        newMessage = getMessageById(newMessageId);
        return newMessage;
    }
    public MessageBoard updateMessageById(MessageBoard messageBoard){
        MessageBoard updatedMessage = null;
        String sql = "UPDATE message_board SET title = ?, message = ? WHERE message_id = ?";

        jdbcTemplate.update(sql, messageBoard.getTitle(), messageBoard.getMessage(), messageBoard.getMessage_id());
        updatedMessage = getMessageById(messageBoard.getMessage_id());
        return updatedMessage;
    }
    public int deleteMessage(int id){
        String deleteMessageSql = "DELETE FROM message_board WHERE message_id = ? ";

        int numOfRows = jdbcTemplate.update(deleteMessageSql, id);
        System.out.println("Your message has been successfully deleted");
        return numOfRows;
    }

    public MessageBoard mapRowToMessageBoard(ResultSet rowSet, int rowNumber) throws SQLException {
        MessageBoard messageBoard = new MessageBoard();
        messageBoard.setMessage_id(rowSet.getInt("message_id"));
        messageBoard.setTitle(rowSet.getString("title"));
        messageBoard.setMessage(rowSet.getString("message"));
        return messageBoard;
    }
}
