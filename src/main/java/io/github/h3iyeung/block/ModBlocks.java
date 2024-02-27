package io.github.h3iyeung.block;

import io.github.h3iyeung.Lamp;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LanternBlock;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class ModBlocks {

	public static final Block LAMP = registerBlock("lamp",
		new LampBlock(QuiltBlockSettings.copyOf(Blocks.LANTERN).nonSolid().mapColor(MapColor.RED).strength(1.0f).luminance(state -> 14).nonOpaque()));


	private static Block registerBlock(String name, Block block){
		registerBlockItem(name, block);
		return Registry.register(Registries.BLOCK,new Identifier(Lamp.MOD_ID,name),block);
	}

	private static Item registerBlockItem(String name, Block block){
		return Registry.register(Registries.ITEM,new Identifier(Lamp.MOD_ID,name),
			new BlockItem(block, new QuiltItemSettings()));
	}

	public static void registerModBlocks(){
		Lamp.LOGGER.info("Registering ModBlocks for " + Lamp.MOD_ID);
	}
}
