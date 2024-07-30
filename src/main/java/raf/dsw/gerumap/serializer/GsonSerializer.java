package raf.dsw.gerumap.serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import raf.dsw.gerumap.core.Serializer;
import raf.dsw.gerumap.mapRepository.implementation.Project;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GsonSerializer implements Serializer {

    private Gson gson = new Gson();

    @Override
    public Project loadProject(File file) {
        try (FileReader fileReader = new FileReader(file)){
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(Project.class, new NodeDeserializer());
            gson = gsonBuilder.create();
            return gson.fromJson(fileReader, Project.class);
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void saveProject(Project node) {
        try (FileWriter fileWriter = new FileWriter(node.getPath())){
            gson.toJson(node, fileWriter);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
