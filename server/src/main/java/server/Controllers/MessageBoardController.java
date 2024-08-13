package server.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import server.Daos.MessageBoardDao;
import server.Models.MessageBoard;

import java.util.List;

@RestController
@RequestMapping("/messageboard")
@CrossOrigin
public class MessageBoardController {
    private MessageBoardDao messageBoardDao;
    public MessageBoardController(MessageBoardDao messageBoardDao){
        this.messageBoardDao = messageBoardDao;
    }
    @GetMapping("")
    public List<MessageBoard> listAllMessages(){
        return messageBoardDao.getAllMessages();
    }
    @GetMapping("/{id}")
    public MessageBoard messageById(@PathVariable int id){
        return messageBoardDao.getMessageById(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public MessageBoard addMessage(@RequestBody MessageBoard message){
        return messageBoardDao.createMessage(message);
    }
    @PutMapping("/{id}")
    public MessageBoard updateMessage(@PathVariable int id, @RequestBody MessageBoard message){
        message.setMessage_id(id);
        return messageBoardDao.updateMessageById(message);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public int deleteMessage(@PathVariable int id){
        return messageBoardDao.deleteMessage(id);
    }
}
