package com.garrettmartin.comicalcarnivores.entity;

import com.garrettmartin.comicalcarnivores.ComicalCarnivores;
import com.garrettmartin.comicalcarnivores.entity.custom.GoblinEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ComicalCarnivores.MOD_ID);

        public static final RegistryObject<EntityType<GoblinEntity>> GOBLIN =
                ENTITY_TYPES.register("goblin", () -> EntityType.Builder.of(GoblinEntity::new, MobCategory.MONSTER)
                        .sized(1.5f, 1.75f)
                        .build(new ResourceLocation(ComicalCarnivores.MOD_ID, "goblin").toString()));

        public static void register(IEventBus eventBus) {
            ENTITY_TYPES.register(eventBus);
        }

}
