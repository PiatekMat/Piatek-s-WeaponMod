package net.piatek.weaponmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.DragonFireballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterials;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

import java.util.Date;

public class DragonBattleAxe extends BattleAxe {
    public DragonBattleAxe(FabricItemSettings settings) {
        super(ToolMaterials.NETHERITE, 8, -3.0f, settings);
    }

    Date data = new Date(new Date().getTime());
    Date data1;
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {

            //MinecraftClient client = MinecraftClient.getInstance();
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

            Vec3d vec3d = user.getRotationVec(1.0F);
            double f = hitResult.getBlockPos().getX() - (user.getX() + vec3d.x * (double)4.0F);
            double g = hitResult.getBlockPos().getY() - ((double)0.5F + user.getBodyY((double)0.5F));
            double h = hitResult.getBlockPos().getZ() - (user.getZ() + vec3d.z * (double)4.0F);

            DragonFireballEntity dragonFireball = new DragonFireballEntity(world, user, f, g, h);
            dragonFireball.setPosition(user.getX() + vec3d.x * (double)4.0F, user.getBodyY((double)0.5F) + (double)0.5F, dragonFireball.getZ() + vec3d.z * (double)4.0F);
            world.spawnEntity(dragonFireball);

            world.playSound(null, user.getBlockPos(), SoundEvents.ENTITY_ENDER_DRAGON_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F);

            user.getStackInHand(hand).damage(1, user, (p) -> p.sendToolBreakStatus(hand));
        }
        return TypedActionResult.success(user.getStackInHand(hand));
    }

}

