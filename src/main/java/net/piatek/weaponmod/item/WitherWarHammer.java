package net.piatek.weaponmod.item;

import com.mojang.brigadier.Message;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.message.v1.ServerMessageEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.WitherSkullEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterials;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.piatek.weaponmod.entities.SonicBoom;

import java.util.Date;

public class WitherWarHammer extends WarHammer {
        public WitherWarHammer(FabricItemSettings settings) {
            super(ToolMaterials.NETHERITE, 8, -3.0f, settings);
        }

        Date data = new Date(new Date().getTime());
        Date data1;
        private double getHeadX(int headIndex, PlayerEntity user) {
            if (headIndex <= 0) {
                return user.getX();
            } else {
                float f = (user.bodyYaw + (float)(180 * (headIndex - 1))) * ((float)Math.PI / 180F);
                float g = MathHelper.cos(f);
                return user.getX() + (double)g * 1.3;
            }
        }

    private double getHeadY(int headIndex, PlayerEntity user) {
        return headIndex <= 0 ? user.getY() + (double)3.0F : user.getY() + 2.2;
    }

    private double getHeadZ(int headIndex, PlayerEntity user) {
        if (headIndex <= 0) {
            return user.getZ();
        } else {
            float f = (user.bodyYaw + (float)(180 * (headIndex - 1))) * ((float)Math.PI / 180F);
            float g = MathHelper.sin(f);
            return user.getZ() + (double)g * 1.3;
        }
    }
        public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
            if (!world.isClient) {
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

                WitherSkullEntity witherSkull = new WitherSkullEntity(world, user, hitResult.getPos().getX() - user.getX(),
                        hitResult.getPos().getY() - user.getY()-1,
                        hitResult.getPos().getZ() - user.getZ());

                witherSkull.setPos(user.getX(), user.getY()+1.0, user.getZ());
                world.spawnEntity(witherSkull);

                world.playSound(null, user.getBlockPos(), SoundEvents.ENTITY_WITHER_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F);

                user.getStackInHand(hand).damage(1, user, (p) -> p.sendToolBreakStatus(hand));
            }
            return TypedActionResult.success(user.getStackInHand(hand));
        }

    }



