package kiwiapollo.wanteditems.luckybox;

import java.util.List;

public class SilverLuckyEgg extends PokemonLuckyBox {
    public SilverLuckyEgg() {
        super(new RandomPokemonFactory(
                List.of(),
                List.of("legendary", "mythical", "paradox", "ultra_beast")
        ));
    }
}
