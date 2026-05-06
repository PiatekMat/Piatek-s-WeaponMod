package net.piatek.weaponmod.damage_type;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.piatek.weaponmod.WeaponMod;

public class SpearHitDamageTypes {
    public static final RegistryKey<DamageType> SPEAR_HIT = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(WeaponMod.MOD_ID, "spear_hit"));

    public static DamageSource of(LivingEntity target, RegistryKey<DamageType> key) {
        return new DamageSource(target.getWorld().getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(key));
    }
}
