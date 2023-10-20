package com.jetpacker06.CreateBrokenBad.register;

import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.builders.FluidBuilder;
import com.tterrag.registrate.fabric.SimpleFlowableFluid;
import com.tterrag.registrate.util.entry.FluidEntry;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariantAttributeHandler;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class CBBFluids {
    public static Registrate REGISTRATE;

    public static ResourceLocation still = new ResourceLocation("block/water_still");
    public static ResourceLocation flow = new ResourceLocation("block/water_flow");

    public static FluidEntry<SimpleFlowableFluid.Flowing> LIQUID_BLUE_METHAMPHETAMINE;
    public static FluidEntry<SimpleFlowableFluid.Flowing> LIQUID_METHAMPHETAMINE;
    public static FluidEntry<SimpleFlowableFluid.Flowing> METHYLAMINE;
    public static FluidEntry<SimpleFlowableFluid.Flowing> METHANOL;
    public static FluidEntry<SimpleFlowableFluid.Flowing> HYDROGEN;
    public static FluidEntry<SimpleFlowableFluid.Flowing> OXYGEN;
    public static FluidEntry<SimpleFlowableFluid.Flowing> AMMONIA;
    public static FluidEntry<SimpleFlowableFluid.Flowing> PHENYLACETIC_ACID;
    public static FluidEntry<SimpleFlowableFluid.Flowing> ACETIC_ANHYDRIDE;
    public static FluidEntry<SimpleFlowableFluid.Flowing> PHENYLACETONE;

    public static ItemEntry<BucketItem> LIQUID_BLUE_METHAMPHETAMINE_BUCKET;
    public static ItemEntry<BucketItem> LIQUID_METHAMPHETAMINE_BUCKET;
    public static ItemEntry<BucketItem> METHYLAMINE_BUCKET;
    public static ItemEntry<BucketItem> METHANOL_BUCKET;
    public static ItemEntry<BucketItem> HYDROGEN_BUCKET;
    public static ItemEntry<BucketItem> OXYGEN_BUCKET;
    public static ItemEntry<BucketItem> AMMONIA_BUCKET;
    public static ItemEntry<BucketItem> PHENYLACETIC_ACID_BUCKET;
    public static ItemEntry<BucketItem> ACETIC_ANHYDRIDE_BUCKET;
    public static ItemEntry<BucketItem> PHENYLACETONE_BUCKET;

    /**
     * Creates a white fluid.
     */
    public static FluidBuilder<SimpleFlowableFluid.Flowing, Registrate> basicFluid(String name) {
        return basicFluid(name, 0xffffffff);
    }

    /**
     * Creates a fluid with a given color. Use the format 0xAA(hex)
     */
    public static FluidBuilder<SimpleFlowableFluid.Flowing, Registrate> basicFluid(String name, int color) {
        return REGISTRATE.fluid(name, still, flow)
                .attributes((a) -> new CreateAttributeHandler(name, 500, 500))
                .properties(p -> p.tickRate(5).blastResistance(100f))
                .source(SimpleFlowableFluid.Still::new);
    }
    public static ItemEntry<BucketItem> getBucket(FluidBuilder<SimpleFlowableFluid.Flowing, Registrate> fluid) {
        return fluid.bucket().properties(p -> p.stacksTo(1)).register();
    }

    public static void register(Registrate registrate) {
        REGISTRATE = registrate;

        var f1 = basicFluid("liquid_blue_methamphetamine", 0xff42ddf5);
        LIQUID_BLUE_METHAMPHETAMINE_BUCKET = getBucket(f1);
        LIQUID_BLUE_METHAMPHETAMINE = f1.register();

        var f2 = basicFluid("liquid_methamphetamine");
        LIQUID_METHAMPHETAMINE_BUCKET = getBucket(f2);
        LIQUID_METHAMPHETAMINE = f2.register();

        var f3 = basicFluid("methylamine");
        METHYLAMINE_BUCKET = getBucket(f3);
        METHYLAMINE = f3.register();

        var f4 = basicFluid("methanol");
        METHANOL_BUCKET = getBucket(f4);
        METHANOL = f4.register();

        var f5 = basicFluid("hydrogen");
        HYDROGEN_BUCKET = getBucket(f5);
        HYDROGEN = f5.register();

        var f6 = basicFluid("oxygen");
        OXYGEN_BUCKET = getBucket(f6);
        OXYGEN = f6.register();

        var f7 = basicFluid("ammonia");
        AMMONIA_BUCKET = getBucket(f7);
        AMMONIA = f7.register();

        var f8 = basicFluid("phenylacetic_acid");
        PHENYLACETIC_ACID_BUCKET = getBucket(f8);
        PHENYLACETIC_ACID = f8.register();

        var f9 = basicFluid("acetic_anhydride");
        ACETIC_ANHYDRIDE_BUCKET = getBucket(f9);
        ACETIC_ANHYDRIDE = f9.register();

        var f10 = basicFluid("phenylacetone");
        PHENYLACETONE_BUCKET = getBucket(f10);
        PHENYLACETONE = f10.register();
    }

    @Environment(EnvType.CLIENT)
    public static void initRendering() {
        FluidRenderHandlerRegistry.INSTANCE.register(LIQUID_BLUE_METHAMPHETAMINE.get().getSource(), LIQUID_BLUE_METHAMPHETAMINE.get(), new SimpleFluidRenderHandler(
                new ResourceLocation("minecraft:block/water_still"),
                new ResourceLocation("minecraft:block/water_flow"),
                0xff42ddf5
        ));
    }

    private record CreateAttributeHandler(Component name, int viscosity, boolean lighterThanAir) implements FluidVariantAttributeHandler {
        private CreateAttributeHandler(String key, int viscosity, int density) {
            this(new TranslatableComponent(key), viscosity, density <= 0);
        }

        @Override
        public Component getName(FluidVariant fluidVariant) {
            return name.copy();
        }

        @Override
        public int getViscosity(FluidVariant variant, @Nullable Level world) {
            return viscosity;
        }

        @Override
        public boolean isLighterThanAir(FluidVariant variant) {
            return lighterThanAir;
        }
    }
}
