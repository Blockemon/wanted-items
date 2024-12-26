package kiwiapollo.wanteditems;

import kiwiapollo.wanteditems.luckybox.LuckyBoxItems;
import kiwiapollo.wanteditems.randomizer.RandomizerItems;
import kiwiapollo.wanteditems.stateditor.StatEditorItems;
import kiwiapollo.wanteditems.swapper.PropertySwapperItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Arrays;

public class WantedItems implements ModInitializer {
	public static final String MOD_ID = "wanteditems";

	public static final Identifier ITEM_GROUP_ID = Identifier.of(WantedItems.MOD_ID, "item_group");
	public static final RegistryKey<ItemGroup> ITEM_GROUP_REGISTRY_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), ITEM_GROUP_ID);
	private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
			.icon(() -> new ItemStack(StatEditorItems.GOLD_BOTTLE_CAP.getItem()))
			.displayName(Text.translatable("item_group.wanteditems.title"))
			.build();

	@Override
	public void onInitialize() {
		Arrays.stream(StatEditorItems.values()).forEach(item -> {
			Registry.register(Registries.ITEM, item.getIdentifier(), item.getItem());
		});

		Arrays.stream(PropertySwapperItems.values()).forEach(item -> {
			Registry.register(Registries.ITEM, item.getIdentifier(), item.getItem());
		});

		Arrays.stream(LuckyBoxItems.values()).forEach(item -> {
			Registry.register(Registries.ITEM, item.getIdentifier(), item.getItem());
		});

		Arrays.stream(RandomizerItems.values()).forEach(item -> {
			Registry.register(Registries.ITEM, item.getIdentifier(), item.getItem());
		});

		Registry.register(Registries.ITEM_GROUP, ITEM_GROUP_REGISTRY_KEY, ITEM_GROUP);

		ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP_REGISTRY_KEY).register(itemGroup -> {
			Arrays.stream(StatEditorItems.values()).forEach(item -> {
				itemGroup.add(item.getItem());
			});

			Arrays.stream(PropertySwapperItems.values()).forEach(item -> {
				itemGroup.add(item.getItem());
			});

			Arrays.stream(LuckyBoxItems.values()).forEach(item -> {
				itemGroup.add(item.getItem());
			});

			Arrays.stream(RandomizerItems.values()).forEach(item -> {
				itemGroup.add(item.getItem());
			});
		});
	}
}