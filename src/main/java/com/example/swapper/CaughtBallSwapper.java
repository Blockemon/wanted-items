package com.example.swapper;

import com.cobblemon.mod.common.api.tags.CobblemonItemTags;
import com.cobblemon.mod.common.item.PokeBallItem;
import com.cobblemon.mod.common.pokeball.PokeBall;
import com.cobblemon.mod.common.pokemon.Pokemon;
import com.example.common.UserOwnedPokemonTargetingItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

import java.util.List;

public class CaughtBallSwapper extends UserOwnedPokemonTargetingItem {
    public CaughtBallSwapper() {
        super(new Item.Settings());
    }

    @Override
    protected ActionResult useOnPokemon(ItemStack stack, PlayerEntity user, Pokemon pokemon, Hand hand) {
        if (!isHoldingPokeBall(user, getOtherHand(hand))) {
            return ActionResult.PASS;
        }

        PokeBall pokeBall = ((PokeBallItem) user.getStackInHand(getOtherHand(hand)).getItem()).getPokeBall();
        if (pokemon.getCaughtBall() == pokeBall) {
            return ActionResult.PASS;
        }

        pokemon.setCaughtBall(pokeBall);

        if (!user.isCreative()) {
            stack.decrement(1);
            user.getStackInHand(getOtherHand(hand)).decrement(1);
        }

        return ActionResult.SUCCESS;
    }

    private boolean isHoldingPokeBall(PlayerEntity user, Hand hand) {
        List<Item> pokeBalls = Registries.ITEM.getEntryList(CobblemonItemTags.POKE_BALLS).orElseThrow().stream().map(RegistryEntry::value).toList();
        return pokeBalls.contains(user.getStackInHand(hand).getItem());
    }

    private Hand getOtherHand(Hand hand) {
        return switch (hand) {
            case MAIN_HAND -> Hand.OFF_HAND;
            case OFF_HAND -> Hand.MAIN_HAND;
        };
    }
}
