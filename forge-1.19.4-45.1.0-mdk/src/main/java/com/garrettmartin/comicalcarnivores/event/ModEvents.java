package com.garrettmartin.comicalcarnivores.event;

import com.garrettmartin.comicalcarnivores.ComicalCarnivores;
import com.garrettmartin.comicalcarnivores.entity.ModEntities;
import com.garrettmartin.comicalcarnivores.entity.custom.GoblinEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ComicalCarnivores.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntities.GOBLIN.get(), GoblinEntity.setAttributes());
    }

}
