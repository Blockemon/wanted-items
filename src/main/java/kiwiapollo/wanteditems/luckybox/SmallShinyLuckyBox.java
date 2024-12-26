package kiwiapollo.wanteditems.luckybox;

import java.util.List;

public class SmallShinyLuckyBox extends PokemonLuckyBox {
    public SmallShinyLuckyBox() {
        super(new RandomShinyPokemonFactory(
                List.of(),
                List.of("legendary", "mythical", "paradox", "ultra_beast")
        ));
    }
}
