package net.garrettmartin.comicalcarnivores.block;

import java.util.function.Supplier;

import net.garrettmartin.comicalcarnivores.ComicalCarnivores;
import net.garrettmartin.comicalcarnivores.item.ModCreativeModeTab;
import net.garrettmartin.comicalcarnivores.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
	public static final DeferredRegister<Block> BLOCKS =
			DeferredRegister.create(ForgeRegistries.BLOCKS, ComicalCarnivores.MOD_ID);
	
	public static final RegistryObject<Block> WILLIAM_BLOCK = registerBlock("william_block", 
			() -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.COMICAL_CARNIVORES_TAB);
	
	
	
	private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
		RegistryObject<T> toReturn = BLOCKS.register(name, block);
		registerBlockItem(name, toReturn, tab);
		return toReturn;
	}
	
	private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){
		
		return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
	
	
	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}
}
