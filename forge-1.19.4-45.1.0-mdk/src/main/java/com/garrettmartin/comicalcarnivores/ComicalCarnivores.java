package com.garrettmartin.comicalcarnivores;

import com.garrettmartin.comicalcarnivores.block.ModBlocks;
import com.garrettmartin.comicalcarnivores.entity.ModEntities;
import com.garrettmartin.comicalcarnivores.entity.client.GoblinRenderer;
import com.garrettmartin.comicalcarnivores.item.ModCreativeModeTabs;
import com.garrettmartin.comicalcarnivores.item.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.lang.reflect.Modifier;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ComicalCarnivores.MOD_ID)
public class ComicalCarnivores {
    public static final String MOD_ID = "comicalcarnivores";
    private static final Logger LOGGER = LogUtils.getLogger();
    public ComicalCarnivores() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntities.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {
        // ADDING ITEMS TO THE CREATIVE MODE MENU
        if(event.getTab() == CreativeModeTabs.INGREDIENTS){
            event.accept(ModItems.WILLIAM);
        }
        if(event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.WILLIAM_BLOCK);
        }

        // Our Own Tab
        if(event.getTab() == ModCreativeModeTabs.COMICALCARNIVORES_TAB) {
            event.accept(ModItems.WILLIAM);
            event.accept(ModBlocks.WILLIAM_BLOCK);
            event.accept(ModItems.GOBLIN_SPAWN_EGG);
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(ModEntities.GOBLIN.get(), GoblinRenderer::new);
        }
    }


}
