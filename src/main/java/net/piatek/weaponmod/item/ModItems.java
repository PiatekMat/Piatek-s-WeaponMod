package net.piatek.weaponmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.piatek.weaponmod.WeaponMod;

public class ModItems {
    public static final Item WOODEN_BATTLEAXE = registerItem("wooden_battleaxe", new BattleAxe(ToolMaterials.WOOD, new FabricItemSettings()));
    public static final Item STONE_BATTLEAXE = registerItem("stone_battleaxe", new BattleAxe(ToolMaterials.STONE, new FabricItemSettings()));
    public static final Item IRON_BATTLEAXE = registerItem("iron_battleaxe", new BattleAxe(ToolMaterials.IRON, new FabricItemSettings()));
    public static final Item GOLD_BATTLEAXE = registerItem("gold_battleaxe", new BattleAxe(ToolMaterials.GOLD, new FabricItemSettings()));
    public static final Item DIAMOND_BATTLEAXE = registerItem("diamond_battleaxe", new BattleAxe(ToolMaterials.DIAMOND, new FabricItemSettings()));
    public static final Item NETHERITE_BATTLEAXE = registerItem("netherite_battleaxe", new BattleAxe(ToolMaterials.NETHERITE, new FabricItemSettings()));

    public static final Item WOODEN_SPEAR = registerItem("wooden_spear", new Spear(ToolMaterials.WOOD, new FabricItemSettings().maxCount(1)));
    public static final Item STONE_SPEAR = registerItem("stone_spear", new Spear(ToolMaterials.STONE, new FabricItemSettings().maxCount(1)));
    public static final Item IRON_SPEAR = registerItem("iron_spear", new Spear(ToolMaterials.IRON, new FabricItemSettings().maxCount(1)));
    public static final Item GOLD_SPEAR = registerItem("gold_spear", new Spear(ToolMaterials.GOLD, new FabricItemSettings().maxCount(1)));
    public static final Item DIAMOND_SPEAR = registerItem("diamond_spear", new Spear(ToolMaterials.DIAMOND, new FabricItemSettings().maxCount(1)));
    public static final Item NETHERITE_SPEAR = registerItem("netherite_spear", new Spear(ToolMaterials.NETHERITE, new FabricItemSettings().maxCount(1)));

    public static final Item WOODEN_WARHAMMER = registerItem("wooden_warhammer", new WarHammer(ToolMaterials.WOOD, new FabricItemSettings()));
    public static final Item STONE_WARHAMMER = registerItem("stone_warhammer", new WarHammer(ToolMaterials.STONE, new FabricItemSettings()));
    public static final Item IRON_WARHAMMER = registerItem("iron_warhammer", new WarHammer(ToolMaterials.IRON, new FabricItemSettings()));
    public static final Item GOLD_WARHAMMER = registerItem("gold_warhammer", new WarHammer(ToolMaterials.GOLD, new FabricItemSettings()));
    public static final Item DIAMOND_WARHAMMER = registerItem("diamond_warhammer", new WarHammer(ToolMaterials.DIAMOND, new FabricItemSettings()));
    public static final Item NETHERITE_WARHAMMER = registerItem("netherite_warhammer", new WarHammer(ToolMaterials.NETHERITE, new FabricItemSettings()));

    public static final Item WOODEN_SABRE = registerItem("wooden_saber", new Sabre(ToolMaterials.WOOD, new FabricItemSettings()));
    public static final Item STONE_SABRE = registerItem("stone_saber", new Sabre(ToolMaterials.STONE, new FabricItemSettings()));
    public static final Item IRON_SABRE = registerItem("iron_saber", new Sabre(ToolMaterials.IRON, new FabricItemSettings()));
    public static final Item GOLD_SABRE = registerItem("gold_saber", new Sabre(ToolMaterials.GOLD, new FabricItemSettings()));
    public static final Item DIAMOND_SABRE = registerItem("diamond_saber", new Sabre(ToolMaterials.DIAMOND, new FabricItemSettings()));
    public static final Item NETHERITE_SABRE = registerItem("netherite_saber", new Sabre(ToolMaterials.NETHERITE, new FabricItemSettings()));

    public static final Item MASTERPICKAXE = registerItem("master_pickaxe", new MasterPickaxe(new FabricItemSettings()));

    public static final Item SONICSWORD = registerItem("sonic_sword", new SonicSword(new FabricItemSettings()));

    public static final Item DRAGONBATTLEAXE = registerItem("dragon_battleaxe", new DragonBattleAxe(new FabricItemSettings()));

    public static final Item WITHERWARHAMMER = registerItem("wither_war_hammer", new WitherWarHammer(new FabricItemSettings()));

    public static final Item GOLDENSTEAK = registerItem("golden_steak", new Item(new FabricItemSettings().food(ModFood.GOLDENSTEAK)));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(WeaponMod.MOD_ID, name), item);
    }

    public static void addItemsToGroup(){
        addToItemGroup(ModItemGroup.CITRINE_KEY, WOODEN_BATTLEAXE);
        addToItemGroup(ModItemGroup.CITRINE_KEY, STONE_BATTLEAXE);
        addToItemGroup(ModItemGroup.CITRINE_KEY, IRON_BATTLEAXE);
        addToItemGroup(ModItemGroup.CITRINE_KEY, GOLD_BATTLEAXE);
        addToItemGroup(ModItemGroup.CITRINE_KEY, DIAMOND_BATTLEAXE);
        addToItemGroup(ModItemGroup.CITRINE_KEY, NETHERITE_BATTLEAXE);

        addToItemGroup(ModItemGroup.CITRINE_KEY, WOODEN_SPEAR);
        addToItemGroup(ModItemGroup.CITRINE_KEY, STONE_SPEAR);
        addToItemGroup(ModItemGroup.CITRINE_KEY, IRON_SPEAR);
        addToItemGroup(ModItemGroup.CITRINE_KEY, GOLD_SPEAR);
        addToItemGroup(ModItemGroup.CITRINE_KEY, DIAMOND_SPEAR);
        addToItemGroup(ModItemGroup.CITRINE_KEY, NETHERITE_SPEAR);

        addToItemGroup(ModItemGroup.CITRINE_KEY, WOODEN_WARHAMMER);
        addToItemGroup(ModItemGroup.CITRINE_KEY, STONE_WARHAMMER);
        addToItemGroup(ModItemGroup.CITRINE_KEY, IRON_WARHAMMER);
        addToItemGroup(ModItemGroup.CITRINE_KEY, GOLD_WARHAMMER);
        addToItemGroup(ModItemGroup.CITRINE_KEY, DIAMOND_WARHAMMER);
        addToItemGroup(ModItemGroup.CITRINE_KEY, NETHERITE_WARHAMMER);

        addToItemGroup(ModItemGroup.CITRINE_KEY, WOODEN_SABRE);
        addToItemGroup(ModItemGroup.CITRINE_KEY, STONE_SABRE);
        addToItemGroup(ModItemGroup.CITRINE_KEY, IRON_SABRE);
        addToItemGroup(ModItemGroup.CITRINE_KEY, GOLD_SABRE);
        addToItemGroup(ModItemGroup.CITRINE_KEY, DIAMOND_SABRE);
        addToItemGroup(ModItemGroup.CITRINE_KEY, NETHERITE_SABRE);

        addToItemGroup(ModItemGroup.CITRINE_KEY, MASTERPICKAXE);
        addToItemGroup(ModItemGroup.CITRINE_KEY, SONICSWORD);
        addToItemGroup(ModItemGroup.CITRINE_KEY, DRAGONBATTLEAXE);
        addToItemGroup(ModItemGroup.CITRINE_KEY, WITHERWARHAMMER);
        addToItemGroup(ModItemGroup.CITRINE_KEY, GOLDENSTEAK);

    }
    public static void addToItemGroup(RegistryKey<ItemGroup> group, Item item){
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }


    public static void registerModItems(){
        WeaponMod.LOGGER.info("cos" + WeaponMod.MOD_ID);

        addItemsToGroup();
    }
}
