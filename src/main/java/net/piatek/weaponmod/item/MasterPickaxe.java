package net.piatek.weaponmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MasterPickaxe extends PickaxeItem {
    public MasterPickaxe(FabricItemSettings F){
        super(ToolMaterials.NETHERITE, 1, -3.5f, F);
    }
    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {

        if (!world.isClient && miner instanceof PlayerEntity) {

            char direction = getDirection(miner);

            switch (direction) {
                case 'N':
                case 'S':
                    mine3x3(world, pos, 0, Axis.Z);
                    break;
                case 'E':
                case 'W':
                    mine3x3(world, pos, 0, Axis.X);
                    break;
                case 'U':
                case 'D':
                    mine3x3(world, pos, 0, Axis.Y);
                    break;
            }
        }

        if (!world.isClient && state.getHardness(world, pos) != 0.0F) {
            stack.damage(1, miner, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        }

        return super.postMine(stack, world, state, pos, miner);
    }
    private char getDirection(LivingEntity miner) {
        float yaw = miner.getHeadYaw();
        float pitch = miner.getPitch();

        if (pitch >= 45) return 'D';
        if (pitch <= -45) return 'U';
        if (yaw > 45 && yaw < 135) return 'W';
        if (yaw >= 135 || yaw < -135) return 'N';
        if (yaw >= -135 && yaw < -45) return 'E';
        return 'S';
    }
    private enum Axis {
        X, Y, Z
    }
    private void mine3x3(World world, BlockPos pos, int fixed, Axis axis) {
        for (int a = -1; a <= 1; a++) {
            for (int b = -1; b <= 1; b++) {

                if (a == 0 && b == 0) continue;

                BlockPos targetPos;

                switch (axis) {
                    case Z:
                        targetPos = pos.add(a, b, fixed);
                        break;
                    case X:
                        targetPos = pos.add(fixed, b, a);
                        break;
                    case Y:
                        targetPos = pos.add(a, fixed, b);
                        break;
                    default:
                        return;
                }

                if (isMineable(world, targetPos)) {
                    world.breakBlock(targetPos, true);
                }
            }
        }
    }
    private boolean isMineable(World world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);

        return state.isOf(Blocks.STONE)
                || state.isOf(Blocks.DIORITE)
                || state.isOf(Blocks.GRANITE)
                || state.isOf(Blocks.ANDESITE)
                || state.isOf(Blocks.DEEPSLATE)
                || state.isOf(Blocks.TUFF)
                || state.isOf(Blocks.NETHERRACK)
                || state.isOf(Blocks.END_STONE);
    }
}
