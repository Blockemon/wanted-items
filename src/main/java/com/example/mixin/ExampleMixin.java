package com.example.mixin;

import com.cobblemon.mod.common.item.PokeBallItem;
import com.example.swapper.PropertySwapperItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PokeBallItem.class)
public class ExampleMixin {
	@Inject(at = @At("HEAD"), method = "use", cancellable = true)
	private void cancelOnUsingCaughtBallSwapper(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> info) {
		if (user.getStackInHand(getOtherHand(hand)).getItem().equals(PropertySwapperItems.CAUGHT_BALL_SWAPPER.getItem())) {
			info.setReturnValue(TypedActionResult.pass(user.getStackInHand(hand)));
			info.cancel();
		}
	}

	private Hand getOtherHand(Hand hand) {
		return switch (hand) {
			case MAIN_HAND -> Hand.OFF_HAND;
			case OFF_HAND -> Hand.MAIN_HAND;
		};
	}
}