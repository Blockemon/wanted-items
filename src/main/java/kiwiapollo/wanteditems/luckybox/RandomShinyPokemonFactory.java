package kiwiapollo.wanteditems.luckybox;

import com.cobblemon.mod.common.pokemon.Pokemon;
import kiwiapollo.wanteditems.common.SimpleFactory;

import java.util.List;

public class RandomShinyPokemonFactory implements SimpleFactory<Pokemon> {
    private final SimpleFactory<Pokemon> factory;

    public RandomShinyPokemonFactory(List<String> required, List<String> forbidden) {
        this.factory = new RandomPokemonFactory(required, forbidden);
    }

    public RandomShinyPokemonFactory() {
        this(List.of(), List.of());
    }

    @Override
    public Pokemon create() {
        Pokemon pokemon = factory.create();
        pokemon.setShiny(true);

        return pokemon;
    }
}
