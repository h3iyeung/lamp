package io.github.h3iyeung;

import io.github.h3iyeung.block.ModBlocks;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lamp implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod name as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "lamp";
	public static final Logger LOGGER = LoggerFactory.getLogger("Lamp");

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("uh guys ur gonna wanna see this");
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL_BLOCKS).register(content -> {
			content.addBefore(Items.LANTERN, ModBlocks.LAMP);
		});
		ModBlocks.registerModBlocks();
	}
}
