package com.example.swapper;

import com.example.TemplateMod;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public enum PropertySwapperItems {
    CAUGHT_BALL_SWAPPER("caught_ball_swapper", new CaughtBallSwapper()),
    GENDER_SWAPPER("gender_swapper", new GenderSwapper()),
    SHINY_SWAPPER("shiny_swapper", new ShinySwapper());

    private final Identifier identifier;
    private final Item item;

    PropertySwapperItems(String path, Item item) {
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
