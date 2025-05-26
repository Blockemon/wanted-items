package kiwiapollo.wanteditems.luckybox;

import kiwiapollo.wanteditems.WantedItems;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public enum LuckyBoxItems {
    COBBLEMON_LUCKY_BOX("cobblemon_lucky_box", new CobblemonLuckyBox()),
    MYTHS_AND_LEGENDS_LUCKY_BOX("myths_and_legends_lucky_box", new MythsAndLegendsLuckyBox()),
    GOLD_CANDY_LUCKY_BOX("gold_candy_lucky_box", new GoldCandyLuckyBox()),
    SILVER_CANDY_LUCKY_BOX("silver_candy_lucky_box", new SilverCandyLuckyBox()),
    GOLD_POKE_BALL_LUCKY_BOX("gold_poke_ball_lucky_box", new GoldPokeBallLuckyBox()),
    SILVER_POKE_BALL_LUCKY_BOX("silver_poke_ball_lucky_box", new SilverPokeBallLuckyBox()),
    ANCIENT_POKE_BALL_LUCKY_BOX("ancient_poke_ball_lucky_box", new AncientPokeBallLuckyBox());

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
