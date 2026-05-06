package net.piatek.weaponmod.item;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.piatek.weaponmod.entities.SonicBoom;

import java.util.Date;

public class SonicSword extends SwordItem {

    public SonicSword(Settings settings) {
        super(ToolMaterials.NETHERITE, 5, -2f, settings);
    }

    Date data = new Date(new Date().getTime());
    Date data1;
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            //user.sendMessage(Text.literal("chuj"));
            //if(data.getTime() + 30000 > data1.getTime()){
                Vec3d start = user.getCameraPosVec(1.0F);
                Vec3d direction = user.getRotationVec(1.0F);

                Vec3d end = start.add(direction.multiply(10));

                RaycastContext context = new RaycastContext(
                        start,
                        end,
                        RaycastContext.ShapeType.OUTLINE,
                        RaycastContext.FluidHandling.NONE,
                        user
                );
                BlockHitResult hitResult = world.raycast(context);

                SonicBoom sonicBoom = new SonicBoom(world, user, hitResult.getPos().getX(), hitResult.getPos().getY(), hitResult.getPos().getZ());
                sonicBoom.setPosition(user.getX(), user.getEyeY() - 0.1, user.getZ());
                sonicBoom.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 2.0F, 1.0F);
                world.spawnEntity(sonicBoom);

                world.playSound(null, user.getBlockPos(), SoundEvents.ENTITY_WARDEN_SONIC_BOOM, SoundCategory.PLAYERS, 1.0F, 1.0F);

                user.getStackInHand(hand).damage(1, user, (p) -> p.sendToolBreakStatus(hand));



            }
        return TypedActionResult.success(user.getStackInHand(hand));
    }

}