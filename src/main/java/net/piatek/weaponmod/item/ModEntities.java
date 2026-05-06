package net.piatek.weaponmod.item;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.piatek.weaponmod.WeaponMod;
import net.piatek.weaponmod.entities.SonicBoom;
//import net.piatek.weaponmod.entities.SonicBoom;

public class ModEntities {
    public static final EntityType<SonicBoom> SONIC_BOOM = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(WeaponMod.MOD_ID, "sonic_boom"),
            FabricEntityTypeBuilder.<SonicBoom>create(SpawnGroup.MISC, SonicBoom::new)
                    .dimensions(EntityDimensions.fixed(1.0F, 1.0F)) // Rozmiar encji
                    .trackRangeBlocks(64)
                    .trackedUpdateRate(10)
                    .build()
    );

    public static void registerEntities() {
        WeaponMod.LOGGER.info("Rejestrowanie encji...");
    }
}
