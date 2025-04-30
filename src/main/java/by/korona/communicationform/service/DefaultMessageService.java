package by.korona.communicationform.service;

import by.korona.communicationform.dto.Message;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DefaultMessageService {

    private final List<Message> messages=new CopyOnWriteArrayList<>();

    public List<Message> findAll(){
        return messages;
    }

    public void add(Message message){
        messages.add(message);
    }
}
