package com.garrettmartin.comicalcarnivores.item;

import com.garrettmartin.comicalcarnivores.ComicalCarnivores;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.awt.*;

@Mod.EventBusSubscriber(modid = ComicalCarnivores.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab COMICALCARNIVORES_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        COMICALCARNIVORES_TAB = event.registerCreativeModeTab(new ResourceLocation(ComicalCarnivores.MOD_ID, "comicalcarnivores_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.WILLIAM.get())).title(Component.translatable("creativemodetab.comicalcarnivores_tab")));
    }

}
