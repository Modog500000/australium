package org.modogthedev.australium.core;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.modogthedev.australium.Australium;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Australium.MODID);

    public static final RegistryObject<Block> AUSTRALIUM_ORE = BLOCKS.register("australium_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> AUSTRALIUM_BLOCK = BLOCKS.register("australium_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
}
