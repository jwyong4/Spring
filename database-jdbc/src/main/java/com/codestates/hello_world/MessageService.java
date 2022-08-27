package com.codestates.hello_world;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
    /** DI를 통해 MessageRepository 를 주입 받아, */
    private MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
    /** Entity 클래스의 데이터를 save() 를 통해 데이터베이스 저장한다. */
    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }
}
