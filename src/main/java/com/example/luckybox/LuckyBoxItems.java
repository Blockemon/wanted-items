package com.example.luckybox;

import net.minecraft.item.Item;

public enum LuckyBoxItems {
    LARGE_LUCKY_BOX("large_lucky_box", new LargeLuckyBox()),
    LARGE_SHINY_LUCKY_BOX("large_shiny_lucky_box", new LargeShinyLuckyBox()),
    SMALL_LUCKY_BOX("small_lucky_box", new SmallLuckyBox()),
    SMALL_SHINY_LUCKY_BOX("small_shiny_lucky_box", new SmallShinyLuckyBox()),

    ITEM_LUCKY_BOX("item_lucky_box", new ItemLuckyBox());

    private final String identifier;
    private final Item item;

    LuckyBoxItems(String identifier, Item item) {
        this.identifier = identifier;
        this.item = item;
    }
}
