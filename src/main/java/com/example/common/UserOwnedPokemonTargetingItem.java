package com.example.common;

import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.cobblemon.mod.common.pokemon.Pokemon;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public abstract class UserOwnedPokemonTargetingItem extends Item {
    public UserOwnedPokemonTargetingItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (!(entity instanceof PokemonEntity)) {
            return ActionResult.PASS;
        }

        Pokemon pokemon = ((PokemonEntity) entity).getPokemon();
        if (!isUserOwnedPokemon(pokemon, user)) {
            return ActionResult.PASS;
        }

        return useOnPokemon(stack, user, pokemon, hand);
    }

    private boolean isUserOwnedPokemon(Pokemon pokemon, PlayerEntity user) {
        return pokemon.isPlayerOwned() && pokemon.getOwnerPlayer().getUuid().equals(user.getUuid());
    }

    protected abstract ActionResult useOnPokemon(ItemStack stack, PlayerEntity user, Pokemon pokemon, Hand hand);
}
