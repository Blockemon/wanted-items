package kiwiapollo.wanteditems.luckybox;

import java.util.List;

public class ShinySilverLuckyEgg extends PokemonLuckyBox {
    public ShinySilverLuckyEgg() {
        super(new RandomShinyPokemonFactory(
                List.of(),
                List.of("legendary", "mythical", "paradox", "ultra_beast")
        ));
    }
}
