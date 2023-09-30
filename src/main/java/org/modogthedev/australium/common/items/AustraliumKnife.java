package org.modogthedev.australium.common.items;

import com.mojang.logging.LogUtils;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import org.modogthedev.australium.core.ModSounds;
import org.slf4j.Logger;

public class AustraliumKnife extends SwordItem {
    private static final Logger LOGGER = LogUtils.getLogger();
    @Override
    public boolean hurtEnemy(ItemStack itemStack, LivingEntity enemy, LivingEntity player) {
        Float ly = enemy.getYRot();
        Float py = player.getYRot();
        itemStack.setDamageValue(itemStack.getDamageValue() + 1);
        if (itemStack.getDamageValue() >= itemStack.getMaxDamage()) itemStack.setCount(0);
        if (ly < py+60 && ly > py-60 || Math.abs(ly) < Math.abs(py)+60 && Math.abs(ly) > Math.abs(py)-60) {
            enemy.hurt(DamageSource.GENERIC, 7);
            enemy.playSound(ModSounds.CRIT.get(), 0.7F, 1.0F);
        }
        return super.hurtEnemy(itemStack, enemy, player);
    }

    public AustraliumKnife(Properties properties) { super(Tiers.NETHERITE,0,-1,properties.defaultDurability(124));

    }
}
