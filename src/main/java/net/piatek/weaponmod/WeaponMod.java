package net.piatek.weaponmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.piatek.weaponmod.item.ModBlock;
import net.piatek.weaponmod.item.ModEntities;
import net.piatek.weaponmod.item.ModItemGroup;
import net.piatek.weaponmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WeaponMod implements ModInitializer {
	public static final String MOD_ID = "weaponmod";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);



	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroup();
		ModItems.registerModItems();
		ModEntities.registerEntities();
		ModBlock.registerModBlocks();


	}
}