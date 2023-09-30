package org.modogthedev.australium.common.items;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import org.modogthedev.australium.core.ModSounds;

public class AustraliumPan extends SwordItem {
    public AustraliumPan(Properties properties) { super(Tiers.NETHERITE,10,-3,properties.defaultDurability(124));
    }

    @Override
    public boolean hurtEnemy(ItemStack itemStack, LivingEntity enemy, LivingEntity player) {
        enemy.setSecondsOnFire(10);
        enemy.setSharedFlagOnFire(true);
        enemy.wasOnFire = true;
        enemy.setRemainingFireTicks(1000);
        enemy.playSound(ModSounds.BONK.get(), 0.4F, 1.0F);
        itemStack.setDamageValue(itemStack.getDamageValue() + 1);
        if (itemStack.getDamageValue() >= itemStack.getMaxDamage()) itemStack.setCount(0);
        return super.hurtEnemy(itemStack, enemy, player);
    }
}
