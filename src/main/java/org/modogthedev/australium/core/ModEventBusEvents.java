package org.modogthedev.australium.core;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.modogthedev.australium.Australium;
import org.modogthedev.australium.core.custom.MedigunParticle;

@Mod.EventBusSubscriber(modid = Australium.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerParticleFactories(final RegisterParticleProvidersEvent event) {
        Minecraft.getInstance().particleEngine.register(ModParticles.MEDIGUN_PARTICLE.get(),
                MedigunParticle.Provider::new);
    }
}
