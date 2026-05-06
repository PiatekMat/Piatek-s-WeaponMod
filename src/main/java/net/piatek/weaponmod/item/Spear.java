package net.piatek.weaponmod.item;

import com.google.common.collect.ImmutableMultimap;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageScaling;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterials;
import net.minecraft.item.TridentItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.piatek.weaponmod.WeaponMod;
import net.piatek.weaponmod.damage_type.SpearHitDamageTypes;

public class Spear extends Item {
    ToolMaterials Material;
    public Spear(ToolMaterials ToolMaterial, FabricItemSettings F){
        super(F);
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(
                EntityAttributes.GENERIC_ATTACK_DAMAGE,
                new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Tool modifier", 0, EntityAttributeModifier.Operation.ADDITION)
        );
        builder.put(
                EntityAttributes.GENERIC_ATTACK_SPEED,
                new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Tool modifier", -4.0, EntityAttributeModifier.Operation.ADDITION)
        );
        Material = ToolMaterial;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        double distance = Math.pow((target.getX() - attacker.getX()), 2) + Math.pow((target.getY() - attacker.getY()), 2) + Math.pow((target.getZ() - attacker.getZ()), 2);
        if(distance>=20){
            target.damage(SpearHitDamageTypes.of(target, SpearHitDamageTypes.SPEAR_HIT), 9 + Material.getAttackDamage());
        }else if(distance < 20 && distance > 10){
            target.damage(SpearHitDamageTypes.of(target, SpearHitDamageTypes.SPEAR_HIT), 4 + Material.getAttackDamage());
        }else{
            target.damage(SpearHitDamageTypes.of(target, SpearHitDamageTypes.SPEAR_HIT), 1 + Material.getAttackDamage());
        }

        return false;
    }
    //public boolean isEnchantable(ItemStack stack) {
    //		return this.getMaxCount() == 1 && this.isDamageable();
    //	}
    @Override
    public int getEnchantability() {
        return this.Material.getEnchantability();
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public boolean isDamageable() {
        return true;
    }

}
