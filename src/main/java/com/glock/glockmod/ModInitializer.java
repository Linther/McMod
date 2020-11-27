package com.glock.glockmod;

import com.glock.glockmod.utils.ModListReader;



public class ModInitializer {
    ModListReader modListReader;

    public ModInitializer(String modListLocation){
        this.modListReader = new ModListReader(modListLocation);
    }

    public static void loadAllMods(){
        try {
            java.lang.reflect.Method initMethod;
            System.out.println("THIS IS A TEST OF THING");
            initMethod = Class.forName("com.glock.glockmod.cheetomod.initMod").getMethod("registerMod");
            System.out.println("class loaded");
            initMethod.invoke(null);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
