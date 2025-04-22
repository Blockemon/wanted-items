package kiwiapollo.wanteditems.luckybox;

import kiwiapollo.wanteditems.WantedItems;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public enum LuckyBoxItems {
    COBBLEMON_LUCKY_BOX("cobblemon_lucky_box", new CobblemonLuckyBox()),
    MYTHS_AND_LEGENDS_LUCKY_BOX("myths_and_legends_lucky_box", new MythsAndLegendsLuckyBox());

    private final Identifier identifier;
    private final Item item;

    LuckyBoxItems(String path, Item item) {
        this.identifier = Identifier.of(WantedItems.MOD_ID, path);
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public boolean canBeAdded() {
        if (item instanceof OptionalItem) {
            return ((OptionalItem) item).test();

        } else {
            return true;
        }
    }
}
