package com.glock.glockmod.cheetomod;

import com.glock.glockmod.InitMod;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class initMod implements InitMod {
    private static final String modid = "glockmod";
    public static final DeferredRegister<Item> CHEETO_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, modid);


    // ITEM REGISTRATION
    public static final RegistryObject<Item> HOT_CHEETO = CHEETO_ITEMS.register("hot_cheeto", () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().setAlwaysEdible().hunger(6).meat().build())));

    /**
     * This is the constructor that gets called when all mods are loaded in
     */
    public initMod (){
        registerMod();
    }

    public void registerMod(){
        System.out.println("WE OUT HERE");
        registerItems();
    }

    private void registerItems(){
        CHEETO_ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
