package kiwiapollo.wanteditems.randomizer;

import com.cobblemon.mod.common.pokemon.Pokemon;
import kiwiapollo.wanteditems.common.UserOwnedPokemonTargetingItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

import java.util.Random;

public class LevelRandomizer extends UserOwnedPokemonTargetingItem {
    private static final int MINIMUM_LEVEL = 10;
    private static final int MAXIMUM_LEVEL = 100;

    public LevelRandomizer() {
        super(new Item.Settings());
    }

    @Override
    protected ActionResult useOnPokemon(ItemStack stack, PlayerEntity user, Pokemon pokemon, Hand hand) {
        pokemon.setLevel(new Random().nextInt(MINIMUM_LEVEL, MAXIMUM_LEVEL));

        if (!user.isCreative()) {
            stack.decrement(1);
        }

        return ActionResult.SUCCESS;
    }
}
