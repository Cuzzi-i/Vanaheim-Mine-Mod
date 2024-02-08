package net.cuzzi.test;

import net.cuzzi.test.block.ModBlocks;
import net.cuzzi.test.item.ModItems;
import net.cuzzi.test.item.ModItemsGroups;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CuzziTest implements ModInitializer {
    public static final String MOD_ID = "cuzzi_test";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);



	@Override
	public void onInitialize() {
		ModItemsGroups.registerItemGroups();
		ModItems.RegisterModItems();
		ModBlocks.RegisterModBlock();
	}
}