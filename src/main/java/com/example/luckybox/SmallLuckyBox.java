package com.example.luckybox;

import java.util.List;

public class SmallLuckyBox extends PokemonLuckyBox {
    public SmallLuckyBox() {
        super(new RandomPokemonFactory(
                List.of(),
                List.of("legendary", "mythical", "paradox", "ultra_beast")
        ));
    }
}
