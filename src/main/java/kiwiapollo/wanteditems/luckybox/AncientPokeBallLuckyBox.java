package kiwiapollo.wanteditems.luckybox;

import com.cobblemon.mod.common.CobblemonItems;
import com.cobblemon.mod.common.item.PokeBallItem;
import kiwiapollo.wanteditems.common.SimpleFactory;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AncientPokeBallLuckyBox extends LuckyBox {
    public AncientPokeBallLuckyBox() {
        super(new PokeBallItemFactory());
    }

    private static class PokeBallItemFactory implements SimpleFactory<Item> {
        @Override
        public Item create() {
            List<Item> random = getPokeBallItems();
            random.removeAll(getForbiddenItems());
            Collections.shuffle(random);
            return random.get(0);
        }

        private List<Item> getPokeBallItems() {
            return new ArrayList<>(CobblemonItems.INSTANCE.all().stream()
                    .filter(item -> item instanceof PokeBallItem)
                    .filter(item -> ((PokeBallItem) item).getPokeBall().getAncient())
                    .toList());
        }

        private List<Item> getForbiddenItems() {
            return List.of(
                    CobblemonItems.ANCIENT_ORIGIN_BALL
            );
        }
    }
}
