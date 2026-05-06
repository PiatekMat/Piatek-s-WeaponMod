package net.piatek.weaponmod.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.piatek.weaponmod.damage_type.SpearHitDamageTypes;

public class WarHammer extends SwordItem {
    public WarHammer(ToolMaterials ToolMaterial, FabricItemSettings F){
        super(ToolMaterial, 7, -3.5f, F);
    }
    public WarHammer(ToolMaterials ToolMaterial,int attackDamage, float speed, FabricItemSettings F){
        super(ToolMaterial, attackDamage, speed, F);
    }
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 2, 50, true, false));
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 4, 1, true, true));

        return super.postHit(stack, target, attacker);
    }


    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return 0;
    }
}

