package kiwiapollo.wanteditems.luckybox;

import com.github.d0ctorleon.mythsandlegends.MythsAndLegends;
import kiwiapollo.wanteditems.common.SimpleFactory;
import kiwiapollo.wanteditems.datagen.ModTagRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MythsAndLegendsLuckyBox extends LuckyBox {
    public MythsAndLegendsLuckyBox() {
        super(new MythsAndLegendsItemFactory());
    }

    private static class MythsAndLegendsItemFactory implements SimpleFactory<Item> {
        @Override
        public Item create() {
            if (!FabricLoader.getInstance().isModLoaded(MythsAndLegends.MOD_ID)) {
                throw new IllegalStateException();
            }

            List<Item> random = new ArrayList<>(getItems());
            random.removeAll(getForbiddenItems());
            Collections.shuffle(random);
            return random.get(0);
        }

        private List<Item> getItems() {
            List<Item> items = new ArrayList<>();
            Registries.ITEM.getEntryList(ModTagRegistry.MYTHS_AND_LEGENDS_ITEMS).ifPresent(itemEntryList -> {
                for (RegistryEntry<Item> entry : itemEntryList) {
                    items.add(entry.value());
                }
            });

            return items;
        }

        private List<Item> getForbiddenItems() {
            return List.of();
        }
    }
}
