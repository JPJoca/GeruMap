package raf.dsw.gerumap.serializer;

import com.google.gson.*;
import raf.dsw.gerumap.gui.swing.projectView.model.MapView;
import raf.dsw.gerumap.gui.swing.view.painter.model.Link;
import raf.dsw.gerumap.gui.swing.view.painter.model.Topic;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;

import java.lang.reflect.Type;

public class MindMapDeserializer implements JsonDeserializer<Project> {
    private Project project;
    public MindMapDeserializer(Project project){
        this.project = project;
    }
    @Override
    public Project deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        for(JsonElement element : jsonObject.get("children").getAsJsonArray()){
            MindMap map = new MindMap(element.getAsJsonObject().get("name").getAsString(), project, false);
            for (JsonElement element1 : element.getAsJsonObject().get("children").getAsJsonArray()) {
                if (!element1.getAsJsonObject().get("name").getAsString().equals("")) {
                    Topic topic = new Topic(element1.getAsJsonObject().get("name").getAsString(), map,element1.getAsJsonObject().get("stroke").getAsInt(),element1.getAsJsonObject().get("colorSeter").getAsInt(), element1.getAsJsonObject().get("x").getAsInt(),
                            element1.getAsJsonObject().get("y").getAsInt(), element1.getAsJsonObject().get("width").getAsInt(), element1.getAsJsonObject().get("height").getAsInt());
                    map.addChild(topic);
                } else {
                    Topic fromTopic = new Topic((element1.getAsJsonObject().get("fromTopic").getAsJsonObject().get("name").getAsString()), map,element1.getAsJsonObject().get("fromTopic").getAsJsonObject().get("stroke").getAsInt(),element1.getAsJsonObject().get("fromTopic").getAsJsonObject().get("colorSeter").getAsInt(), element1.getAsJsonObject().get("fromTopic").getAsJsonObject().get("x").getAsInt(),
                            element1.getAsJsonObject().get("fromTopic").getAsJsonObject().get("y").getAsInt(), element1.getAsJsonObject().get("fromTopic").getAsJsonObject().get("width").getAsInt(), element1.getAsJsonObject().get("fromTopic").getAsJsonObject().get("height").getAsInt());
                    Topic toTopic = new Topic((element1.getAsJsonObject().get("toTopic").getAsJsonObject().get("name").getAsString()), map,element1.getAsJsonObject().get("toTopic").getAsJsonObject().get("stroke").getAsInt(),element1.getAsJsonObject().get("toTopic").getAsJsonObject().get("colorSeter").getAsInt(), element1.getAsJsonObject().get("toTopic").getAsJsonObject().get("x").getAsInt(),
                            element1.getAsJsonObject().get("toTopic").getAsJsonObject().get("y").getAsInt(), element1.getAsJsonObject().get("toTopic").getAsJsonObject().get("width").getAsInt(), element1.getAsJsonObject().get("toTopic").getAsJsonObject().get("height").getAsInt());
                    Link link = new Link(element1.getAsJsonObject().get("name").getAsString(), map, fromTopic, toTopic);
                    map.addChild(link);
                }
            }
            project.addChild(map);
        }
        return project;
    }
}
