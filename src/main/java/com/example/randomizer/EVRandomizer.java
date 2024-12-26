package com.example.randomizer;

import com.cobblemon.mod.common.api.pokemon.stats.Stats;
import com.cobblemon.mod.common.pokemon.EVs;
import com.cobblemon.mod.common.pokemon.Pokemon;
import com.example.common.UserOwnedPokemonTargetingItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

import java.util.List;
import java.util.Random;

public class EVRandomizer extends UserOwnedPokemonTargetingItem {
    public EVRandomizer() {
        super(new Item.Settings());
    }

    @Override
    protected ActionResult useOnPokemon(ItemStack stack, PlayerEntity user, Pokemon pokemon, Hand hand) {
        EVs evs = createRandomEVs();
        pokemon.setEV(Stats.ATTACK, evs.getOrDefault(Stats.ATTACK));
        pokemon.setEV(Stats.DEFENCE, evs.getOrDefault(Stats.DEFENCE));
        pokemon.setEV(Stats.SPECIAL_ATTACK, evs.getOrDefault(Stats.SPECIAL_ATTACK));
        pokemon.setEV(Stats.SPECIAL_DEFENCE, evs.getOrDefault(Stats.SPECIAL_DEFENCE));
        pokemon.setEV(Stats.HP, evs.getOrDefault(Stats.HP));
        pokemon.setEV(Stats.SPEED, evs.getOrDefault(Stats.SPEED));

        if (!user.isCreative()) {
            stack.decrement(1);
        }

        return ActionResult.SUCCESS;
    }

    private EVs createRandomEVs() {
        EVs evs = EVs.Companion.createEmpty();

        List<Stats> stats = List.of(
                Stats.ATTACK,
                Stats.DEFENCE,
                Stats.SPECIAL_ATTACK,
                Stats.SPECIAL_DEFENCE,
                Stats.HP,
                Stats.SPEED
        );

        int total = 0;
        for (Stats stat : stats) {
            if (total < EVs.MAX_TOTAL_VALUE) {
                int remaining = EVs.MAX_TOTAL_VALUE - total;
                int value = new Random().nextInt(Math.min(EVs.MAX_STAT_VALUE, remaining) + 1);
                evs.set(stat, value);
                total += value;

            } else {
                evs.set(stat, 0);
            }
        }

        return evs;
    }
}
