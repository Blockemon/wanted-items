package kiwiapollo.wanteditems.randomizer;

import com.cobblemon.mod.common.api.pokemon.stats.Stats;
import com.cobblemon.mod.common.pokemon.IVs;
import com.cobblemon.mod.common.pokemon.Pokemon;
import kiwiapollo.wanteditems.common.UserOwnedPokemonTargetingItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class IVRandomizer extends UserOwnedPokemonTargetingItem {
    public IVRandomizer() {
        super(new Item.Settings());
    }

    @Override
    protected ActionResult useOnPokemon(ItemStack stack, PlayerEntity user, Pokemon pokemon, Hand hand) {
        IVs ivs = IVs.Companion.createRandomIVs(0);
        pokemon.setIV(Stats.ATTACK, ivs.getOrDefault(Stats.ATTACK));
        pokemon.setIV(Stats.DEFENCE, ivs.getOrDefault(Stats.DEFENCE));
        pokemon.setIV(Stats.SPECIAL_ATTACK, ivs.getOrDefault(Stats.SPECIAL_ATTACK));
        pokemon.setIV(Stats.SPECIAL_DEFENCE, ivs.getOrDefault(Stats.SPECIAL_DEFENCE));
        pokemon.setIV(Stats.HP, ivs.getOrDefault(Stats.HP));
        pokemon.setIV(Stats.SPEED, ivs.getOrDefault(Stats.SPEED));

        if (!user.isCreative()) {
            stack.decrement(1);
        }

        return ActionResult.SUCCESS;
    }
}
