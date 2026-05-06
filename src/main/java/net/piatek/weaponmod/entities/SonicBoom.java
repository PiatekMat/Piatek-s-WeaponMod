package net.piatek.weaponmod.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.decoration.DisplayEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.text.Text;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.piatek.weaponmod.item.ModEntities;
import org.apache.commons.logging.Log;
import org.apache.logging.slf4j.Log4jLogger;

import java.util.logging.Logger;

public class SonicBoom extends ProjectileEntity {
    private LivingEntity owner;
    public double powerX;
    public double powerY;
    public double powerZ;


    public SonicBoom(EntityType<? extends SonicBoom> entityType, World world) {
        super(entityType, world);
    }

    public SonicBoom(World world, LivingEntity owner,double directionX, double directionY , double directionZ) {
        this(ModEntities.SONIC_BOOM, world);
        double x = owner.getX();
        double y = owner.getY();
        double z = owner.getZ();
        this.refreshPositionAndAngles(x, y, z, this.getYaw(), this.getPitch());
        this.refreshPosition();
        double d = Math.sqrt(directionX * directionX + directionY * directionY + directionZ * directionZ);
        if (d != 0.0) {
            this.powerX = directionX / d * 0.1;
            this.powerY = directionY / d * 0.1;
            this.powerZ = directionZ / d * 0.1;
        }
        this.owner = owner; // Przypisanie właściciela
        this.setOwner(owner);
        this.setRotation(owner.getYaw(), owner.getPitch());
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if(!this.getWorld().isClient){
            if (hitResult instanceof EntityHitResult entityHitResult) {
                if (entityHitResult.getEntity() instanceof LivingEntity target) {
                    target.damage(this.getDamageSources().sonicBoom(this.owner), 15.0F);
                }
            }
            this.remove(RemovalReason.DISCARDED);
        }
    }

    @Override
    protected void initDataTracker() {
        // Nie ma potrzeby implementacji, jeśli nie ma dodatkowych danych do śledzenia
    }
    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient) {
            for (int i = 0; i < 4; ++i) {
                this.getWorld().addParticle(ParticleTypes.SONIC_BOOM, this.getX(), this.getY(), this.getZ(), 1, 1, 1);
            }
        }

        if (this.age > 60) {
            this.remove(RemovalReason.DISCARDED);
        }
        Entity entity = this.getOwner();
        if (this.getWorld().isClient || (entity == null || !entity.isRemoved()) && this.getWorld().isChunkLoaded(this.getBlockPos())) {
            super.tick();

            HitResult hitResult = ProjectileUtil.getCollision(this, this::canHit);
            if (hitResult.getType() != HitResult.Type.MISS) {
                this.onCollision(hitResult);
            }

            this.checkBlockCollision();
            Vec3d vec3d = this.getVelocity();
            double d = this.getX() + vec3d.x;
            double e = this.getY() + vec3d.y;
            double f = this.getZ() + vec3d.z;
            ProjectileUtil.setRotationFromVelocity(this, 0.2F);

            this.getWorld().addParticle(ParticleTypes.SONIC_BOOM, d, e + 0.5, f, 0.0, 0.0, 0.0);
            this.setPosition(d, e, f);
        } else {
            this.discard();
        }
    }
}
