package kiwiapollo.wanteditems.luckybox.cobblemon;

import com.cobblemon.mod.common.CobblemonItems;
import kiwiapollo.wanteditems.common.SimpleFactory;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CobblemonItemFactory implements SimpleFactory<Item> {
    private static final List<Item> FORBIDDEN_ITEMS = List.of();

    @Override
    public Item create() {
        List<Item> random = new ArrayList<>(CobblemonItems.INSTANCE.all());
        random.removeAll(FORBIDDEN_ITEMS);
        Collections.shuffle(random);
        return random.get(0);
    }
}
