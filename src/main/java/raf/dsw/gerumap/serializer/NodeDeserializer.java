package raf.dsw.gerumap.serializer;

import com.google.gson.*;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;

import java.lang.reflect.Type;
import java.util.List;

public class NodeDeserializer implements JsonDeserializer<Project> {


    @Override
    public Project deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        Project p = new Project(jsonObject.get("name").getAsString(), MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode(), jsonObject.get("author").getAsString(), jsonObject.get("path").getAsString());
        if(jsonObject.get("children").getAsJsonArray().size() == 0) return p;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MindMap.class, new MindMapDeserializer(p));
        MindMapDeserializer d = new MindMapDeserializer(p);
        d.deserialize(jsonElement, type, jsonDeserializationContext);

//        for(JsonElement element : jsonObject.get("children").getAsJsonArray()){
////            JsonObject children = element.getAsJsonObject().get("model").getAsJsonObject();
//            MindMap map = new MindMap(element.getAsJsonObject().get("name").getAsString(), p, false);
////            if(!element.getAsJsonObject().get("name").equals("")){
////                Topic topic = new Topic(element.getAsJsonObject().get("name").getAsString(), map, element.getAsJsonObject().get("x").getAsInt(),
////                        element.getAsJsonObject().get("y").getAsInt(), element.getAsJsonObject().get("width").getAsInt(), element.getAsJsonObject().get("height").getAsInt());
////            }else{
////                Topic fromTopic = new Topic( (element.getAsJsonObject().get("fromTopic").getAsJsonObject().get("name").getAsString()), map, element.getAsJsonObject().get("fromTopic").getAsJsonObject().get("x").getAsInt(),
////                        element.getAsJsonObject().get("fromTopic").getAsJsonObject().get("y").getAsInt(), element.getAsJsonObject().get("fromTopic").getAsJsonObject().get("width").getAsInt(), element.getAsJsonObject().get("fromTopic").getAsJsonObject().get("height").getAsInt());
////                Topic toTopic = new Topic((element.getAsJsonObject().get("toTopic").getAsJsonObject().get("name").getAsString()), map, element.getAsJsonObject().get("toTopic").getAsJsonObject().get("x").getAsInt(),
////                        element.getAsJsonObject().get("toTopic").getAsJsonObject().get("y").getAsInt(), element.getAsJsonObject().get("toTopic").getAsJsonObject().get("width").getAsInt(), element.getAsJsonObject().get("toTopic").getAsJsonObject().get("height").getAsInt());
////                Link link = new Link(element.getAsJsonObject().get("name").getAsString(), map, fromTopic , toTopic);
////            }
//            //mindMap = gson.fromJson(children, MindMap.class);
//            p.addChild(map);
//        }
        return p;
    }
}
