package kiwiapollo.wanteditems.luckyegg;

import kiwiapollo.wanteditems.WantedItems;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public enum LuckyEggItem {
    GOLD_LUCKY_EGG("gold_lucky_egg", new GoldLuckyEgg()),
    SHINY_GOLD_LUCKY_EGG("shiny_gold_lucky_egg", new ShinyGoldLuckyEgg()),
    SILVER_LUCKY_EGG("silver_lucky_egg", new SilverLuckyEgg()),
    SHINY_SILVER_LUCKY_EGG("shiny_silver_lucky_egg", new ShinySilverLuckyEgg());

    private final Identifier identifier;
    private final Item item;

    LuckyEggItem(String path, Item item) {
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
