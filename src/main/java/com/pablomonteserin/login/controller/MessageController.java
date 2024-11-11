package com.pablomonteserin.login.controller;

import com.pablomonteserin.login.persistence.entities.Message;
import com.pablomonteserin.login.persistence.entities.MessageDTO;
import com.pablomonteserin.login.persistence.repository.MessageRepository;
import com.pablomonteserin.login.persistence.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin // Para hacer peticiones desde otro servidor
@RestController // Para hacer peticiones REST
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private MessageService messageService;

    @GetMapping
    public List<Message> getMessageList(){
        List<Message> messageList = messageRepository.findAll();
        return messageList;

    }
    @GetMapping("/{remitenteId}")
    public List<MessageDTO> getMessagesByRemitenteId(@PathVariable Integer remitenteId) {
        return messageService.getMessagesByRemitenteId(remitenteId);
    }


    @PostMapping("/")
    public void createMessage(@RequestBody Message message){
    messageRepository.save(message);

    }
}
