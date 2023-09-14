package org.modogthedev.australium.common.items;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class AustraliumPan extends Item {
    public AustraliumPan(Properties properties) { super(properties);}

    @Override
    public boolean hurtEnemy(ItemStack itemStack, LivingEntity enemy, LivingEntity player) {
        enemy.setRemainingFireTicks(120);
        itemStack.setDamageValue(itemStack.getDamageValue() + 1);
        if (itemStack.getDamageValue() >= itemStack.getMaxDamage()) itemStack.setCount(0);
        return super.hurtEnemy(itemStack, enemy, player);
    }
}
