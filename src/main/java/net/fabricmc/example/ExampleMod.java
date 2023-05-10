package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");
    public static final Item CUSTOM_ITEM =
    	      Registry.register(Registries.ITEM, new Identifier("tutorial", "custom_item"),
    	        new Item(new FabricItemSettings()));
    
    
    private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder(new Identifier("tutorial", "test_group"))
    		.icon(() -> new ItemStack(CUSTOM_ITEM))
    		.build();
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		
		ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP).register(content ->{
			content.add(CUSTOM_ITEM);
		});
	}
}
