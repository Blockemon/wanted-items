package kiwiapollo.wanteditems.stateditor;

import com.cobblemon.mod.common.CobblemonSounds;
import com.cobblemon.mod.common.api.battles.model.actor.BattleActor;
import com.cobblemon.mod.common.api.item.PokemonSelectingItem;
import com.cobblemon.mod.common.api.pokemon.stats.Stats;
import com.cobblemon.mod.common.battles.pokemon.BattlePokemon;
import com.cobblemon.mod.common.item.battle.BagItem;
import com.cobblemon.mod.common.pokemon.IVs;
import com.cobblemon.mod.common.pokemon.Pokemon;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GoldBottleCap extends Item implements PokemonSelectingItem {
    public GoldBottleCap() {
        super(new Item.Settings());
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);

        if (world.isClient()) {
            return TypedActionResult.pass(itemStack);
        }

        return use((ServerPlayerEntity) player, itemStack);
    }

    @Override
    public @Nullable BagItem getBagItem() {
        return null;
    }

    @Override
    public @NotNull TypedActionResult<ItemStack> use(@NotNull ServerPlayerEntity player, @NotNull ItemStack itemStack) {
        return PokemonSelectingItem.DefaultImpls.use(this, player, itemStack);
    }

    @Override
    public @Nullable TypedActionResult<ItemStack> applyToPokemon(@NotNull ServerPlayerEntity player, @NotNull ItemStack itemStack, @NotNull Pokemon pokemon) {
        if (isPerfectIVs(pokemon)) {
            player.playSound(SoundEvents.ITEM_SHIELD_BLOCK, SoundCategory.PLAYERS, 1F, 1F);
            player.sendMessage(Text.translatable("item.wanteditems.error.has_maximum_stats", pokemon.getSpecies().getTranslatedName()).formatted(Formatting.RED));
            return TypedActionResult.pass(itemStack);
        }

        pokemon.setIV(Stats.ATTACK, IVs.MAX_VALUE);
        pokemon.setIV(Stats.DEFENCE, IVs.MAX_VALUE);
        pokemon.setIV(Stats.SPECIAL_ATTACK, IVs.MAX_VALUE);
        pokemon.setIV(Stats.SPECIAL_DEFENCE, IVs.MAX_VALUE);
        pokemon.setIV(Stats.HP, IVs.MAX_VALUE);
        pokemon.setIV(Stats.SPEED, IVs.MAX_VALUE);

        if (!player.isCreative()) {
            itemStack.decrement(1);
        }

        player.playSound(CobblemonSounds.MEDICINE_PILLS_USE, SoundCategory.PLAYERS, 1F, 1F);
        return TypedActionResult.success(itemStack);
    }

    private boolean isPerfectIVs(Pokemon pokemon) {
        return pokemon.getIvs().get(Stats.ATTACK).equals(IVs.MAX_VALUE)
                && pokemon.getIvs().get(Stats.DEFENCE).equals(IVs.MAX_VALUE)
                && pokemon.getIvs().get(Stats.SPECIAL_ATTACK).equals(IVs.MAX_VALUE)
                && pokemon.getIvs().get(Stats.SPECIAL_DEFENCE).equals(IVs.MAX_VALUE)
                && pokemon.getIvs().get(Stats.HP).equals(IVs.MAX_VALUE)
                && pokemon.getIvs().get(Stats.SPEED).equals(IVs.MAX_VALUE);
    }

    @Override
    public void applyToBattlePokemon(@NotNull ServerPlayerEntity serverPlayerEntity, @NotNull ItemStack itemStack, @NotNull BattlePokemon battlePokemon) {

    }

    @Override
    public boolean canUseOnPokemon(@NotNull Pokemon pokemon) {
        return true;
    }

    @Override
    public boolean canUseOnBattlePokemon(@NotNull BattlePokemon battlePokemon) {
        return false;
    }

    @Override
    public @NotNull TypedActionResult<ItemStack> interactWithSpecificBattle(@NotNull ServerPlayerEntity player, @NotNull ItemStack itemStack, @NotNull BattlePokemon battlePokemon) {
        return PokemonSelectingItem.DefaultImpls.interactWithSpecificBattle(this, player, itemStack, battlePokemon);
    }

    @Override
    public @NotNull TypedActionResult<ItemStack> interactGeneral(@NotNull ServerPlayerEntity player, @NotNull ItemStack itemStack) {
        return PokemonSelectingItem.DefaultImpls.interactGeneral(this, player, itemStack);
    }

    @Override
    public @NotNull TypedActionResult<ItemStack> interactGeneralBattle(@NotNull ServerPlayerEntity player, @NotNull ItemStack itemStack, @NotNull BattleActor battleActor) {
        return PokemonSelectingItem.DefaultImpls.interactGeneralBattle(this, player, itemStack, battleActor);
    }
}
