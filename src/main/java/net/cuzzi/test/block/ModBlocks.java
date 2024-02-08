package net.cuzzi.test.block;

import net.cuzzi.test.CuzziTest;
import net.cuzzi.test.block.custom.PhillipCommand;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block BLUE_TILE = RegisterBlock("blue_tile", new Block(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)));
    public static final Block GREEN_TILE = RegisterBlock("green_tile", new Block(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)));
    public static final Block ORANGE_TILE = RegisterBlock("orange_tile", new Block(FabricBlockSettings.copyOf(Blocks.ACACIA_LEAVES).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block PhillipC = RegisterBlock("phillipc", new PhillipCommand(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.WOOD)));
    public static void RegisterModBlock(){
        CuzziTest.LOGGER.info("Registering block data from" + CuzziTest.MOD_ID);
    }
    private static Item RegisterBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(CuzziTest.MOD_ID,name),
                new BlockItem(block, new FabricItemSettings()));
    }
    private static Block RegisterBlock(String name, Block block){
        RegisterBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(CuzziTest.MOD_ID, name), block);
    }
}
