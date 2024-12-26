package com.example.stateditor;

import com.cobblemon.mod.common.api.pokemon.stats.Stats;
import com.cobblemon.mod.common.pokemon.IVs;
import com.cobblemon.mod.common.pokemon.Pokemon;
import com.example.common.UserOwnedPokemonTargetingItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class BottleCap extends UserOwnedPokemonTargetingItem {
    private final Stats stats;

    public BottleCap() {
        this(null);
    }

    public BottleCap(Stats stats) {
        super(new Settings());

        this.stats = stats;
    }

    @Override
    protected ActionResult useOnPokemon(ItemStack stack, PlayerEntity user, Pokemon pokemon, Hand hand) {
        if (stats == null) {
            return ActionResult.PASS;
        }

        if (pokemon.getIvs().get(stats).equals(IVs.MAX_VALUE)) {
            return ActionResult.PASS;
        }

        pokemon.setIV(stats, IVs.MAX_VALUE);

        if (!user.isCreative()) {
            stack.decrement(1);
        }

        return ActionResult.SUCCESS;
    }
}
