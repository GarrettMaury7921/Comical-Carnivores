package com.garrettmartin.comicalcarnivores.datagen;

import com.garrettmartin.comicalcarnivores.block.ModBlocks;
import com.garrettmartin.comicalcarnivores.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        add(ModBlocks.WILLIAM_BLOCK.get(),
                (block) -> createSilkTouchOnlyTable(ModItems.WILLIAM.get()));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}