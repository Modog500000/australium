package org.modogthedev.australium.common.items;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

public class AustraliumKnife extends SwordItem {
    public AustraliumKnife(Properties properties) { super(Tiers.NETHERITE,0,-1,properties.defaultDurability(124));
    }
}
