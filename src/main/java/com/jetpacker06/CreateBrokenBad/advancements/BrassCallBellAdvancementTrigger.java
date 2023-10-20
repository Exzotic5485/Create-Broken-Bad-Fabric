package com.jetpacker06.CreateBrokenBad.advancements;

import com.google.gson.JsonObject;
import com.jetpacker06.CreateBrokenBad.CreateBrokenBad;
import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.DeserializationContext;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

public class BrassCallBellAdvancementTrigger extends SimpleCriterionTrigger<BrassCallBellAdvancementTrigger.TriggerInstance> {

    private static final ResourceLocation ID = new ResourceLocation(CreateBrokenBad.MOD_ID, "use_brass_call_bell");

    public @NotNull ResourceLocation getId() {
        return ID;
    }

    public void trigger(ServerPlayer player) {
        this.trigger(player, TriggerInstance::test);
    }

    @Override
    protected @NotNull TriggerInstance createInstance(@NotNull JsonObject json, @NotNull ContextAwarePredicate predicate, @NotNull DeserializationContext conditionsParser) {
        return new TriggerInstance(predicate);
    }

    public static class TriggerInstance extends AbstractCriterionTriggerInstance
    {
        public TriggerInstance(ContextAwarePredicate predicate) {
            super(BrassCallBellAdvancementTrigger.ID, predicate);
        }

        public boolean test() {
            return true;
        }
    }

}
