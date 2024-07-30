package raf.dsw.gerumap.logger;

import com.sun.nio.file.ExtendedWatchEventModifier;
import raf.dsw.gerumap.core.ErrorLogger;
import raf.dsw.gerumap.core.MessageGenerator;
import raf.dsw.gerumap.messageGenerator.Message;
import raf.dsw.gerumap.messageGenerator.MessageGeneratorImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConsoleLogger implements ErrorLogger {
    //String ts = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());

    private MessageGenerator messageGenerator;

    public ConsoleLogger(MessageGenerator messageGenerator){
        this.messageGenerator = messageGenerator;
        this.messageGenerator.addSubscriber(this);
    }

    @Override
    public void log(Message message) {
        StringBuilder error = new StringBuilder();

        error.append("[ " + message.getType() + " ] ");

        error.append("[ " + message.getTimestamp() + " ] ");

        error.append("[ " + message.getContent() + " ] ");

        System.out.println(error.toString());
    }

    @Override
    public void update(Object notification, Object typeOfUpdate) {
        this.log((Message) notification);
    }
}
