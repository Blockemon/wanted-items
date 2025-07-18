package kiwiapollo.wanteditems.luckybox;

import kiwiapollo.wanteditems.common.SimpleFactory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class LuckyBox extends Item {
    private final SimpleFactory<Item> factory;

    public LuckyBox(SimpleFactory<Item> factory) {
        super(new Item.Settings());
        this.factory = factory;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient()) {
            return TypedActionResult.pass(user.getStackInHand(hand));
        }

        ItemStack random = factory.create().getDefaultStack();
        if (!user.giveItemStack(random)) {
            user.dropItem(random, true);
        }

        if (!user.isCreative()) {
            user.getStackInHand(hand).decrement(1);
        }

        user.playSoundToPlayer(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 1F, 1F);
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
