package com.example.randomizer;

import com.example.TemplateMod;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public enum RandomizerItems {
    EV_RANDOMIZER("ev_randomizer", new EVRandomizer()),
    IV_RANDOMIZER("iv_randomizer", new IVRandomizer()),
    LEVEL_RANDOMIZER("level_randomizer", new LevelRandomizer());

    private final Identifier identifier;
    private final Item item;

    RandomizerItems(String path, Item item) {
        this.identifier = Identifier.of(TemplateMod.MOD_ID, path);
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public Identifier getIdentifier() {
        return identifier;
    }
}
