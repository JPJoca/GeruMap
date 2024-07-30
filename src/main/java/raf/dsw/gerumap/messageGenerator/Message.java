package raf.dsw.gerumap.messageGenerator;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.AppCore;

import java.sql.Timestamp;

@Setter
@Getter

public class Message {
    private String content, type;
    private Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    public Message(String content, String type){
        this.content = content;
        this.type = type;
    }
}
