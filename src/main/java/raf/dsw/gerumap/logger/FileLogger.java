package raf.dsw.gerumap.logger;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.core.ErrorLogger;
import raf.dsw.gerumap.core.MessageGenerator;
import raf.dsw.gerumap.messageGenerator.Message;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


public class FileLogger implements ErrorLogger {

    File file;

    private MessageGenerator messageGenerator;

    public FileLogger(MessageGenerator messageGenerator){
        this.messageGenerator = messageGenerator;
        this.messageGenerator.addSubscriber(this);
        makeFile();
    }

    private void makeFile(){
        file = new File("src/main/resources/file/log.txt");
        try{
            file.createNewFile();
        }catch (IOException e){
            throw new RuntimeException();
        }
    }
    @Override
    public void log(Message message) {
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write("[ " + message.getType() + " ] " + "[ " + message.getTimestamp() + " ] " + "[ " + message.getContent() + " ]" + "\n");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void update(Object notification, Object typeOfUpdate) {
        this.log((Message) notification);
    }
}
