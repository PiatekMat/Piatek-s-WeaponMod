package net.piatek.weaponmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;

public class Sabre extends SwordItem {
    public Sabre(ToolMaterials ToolMaterial, FabricItemSettings F){
        super(ToolMaterial, 4, -2.0f, F);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1, 50, false, true));
        return super.postHit(stack, target, attacker);
    }

}
