package org.modogthedev.australium.core;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.modogthedev.australium.Australium;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Australium.MODID);

    public static final RegistryObject<SoundEvent> BONK = registerSoundEvent("bonk");
    public static final RegistryObject<SoundEvent> CRIT = registerSoundEvent("crit");
    public static final RegistryObject<SoundEvent> MEDIGUN = registerSoundEvent("medigun");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = new ResourceLocation(Australium.MODID, name);
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(Australium.MODID, name)));
    };

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
