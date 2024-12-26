package kiwiapollo.wanteditems.stateditor;

import com.cobblemon.mod.common.api.pokemon.stats.Stats;
import com.cobblemon.mod.common.pokemon.EVs;
import com.cobblemon.mod.common.pokemon.Pokemon;
import kiwiapollo.wanteditems.common.UserOwnedPokemonTargetingItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class DryRoot extends UserOwnedPokemonTargetingItem {
    public DryRoot() {
        super(new Item.Settings());
    }

    @Override
    protected ActionResult useOnPokemon(ItemStack stack, PlayerEntity user, Pokemon pokemon, Hand hand) {
        if (pokemon.getEvs().equals(EVs.Companion.createEmpty())) {
            return ActionResult.PASS;
        }

        pokemon.setEV(Stats.ATTACK, 0);
        pokemon.setEV(Stats.DEFENCE, 0);
        pokemon.setEV(Stats.SPECIAL_ATTACK, 0);
        pokemon.setEV(Stats.SPECIAL_DEFENCE, 0);
        pokemon.setEV(Stats.HP, 0);
        pokemon.setEV(Stats.SPEED, 0);

        if (!user.isCreative()) {
            stack.decrement(1);
        }

        return ActionResult.SUCCESS;
    }
}
