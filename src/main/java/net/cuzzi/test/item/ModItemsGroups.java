package net.cuzzi.test.item;

import net.cuzzi.test.CuzziTest;
import net.cuzzi.test.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemsGroups {

        public static final ItemGroup TEST_GROUP = Registry.register(Registries.ITEM_GROUP,
                new Identifier(CuzziTest.MOD_ID, "ring"),
                FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ring"))
                        .icon(() -> new ItemStack(ModItems.RING)).entries((displayContext, entries) -> {
                            entries.add(ModItems.RING);
                            entries.add(ModItems.NORTHWEAPON);
                            entries.add(ModBlocks.BLUE_TILE);
                            entries.add(ModBlocks.GREEN_TILE);
                            entries.add(ModBlocks.ORANGE_TILE);
                            entries.add(ModItems.D20);
                            entries.add(ModBlocks.PhillipC);
                            entries.add(ModItems.HAMBUR);

                        }).build());
    public static void registerItemGroups(){
        CuzziTest.LOGGER.info("Registrar los ItemGroups para" + CuzziTest.MOD_ID);
    }
}
