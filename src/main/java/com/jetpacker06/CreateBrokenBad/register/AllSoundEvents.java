package com.jetpacker06.CreateBrokenBad.register;

import com.jetpacker06.CreateBrokenBad.CreateBrokenBad;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class AllSoundEvents {

    public static SoundEvent BRASS_CALL_BELL_DING = SoundEvent.createFixedRangeEvent(new ResourceLocation(CreateBrokenBad.MOD_ID, "brass_call_bell_ding"), 16f);

    public static void register() {
        Registry.register(BuiltInRegistries.SOUND_EVENT, BRASS_CALL_BELL_DING.getLocation(), BRASS_CALL_BELL_DING);
    }
}
