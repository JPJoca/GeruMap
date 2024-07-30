package raf.dsw.gerumap;

import raf.dsw.gerumap.core.*;
import raf.dsw.gerumap.gui.swing.SwingGui;
import raf.dsw.gerumap.logger.ConsoleLogger;
import raf.dsw.gerumap.logger.FileLogger;
import raf.dsw.gerumap.mapRepository.MapRepositoryImpl;
import raf.dsw.gerumap.messageGenerator.MessageGeneratorImpl;
import raf.dsw.gerumap.serializer.GsonSerializer;

import java.io.File;

public class AppCore extends ApplicationFramework {

    private static AppCore instance;
    private File file = new File("file/log.txt");

    private AppCore(){

    }

    public static AppCore getInstance(){
        if(instance == null){
            instance = new AppCore();
        }
        return instance;
    }

    public void run(){
        this.gui.start();
        this.map.getProjectExplorer();
    }

    public static void main(String[] args) {
        ApplicationFramework appCore = AppCore.getInstance();
        MessageGenerator messageGenerator1 = new MessageGeneratorImpl();
        Gui gui = new SwingGui(messageGenerator1);
        MapRepository mapRepository = new MapRepositoryImpl();
        ErrorLogger errorLogger1 = new FileLogger(messageGenerator1);
        ErrorLogger errorLogger2 = new ConsoleLogger(messageGenerator1);
        Serializer serializer1 = new GsonSerializer();
        appCore.initialise(gui,mapRepository, errorLogger1, messageGenerator1, errorLogger2, serializer1);
        appCore.run();
    }
}
