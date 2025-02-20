package kiwiapollo.wanteditems.luckybox.mythsandlegends;

import kiwiapollo.wanteditems.WantedItems;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public enum MythsAndLegendsLuckyBoxItems {
    MYTHS_AND_LEGENDS_LUCKY_BOX("myths_and_legends_lucky_box", new MythsAndLegendsLuckyBox());

    private final Identifier identifier;
    private final Item item;

    MythsAndLegendsLuckyBoxItems(String path, Item item) {
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
