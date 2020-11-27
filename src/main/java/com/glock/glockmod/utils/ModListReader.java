package com.glock.glockmod.utils;

import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;

public class ModListReader {
    String fileLocation;
    Iterator<JSONObject> iterator;

    @SuppressWarnings("unchecked")
    public ModListReader (String fileLocation){
        this.fileLocation = fileLocation;
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("ModList.json"));
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray modList = (JSONArray) jsonObject.get("Mod List");
            this.iterator = modList.iterator();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getNextMod(){
        if (iterator == null){
            return null;
        }
        return iterator.next().get("ModName").toString();
    }

    public Boolean hasNextMod(){
        return iterator.hasNext();
    }
}
