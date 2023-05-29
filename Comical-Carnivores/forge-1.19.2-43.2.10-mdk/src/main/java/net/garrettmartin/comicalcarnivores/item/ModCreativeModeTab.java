package net.garrettmartin.comicalcarnivores.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
	public static final CreativeModeTab COMICAL_CARNIVORES_TAB = new CreativeModeTab("comicalcarnivores") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ModItems.WILLIAM.get());
		}
	};
}
