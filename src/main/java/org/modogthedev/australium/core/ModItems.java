package org.modogthedev.australium.core;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.modogthedev.australium.Australium;
import org.modogthedev.australium.common.items.AustraliumPan;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Australium.MODID);

    public static final CreativeModeTab TAB = new CreativeModeTab(Australium.MODID) {
        @Override
        public ItemStack makeIcon() {
            return AUSTRALIUM_ORE.get().getDefaultInstance();
        }
    };
    public static final RegistryObject<Item> AUSTRALIUM_ORE = ITEMS.register("australium_ore", () -> new BlockItem(ModBlocks.AUSTRALIUM_ORE.get(), new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> AUSTRALIUM_BLOCK = ITEMS.register("australium_block", () -> new BlockItem(ModBlocks.AUSTRALIUM_BLOCK.get(), new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> RAW_AUSTRALIUM = ITEMS.register("raw_australium", () -> new Item(new Item.Properties().fireResistant().tab(TAB)));
    public static final RegistryObject<Item> AUSTRALIUM_PAN = ITEMS.register("australium_pan", () -> new AustraliumPan(new Item.Properties().fireResistant().tab(TAB).durability(124)));
}
