package net.piatek.weaponmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.piatek.weaponmod.WeaponMod;

public class ModItemGroup {

    public static RegistryKey<ItemGroup> CITRINE_KEY;
    public static ItemGroup CITRINE;

    public static void registerItemGroup(){
        CITRINE = FabricItemGroup.builder()
                .icon(() -> new ItemStack(ModItems.WITHERWARHAMMER))
                .displayName(Text.translatable("itemgroup.citrine"))
                .build();
        CITRINE_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(),
                Identifier.of(WeaponMod.MOD_ID, "citrine"));
        Registry.register(Registries.ITEM_GROUP, CITRINE_KEY, CITRINE);

    }
}
