package com.example.swapper;

import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.cobblemon.mod.common.pokemon.Gender;
import com.cobblemon.mod.common.pokemon.Pokemon;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class GenderSwapper extends Item {
    public GenderSwapper() {
        super(new Item.Settings());
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (!(entity instanceof PokemonEntity)) {
            return ActionResult.PASS;
        }

        Pokemon pokemon = ((PokemonEntity) entity).getPokemon();
        switch (pokemon.getGender()) {
            case GENDERLESS -> {
                return ActionResult.PASS;
            }
            case FEMALE -> {
                setMale(pokemon);
            }
            case MALE -> {
                setFemale(pokemon);
            }
        }

        if (!user.isCreative()) {
            stack.decrement(1);
        }

        return ActionResult.SUCCESS;
    }

    private void setMale(Pokemon pokemon) {
        pokemon.setGender(Gender.MALE);
    }

    private void setFemale(Pokemon pokemon) {
        pokemon.setGender(Gender.FEMALE);
    }
}
