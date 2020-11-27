package com.glock.glockmod;

import com.glock.glockmod.utils.ModListReader;


@SuppressWarnings("unchecked")
public class ModInitializer {
    private ModListReader modListReader;

    public ModInitializer(String modListLocation){
        this.modListReader = new ModListReader(modListLocation);
    }

    /**
     * loadAllMods()
     * This will go through the list of mods given by the modListreader and
     */
    public void loadAllMods(){
        while (modListReader.hasNextMod()){
            loadMod(modListReader.getNextMod());
        }
    }

    public static void loadMod(String packageName){
        try {
            System.out.println("location: " + "com.glock.glockmod." + packageName + ".initMod");
            Class initModClass = Class.forName("com.glock.glockmod." + packageName + ".initMod");
            initModClass.getDeclaredConstructor().newInstance();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
