package com.pablomonteserin.login.persistence.services;

import com.pablomonteserin.login.persistence.entities.Message;
import com.pablomonteserin.login.persistence.entities.MessageDTO;
import com.pablomonteserin.login.persistence.entities.UserDTO;
import com.pablomonteserin.login.persistence.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public MessageDTO toMessageDTO(Message message) {
        return new MessageDTO(
                message.getId(),
                message.getText(),
                message.getRemitente().getId(),
                message.getDestinatarios().getId()

        );
    }
    public List<MessageDTO> getMessagesByRemitenteId(Integer remitenteId) {
        List<Message> messages = messageRepository.findMessagesByRemitenteId(remitenteId);
        return messages.stream().map(this::toMessageDTO).collect(Collectors.toList());
    }

}