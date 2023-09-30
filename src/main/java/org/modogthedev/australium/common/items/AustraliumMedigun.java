package org.modogthedev.australium.common.items;

import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
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
    protected static BlockHitResult rayTrace(Level world, Player player, ClipContext.Fluid fluidMode) {
        double range = 10;

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
    private void spawnFoundParticles(LivingEntity pContext, BlockPos positionClicked) {
        for(int i = 0; i < 360; i++) {
            if(i % 20 == 0) {
                pContext.getLevel().addParticle(ModParticles.MEDIGUN_PARTICLE.get(),
                        positionClicked.getX() + 0.5d, positionClicked.getY() + 1, positionClicked.getZ() + 0.5d,
                        Math.cos(i) * 0.15d, 0.15d, Math.sin(i) * 0.15d);
            }
        }
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand p_41434_) {
        BlockHitResult ray = rayTrace(level, player, ClipContext.Fluid.NONE);
        BlockPos lookPos = ray.getBlockPos();
        return super.use(level, player, p_41434_);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack p_41398_, Player player, LivingEntity enemy, InteractionHand p_41401_) {
        if (enemy.getHealth()+0.0005 <= enemy.getMaxHealth()) {
            if (enemy.getHealth() >= 0) {
                enemy.setHealth(enemy.getHealth() + 0.0005F);
                spawnFoundParticles(enemy,enemy.blockPosition());
                enemy.playSound(ModSounds.MEDIGUN.get(), 1.0F, 1.0F);
                enemy.getLevel().addParticle(ParticleTypes.WITCH, 2d, 2d, 3d, 4d, 2d, 2d);
            }
        }
        enemy.setHealth(enemy.getHealth()+1);
        return super.interactLivingEntity(p_41398_, player, enemy, p_41401_);
    }
}
