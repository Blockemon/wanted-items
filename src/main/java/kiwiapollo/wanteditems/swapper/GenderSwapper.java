package kiwiapollo.wanteditems.swapper;

import com.cobblemon.mod.common.CobblemonSounds;
import com.cobblemon.mod.common.pokemon.Gender;
import com.cobblemon.mod.common.pokemon.Pokemon;
import kiwiapollo.wanteditems.common.UserOwnedPokemonTargetingItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class GenderSwapper extends UserOwnedPokemonTargetingItem {
    public GenderSwapper() {
        super(new Item.Settings());
    }

    @Override
    protected ActionResult useOnPokemon(ItemStack stack, PlayerEntity user, Pokemon pokemon, Hand hand) {
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

        user.playSound(CobblemonSounds.MEDICINE_PILLS_USE, SoundCategory.PLAYERS, 1F, 1F);
        return ActionResult.SUCCESS;
    }

    private void setMale(Pokemon pokemon) {
        pokemon.setGender(Gender.MALE);
    }

    private void setFemale(Pokemon pokemon) {
        pokemon.setGender(Gender.FEMALE);
    }
}
