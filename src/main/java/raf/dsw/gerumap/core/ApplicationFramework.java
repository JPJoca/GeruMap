package raf.dsw.gerumap.core;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public abstract class ApplicationFramework {
    protected Gui gui;
    protected Serializer serializer;
    protected MapRepository map;
    protected MessageGenerator messageGenerator;
    protected ErrorLogger errorLogger;
    protected ErrorLogger errorLogger1;

    public ApplicationFramework() {
    }

    public abstract void run();

    public void initialise(Gui gui, MapRepository mapRepository, ErrorLogger errorLogger, MessageGenerator messageGenerator, ErrorLogger errorLogger1, Serializer serializer){
        this.errorLogger = errorLogger;
        this.messageGenerator = messageGenerator;
        this.gui = gui;
        this.map = mapRepository;
        this.errorLogger1 = errorLogger1;
        this.serializer = serializer;
    }
}
