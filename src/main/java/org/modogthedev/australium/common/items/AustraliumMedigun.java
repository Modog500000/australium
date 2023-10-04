package org.modogthedev.australium.common.items;

import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.modogthedev.australium.core.ModParticles;
import org.modogthedev.australium.core.ModSounds;
import org.slf4j.Logger;

public class AustraliumMedigun extends Item {
    private static final Logger LOGGER = LogUtils.getLogger();
    public AustraliumMedigun(Properties properties) { super(properties); }
    protected static BlockHitResult rayTrace(Level world, Player player, Double range, ClipContext.Fluid fluidMode) {

        float f = player.getXRot();
        float f1 = player.getYRot();
        Vec3 vector3d = player.getEyePosition(1.0F);
        float f2 = Mth.cos(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f3 = Mth.sin(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f4 = -Mth.cos(-f * ((float)Math.PI / 180F));
        float f5 = Mth.sin(-f * ((float)Math.PI / 180F));
        float f6 = f3 * f4;
        float f7 = f2 * f4;
        Vec3 vector3d1 = vector3d.add((double)f6 * range, (double)f5 * range, (double)f7 * range);
        return world.clip(new ClipContext(vector3d, vector3d1, ClipContext.Block.OUTLINE, fluidMode, player));
    }
    private void spawnFoundParticles(LivingEntity entity) {
        for(int i = 0; i < 360; i++) {
            if(i % 20 == 0) {
                entity.getLevel().addParticle(ModParticles.MEDIGUN_PARTICLE.get(),
                        entity.getX(), entity.getY() + 1, entity.getZ(),
                        Math.cos(i) * 0.15d, 0.15d, Math.sin(i) * 0.15d);
            }
        }
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack item, Player player, LivingEntity enemy, InteractionHand p_41401_) {
            if (enemy.getHealth() >= 0) {
                if ((enemy.getMaxHealth()) > (enemy.getHealth()+.1)) {
                    if (!(player.getCooldowns().isOnCooldown(item.getItem()))) {
                        player.getCooldowns().addCooldown(this, 20);
                        spawnFoundParticles(enemy);
                        enemy.playSound(ModSounds.MEDIGUN.get(), 1.0F, 1.0F);
                        enemy.setHealth(enemy.getHealth() + 1);

                    }
                }
                    double f1 = ((enemy.getX()-player.getX())/10);
                    double f2 = ((enemy.getY()-player.getY())/10);
                    double f3 = ((enemy.getZ()-player.getZ())/10);
                    player.getLevel().addParticle(ModParticles.MEDIGUN_PARTICLE.get(),player.getX(),player.getY()+1,player.getZ(),f1,f2,f3);
                    LOGGER.info(String.valueOf(f1));
                    LOGGER.info(String.valueOf(f2));
                    LOGGER.info(String.valueOf(f3));
                    LOGGER.info(" ");
            }
        return super.interactLivingEntity(item, player, enemy, p_41401_);
    }
}
