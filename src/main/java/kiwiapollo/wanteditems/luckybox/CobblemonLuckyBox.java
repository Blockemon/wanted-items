package kiwiapollo.wanteditems.luckybox;

import com.cobblemon.mod.common.CobblemonItems;
import kiwiapollo.wanteditems.common.SimpleFactory;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CobblemonLuckyBox extends LuckyBox {
    public CobblemonLuckyBox() {
        super(new CobblemonItemFactory());
    }

    private static class CobblemonItemFactory implements SimpleFactory<Item> {
        @Override
        public Item create() {
            List<Item> random = new ArrayList<>(CobblemonItems.INSTANCE.all());
            random.removeAll(getForbiddenItems());
            Collections.shuffle(random);
            return random.get(0);
        }

        /**
         * Unable to create FORBIDDEN_ITEMS constant.
         * <p>
         * According to ChatGPT:
         * <p>
         * Cobblemon uses a lateinit var implementation pattern,
         * which only gets initialized after Cobblemon's own onInitialize() has run.
         * You are trying to access CobblemonItems in a static context
         * */
        private List<Item> getForbiddenItems() {
            return List.of(
                    CobblemonItems.POKEMON_MODEL
            );
        }
    }
}
