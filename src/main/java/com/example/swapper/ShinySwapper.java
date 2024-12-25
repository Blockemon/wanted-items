package com.example.swapper;

import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.cobblemon.mod.common.pokemon.Pokemon;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class ShinySwapper extends Item {
    public ShinySwapper() {
        super(new Item.Settings());
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (!(entity instanceof PokemonEntity)) {
            return ActionResult.PASS;
        }

        Pokemon pokemon = ((PokemonEntity) entity).getPokemon();
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
