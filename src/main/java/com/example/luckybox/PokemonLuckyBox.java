package com.example.luckybox;

import com.cobblemon.mod.common.Cobblemon;
import com.cobblemon.mod.common.pokemon.Pokemon;
import com.example.common.SimpleFactory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class PokemonLuckyBox extends Item {
    private final SimpleFactory<Pokemon> factory;

    public PokemonLuckyBox(SimpleFactory<Pokemon> factory) {
        super(new Item.Settings());
        this.factory = factory;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        Cobblemon.INSTANCE.getStorage().getParty((ServerPlayerEntity) user).add(factory.create());

        if (!user.isCreative()) {
            user.getStackInHand(hand).decrement(1);
        }

        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
