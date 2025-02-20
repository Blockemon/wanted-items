package kiwiapollo.wanteditems.luckybox.cobblemon;

import kiwiapollo.wanteditems.WantedItems;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public enum CobblemonLuckyBoxItems {
    COBBLEMON_LUCKY_BOX("cobblemon_lucky_box", new CobblemonLuckyBox());

    private final Identifier identifier;
    private final Item item;

    CobblemonLuckyBoxItems(String path, Item item) {
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
