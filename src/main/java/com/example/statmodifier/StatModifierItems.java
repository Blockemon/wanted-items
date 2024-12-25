package com.example.statmodifier;

import com.cobblemon.mod.common.api.pokemon.stats.Stats;
import com.example.TemplateMod;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public enum StatModifierItems {
    GOLDEN_BOTTLE_CAP("golden_bottle_cap", new GoldenBottleCap()),
    SILVER_BOTTLE_CAP("silver_bottle_cap", new SilverBottleCap()),

    BLACK_BOTTLE_CAP("black_bottle_cap", new SilverBottleCap(Stats.ATTACK)),
    YELLOW_BOTTLE_CAP("yello_bottle_cap", new SilverBottleCap(Stats.DEFENCE)),
    RED_BOTTLE_CAP("red_bottle_cap", new SilverBottleCap(Stats.HP)),
    BLUE_BOTTLE_CAP("blue_bottle_cap", new SilverBottleCap(Stats.SPECIAL_ATTACK)),
    GREEN_BOTTLE_CAP("green_bottle_cap", new SilverBottleCap(Stats.SPECIAL_DEFENCE)),
    PINK_BOTTLE_CAP("pink_bottle_cap", new SilverBottleCap(Stats.SPEED)),

    DRY_ROOT("dry_root", new DryRoot());

    private final Identifier identifier;
    private final Item item;

    StatModifierItems(String path, Item item) {
        this.identifier = Identifier.of(TemplateMod.MOD_ID, path);
        this.item = item;
    }
}
