package kiwiapollo.wanteditems.stateditor;

import com.cobblemon.mod.common.api.pokemon.stats.Stats;
import com.cobblemon.mod.common.pokemon.IVs;
import com.cobblemon.mod.common.pokemon.Pokemon;
import kiwiapollo.wanteditems.common.UserOwnedPokemonTargetingItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class GoldBottleCap extends UserOwnedPokemonTargetingItem {
    public GoldBottleCap() {
        super(new Item.Settings());
    }

    @Override
    protected ActionResult useOnPokemon(ItemStack stack, PlayerEntity user, Pokemon pokemon, Hand hand) {
        if (isPerfectIVs(pokemon)) {
            return ActionResult.PASS;
        }

        pokemon.setIV(Stats.ATTACK, IVs.MAX_VALUE);
        pokemon.setIV(Stats.DEFENCE, IVs.MAX_VALUE);
        pokemon.setIV(Stats.SPECIAL_ATTACK, IVs.MAX_VALUE);
        pokemon.setIV(Stats.SPECIAL_DEFENCE, IVs.MAX_VALUE);
        pokemon.setIV(Stats.HP, IVs.MAX_VALUE);
        pokemon.setIV(Stats.SPEED, IVs.MAX_VALUE);

        if (!user.isCreative()) {
            stack.decrement(1);
        }

        return ActionResult.SUCCESS;
    }

    private boolean isPerfectIVs(Pokemon pokemon) {
        return pokemon.getIvs().get(Stats.ATTACK).equals(IVs.MAX_VALUE)
                && pokemon.getIvs().get(Stats.DEFENCE).equals(IVs.MAX_VALUE)
                && pokemon.getIvs().get(Stats.SPECIAL_ATTACK).equals(IVs.MAX_VALUE)
                && pokemon.getIvs().get(Stats.SPECIAL_DEFENCE).equals(IVs.MAX_VALUE)
                && pokemon.getIvs().get(Stats.HP).equals(IVs.MAX_VALUE)
                && pokemon.getIvs().get(Stats.SPEED).equals(IVs.MAX_VALUE);
    }
}
