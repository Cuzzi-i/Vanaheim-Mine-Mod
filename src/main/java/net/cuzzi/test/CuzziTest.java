package net.cuzzi.test;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CuzziTest implements ModInitializer {
    public static final String MOD_ID = "cuzzi_test";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);



	@Override
	public void onInitialize() {

		LOGGER.info("Hello Fabric world!");
	}
}