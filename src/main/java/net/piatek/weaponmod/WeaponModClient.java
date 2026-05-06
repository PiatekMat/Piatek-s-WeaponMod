package net.piatek.weaponmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.EmptyEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.entity.mob.FlyingEntity;
//import net.piatek.weaponmod.entities.SonicBoom;
import net.piatek.weaponmod.entities.SonicBoom;
import net.piatek.weaponmod.item.ModEntities;

public class WeaponModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.SONIC_BOOM, EmptyEntityRenderer::new);

    }
}
