package kiwiapollo.wanteditems.misc;

import kiwiapollo.wanteditems.WantedItems;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public enum MiscItem {
    DITTO_RESIDUE("ditto_residue", new DittoResidue());

    private final Identifier identifier;
    private final Item item;

    MiscItem(String path, Item item) {
        this.identifier = Identifier.of(WantedItems.MOD_ID, path);
        this.item = item;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public Item getItem() {
        return item;
    }
}
