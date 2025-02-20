package kiwiapollo.wanteditems.luckybox.mythsandlegends;

import kiwiapollo.wanteditems.WantedItems;
import kiwiapollo.wanteditems.common.SimpleFactory;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MythsAndLegendsItemFactory implements SimpleFactory<Item> {
    private static final List<Item> FORBIDDEN_ITEMS = List.of();

    @Override
    public Item create() {
        if (!FabricLoader.getInstance().isModLoaded(MythsAndLegends.MOD_ID)) {
            throw new IllegalStateException();
        }

        List<Item> random = new ArrayList<>(getItems());
        random.removeAll(FORBIDDEN_ITEMS);
        Collections.shuffle(random);
        return random.get(0);
    }

    private List<Item> getItems() {
        Identifier id = Identifier.of(WantedItems.MOD_ID, "myths_and_legends_items");
        TagKey<Item> tagKey = TagKey.of(Registries.ITEM.getKey(), id);

        List<Item> items = new ArrayList<>();
        Registries.ITEM.getEntryList(tagKey).ifPresent(itemEntryList -> {
            for (RegistryEntry<Item> entry : itemEntryList) {
                items.add(entry.value());
            }
        });

        return items;
    }
}
