package kiwiapollo.wanteditems.duplicator;

import kiwiapollo.wanteditems.WantedItems;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public enum MiscItems {
    DITTO_RESIDUE("ditto_residue", new DittoResidue());

    private final Identifier identifier;
    private final Item item;

    MiscItems(String path, Item item) {
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
