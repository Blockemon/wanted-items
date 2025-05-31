package kiwiapollo.wanteditems.randomizer;

import kiwiapollo.wanteditems.WantedItems;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public enum RandomizerItem {
    EV_RANDOMIZER("ev_randomizer", new EVRandomizer()),
    IV_RANDOMIZER("iv_randomizer", new IVRandomizer()),
    LEVEL_RANDOMIZER("level_randomizer", new LevelRandomizer());

    private final Identifier identifier;
    private final Item item;

    RandomizerItem(String path, Item item) {
        this.identifier = Identifier.of(WantedItems.MOD_ID, path);
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public Identifier getIdentifier() {
        return identifier;
    }
}
