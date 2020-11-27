package com.glock.glockmod.utils;

import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Objects;

public class ModListReader {
    String fileLocation;
    Iterator<JSONObject> iterator;

    @SuppressWarnings("unchecked")
    public ModListReader (String fileLocation){
        this.fileLocation = fileLocation;
        JSONParser parser = new JSONParser();
        try {
            ClassLoader cl = getClass().getClassLoader();
            Object obj = parser.parse(new InputStreamReader(cl.getResourceAsStream(fileLocation)));
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray modList = (JSONArray) jsonObject.get("ModList");
            this.iterator = modList.iterator();
        } catch (Exception e){
            System.out.println("UH OH!");
            e.printStackTrace();
        }
    }

    public String getNextMod(){
        if (iterator == null){
            return null;
        }
        return iterator.next().get("PackageName").toString();
    }

    public Boolean hasNextMod(){
        return iterator.hasNext();
    }
}
