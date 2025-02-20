package kiwiapollo.wanteditems;

import kiwiapollo.wanteditems.luckybox.cobblemon.CobblemonLuckyBoxItems;
import kiwiapollo.wanteditems.luckybox.mythsandlegends.MythsAndLegends;
import kiwiapollo.wanteditems.luckybox.mythsandlegends.MythsAndLegendsLuckyBoxItems;
import kiwiapollo.wanteditems.luckyegg.LuckyEggItems;
import kiwiapollo.wanteditems.randomizer.RandomizerItems;
import kiwiapollo.wanteditems.stateditor.StatEditorItems;
import kiwiapollo.wanteditems.swapper.PropertySwapperItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.loader.api.FabricLoader;
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
			.icon(() -> new ItemStack(LuckyEggItems.SHINY_GOLD_LUCKY_EGG.getItem()))
			.displayName(Text.translatable("item_group.wanteditems.title"))
			.build();

	@Override
	public void onInitialize() {
		addItemGroup();

		addStatEditorItems();
		addPropertySwapperItems();
		addLuckyEggItems();
		addRandomizerItems();
		addCobblemonLuckyBoxItems();
		addMythsAndLegendsLuckyBoxItems();
	}

	private void addItemGroup() {
		Registry.register(Registries.ITEM_GROUP, ITEM_GROUP_REGISTRY_KEY, ITEM_GROUP);
	}

	private void addStatEditorItems() {
		Arrays.stream(StatEditorItems.values()).forEach(item -> {
			Registry.register(Registries.ITEM, item.getIdentifier(), item.getItem());
		});

		ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP_REGISTRY_KEY).register(itemGroup -> {
			Arrays.stream(StatEditorItems.values()).forEach(item -> {
				itemGroup.add(item.getItem());
			});
		});
	}

	private void addPropertySwapperItems() {
		Arrays.stream(PropertySwapperItems.values()).forEach(item -> {
			Registry.register(Registries.ITEM, item.getIdentifier(), item.getItem());
		});

		ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP_REGISTRY_KEY).register(itemGroup -> {
			Arrays.stream(PropertySwapperItems.values()).forEach(item -> {
				itemGroup.add(item.getItem());
			});
		});
	}

	private void addLuckyEggItems() {
		Arrays.stream(LuckyEggItems.values()).forEach(item -> {
			Registry.register(Registries.ITEM, item.getIdentifier(), item.getItem());
		});

		ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP_REGISTRY_KEY).register(itemGroup -> {
			Arrays.stream(LuckyEggItems.values()).forEach(item -> {
				itemGroup.add(item.getItem());
			});
		});
	}

	private void addRandomizerItems() {
		Arrays.stream(RandomizerItems.values()).forEach(item -> {
			Registry.register(Registries.ITEM, item.getIdentifier(), item.getItem());
		});

		ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP_REGISTRY_KEY).register(itemGroup -> {
			Arrays.stream(RandomizerItems.values()).forEach(item -> {
				itemGroup.add(item.getItem());
			});
		});
	}

	private void addCobblemonLuckyBoxItems() {
		Arrays.stream(CobblemonLuckyBoxItems.values()).forEach(item -> {
			Registry.register(Registries.ITEM, item.getIdentifier(), item.getItem());
		});

		ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP_REGISTRY_KEY).register(itemGroup -> {
			Arrays.stream(CobblemonLuckyBoxItems.values()).forEach(item -> {
				itemGroup.add(item.getItem());
			});
		});
	}

	private void addMythsAndLegendsLuckyBoxItems() {
		if (!FabricLoader.getInstance().isModLoaded(MythsAndLegends.MOD_ID)) {
			return;
		}

		Arrays.stream(MythsAndLegendsLuckyBoxItems.values()).forEach(item -> {
			Registry.register(Registries.ITEM, item.getIdentifier(), item.getItem());
		});

		ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP_REGISTRY_KEY).register(itemGroup -> {
			Arrays.stream(MythsAndLegendsLuckyBoxItems.values()).forEach(item -> {
				itemGroup.add(item.getItem());
			});
		});
	}
}