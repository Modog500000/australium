package org.modogthedev.australium.core;

import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.modogthedev.australium.Australium;

import java.util.List;

public class ModPlacedFeature {
    public static DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Australium.MODID);
    public static final RegistryObject<PlacedFeature> AUSTRALIUM_ORE_OVERWORLD = PLACED_FEATURES.register("australium_ore_overworld",
            () -> new PlacedFeature(ModConfiguredFeature.OVERWORLD_AUSTRALIUM_ORE.getHolder().get(), commonOrePlacement(5,
                    HeightRangePlacement.triangle(
                    VerticalAnchor.absolute(0),
                    VerticalAnchor.absolute(40)
            ))));
    private static List<PlacementModifier> commonOrePlacement(int countPerChunk, PlacementModifier height) {
        return orePlacement(CountPlacement.of(countPerChunk), height);
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier count, PlacementModifier height) {
        return List.of(count, InSquarePlacement.spread(), height, BiomeFilter.biome());
    }
}
