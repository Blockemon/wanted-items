package com.example.statmodifier;

import com.cobblemon.mod.common.api.pokemon.stats.Stats;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.cobblemon.mod.common.pokemon.Pokemon;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

import java.util.Arrays;

public class DryRoot extends Item {
    public DryRoot() {
        super(new Item.Settings());
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (!(entity instanceof PokemonEntity)) {
            return ActionResult.PASS;
        }

        Pokemon pokemon = ((PokemonEntity) entity).getPokemon();
        Arrays.stream(Stats.values()).forEach(stats -> {
            pokemon.setEV(stats, 0);
        });

        if (!user.isCreative()) {
            stack.decrement(1);
        }

        return ActionResult.SUCCESS;
    }
}
