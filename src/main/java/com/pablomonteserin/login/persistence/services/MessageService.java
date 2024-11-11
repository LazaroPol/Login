package com.pablomonteserin.login.persistence.services;

import com.pablomonteserin.login.persistence.entities.Message;
import com.pablomonteserin.login.persistence.entities.MessageDTO;
import com.pablomonteserin.login.persistence.entities.User;
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
    public void createMessage(MessageDTO messageDTO) {
        // Convierte MessageDTO a Message
        Message message = toMessageEntity(messageDTO);
        // Guarda la entidad Message en la base de datos
        messageRepository.save(message);
    }

    private Message toMessageEntity(MessageDTO messageDTO) {
        Message message = new Message();
        message.setText(messageDTO.getText());

        // Aquí asumimos que remitente y destinatario son IDs en el DTO
        User user = new User();
        user.setId(messageDTO.getRemitenteId());
        message.setRemitente(user);

        User destinatario = new User();
        destinatario.setId(messageDTO.getDestinatarioId());
        message.setDestinatarios(destinatario);

        return message;
    }

}