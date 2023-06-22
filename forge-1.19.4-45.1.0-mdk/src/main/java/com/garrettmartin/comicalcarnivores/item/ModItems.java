package com.garrettmartin.comicalcarnivores.item;

import com.garrettmartin.comicalcarnivores.ComicalCarnivores;
import com.garrettmartin.comicalcarnivores.entity.ModEntities;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ComicalCarnivores.MOD_ID);

    public static final RegistryObject<Item> WILLIAM = ITEMS.register("william", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GOBLIN_SPAWN_EGG = ITEMS.register("goblin_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.GOBLIN,
            0x747A29, 0x35E10F, new Item.Properties()));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
