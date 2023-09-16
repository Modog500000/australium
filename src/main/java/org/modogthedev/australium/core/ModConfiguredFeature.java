package org.modogthedev.australium.core;

import com.google.common.base.Suppliers;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.modogthedev.australium.Australium;

import java.util.List;
import java.util.function.Supplier;

public class ModConfiguredFeature {
    public static final DeferredRegister<ConfiguredFeature<?, ? >> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Australium.MODID);

    private static final Supplier<List<OreConfiguration.TargetBlockState>> AUSTRALIUM_ORE_OVERWORLD_REPLACEMENT =
            Suppliers.memoize(() -> List.of(
                    OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.AUSTRALIUM_ORE.get().defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> OVERWORLD_AUSTRALIUM_ORE = CONFIGURED_FEATURES.register("australium_ore_overworld", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(AUSTRALIUM_ORE_OVERWORLD_REPLACEMENT.get(), 3)));
}
