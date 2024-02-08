package net.cuzzi.test.item;

import net.cuzzi.test.CuzziTest;
import net.cuzzi.test.item.custom.D20Item;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item RING = registerItem("ring",new Item(new FabricItemSettings()));
    public static final Item NORTHWEAPON = registerItem("northsword",new Item(new FabricItemSettings()));
    public static final Item D20 = registerItem("d20",new D20Item(new FabricItemSettings()));
    public static final Item HAMBUR = registerItem("hambur", new Item(new FabricItemSettings().food(ModFoodComponents.HAMBUR)));
    private static void addItemsToTabING(FabricItemGroupEntries entries){
        entries.add(RING);
    }
    private static void addItemsToTabCOM(FabricItemGroupEntries entries){
        entries.add(NORTHWEAPON);
    }
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(CuzziTest.MOD_ID,name), item);
    }
    public static void RegisterModItems(){
        CuzziTest.LOGGER.info("Registrar los items para mi mod =" + CuzziTest.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToTabING);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToTabCOM);
    }
}
