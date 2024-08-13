package server.Models;

public class MessageBoard {
    private int message_id;
    private String title;
    private String message;

    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageBoard() {
    }

    public MessageBoard(int message_id, String title, String message) {
        this.message_id = message_id;
        this.title = title;
        this.message = message;
    }
}
