package com.jetpacker06.CreateBrokenBad;

import com.jetpacker06.CreateBrokenBad.register.*;
import com.tterrag.registrate.Registrate;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;

public class CreateBrokenBad implements ModInitializer, ClientModInitializer {
    public static final String MOD_ID = "createbb";

    @Override
    public void onInitialize() {
        Registrate registrate = Registrate.create(MOD_ID);

        CBBItems.register(registrate);
        CBBItems.register(registrate);
        CBBBlocks.register(registrate);
        CBBFluids.register(registrate);
        CBBBlockEntityTypes.register(registrate);

        Tab.register(registrate);
        AllCustomTriggerAdvancements.register();
        VillagerTrades.register();

        registrate.register();
    }

    @Environment(EnvType.CLIENT)
    public void onInitializeClient() {
        CBBFluids.initRendering();
    }
}
