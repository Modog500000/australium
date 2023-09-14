package org.modogthedev.australium.common.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;

public class AustraliumPan extends SwordItem {
    public AustraliumPan(Properties properties) { super(Tiers.IRON,4,-1,properties.defaultDurability(124));
    }

    @Override
    public boolean hurtEnemy(ItemStack itemStack, LivingEntity enemy, LivingEntity player) {
        enemy.setRemainingFireTicks(120);
        enemy.setSecondsOnFire(10);
        enemy.setSharedFlagOnFire(true);
        enemy.wasOnFire = true;
        player.playSound(SoundEvents.GENERIC_BURN, 0.4F, 2.0F + 0.4F);
        itemStack.setDamageValue(itemStack.getDamageValue() + 1);
        if (itemStack.getDamageValue() >= itemStack.getMaxDamage()) itemStack.setCount(0);
        return super.hurtEnemy(itemStack, enemy, player);
    }
}
