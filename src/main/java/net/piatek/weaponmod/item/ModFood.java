package net.piatek.weaponmod.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFood {
    public static final FoodComponent GOLDENSTEAK = new FoodComponent.Builder()
            .hunger(9)
            .saturationModifier(1.5f)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 6000, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 6000, 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 6000, 0), 1.0F).build();
}
