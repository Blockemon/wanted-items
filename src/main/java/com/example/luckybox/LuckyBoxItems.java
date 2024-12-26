package com.example.luckybox;

import com.example.TemplateMod;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public enum LuckyBoxItems {
    LARGE_LUCKY_BOX("large_lucky_box", new LargeLuckyBox()),
    LARGE_SHINY_LUCKY_BOX("large_shiny_lucky_box", new LargeShinyLuckyBox()),
    SMALL_LUCKY_BOX("small_lucky_box", new SmallLuckyBox()),
    SMALL_SHINY_LUCKY_BOX("small_shiny_lucky_box", new SmallShinyLuckyBox()),

    ITEM_LUCKY_BOX("item_lucky_box", new ItemLuckyBox());

    private final Identifier identifier;
    private final Item item;

    LuckyBoxItems(String path, Item item) {
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
