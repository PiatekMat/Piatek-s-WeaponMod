package net.piatek.weaponmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.piatek.weaponmod.WeaponMod;

public class ModBlock {
    public static final Block ASBESTOS = registerBlock("asbestos",
            new Block(FabricBlockSettings.copyOf(Blocks.COBBLESTONE).strength(1f).requiresTool()));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(WeaponMod.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(WeaponMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
    public static void addItemsToGroup(){
        addToItemGroup(ModItemGroup.CITRINE_KEY, ASBESTOS);

    }
    public static void addToItemGroup(RegistryKey<ItemGroup> group, Block item){
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }
    public static void registerModBlocks(){
        WeaponMod.LOGGER.debug("Block register...");
        addItemsToGroup();
    }
}
