package com.example.swapper;

import com.cobblemon.mod.common.pokemon.Pokemon;
import com.example.common.UserOwnedPokemonTargetingItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class ShinySwapper extends UserOwnedPokemonTargetingItem {
    public ShinySwapper() {
        super(new Item.Settings());
    }

    @Override
    protected ActionResult useOnPokemon(ItemStack stack, PlayerEntity user, Pokemon pokemon, Hand hand) {
        if (pokemon.getShiny()) {
            setNonShiny(pokemon);
        } else {
            setShiny(pokemon);
        }

        if (!user.isCreative()) {
            stack.decrement(1);
        }

        return ActionResult.SUCCESS;
    }

    private void setShiny(Pokemon pokemon) {
        pokemon.setShiny(true);
    }

    private void setNonShiny(Pokemon pokemon) {
        pokemon.setShiny(false);
    }
}
