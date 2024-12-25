package com.example.luckybox;

import com.cobblemon.mod.common.api.pokemon.PokemonSpecies;
import com.cobblemon.mod.common.pokemon.Pokemon;
import com.cobblemon.mod.common.pokemon.Species;
import com.example.common.SimpleFactory;

import java.util.ArrayList;
import java.util.List;

public class RandomPokemonFactory implements SimpleFactory<Pokemon> {
    private static final int LEVEL = 10;
    private static final List<String> FORBIDDEN_SPECIES = List.of();

    private final List<String> required;
    private final List<String> forbidden;

    public RandomPokemonFactory() {
        this(List.of(), List.of());
    }

    public RandomPokemonFactory(List<String> required, List<String> forbidden) {
        this.required = required;
        this.forbidden = forbidden;
    }

    @Override
    public Pokemon create() {
        List<Species> implemented = PokemonSpecies.INSTANCE.getImplemented();
        List<Species> random = new ArrayList<>(implemented);

        random = random.stream()
                .filter(species -> !FORBIDDEN_SPECIES.contains(species.getResourceIdentifier().toString()))
                .filter(species -> required.stream().anyMatch(label -> species.getLabels().contains(label)))
                .filter(species -> forbidden.stream().noneMatch(label -> species.getLabels().contains(label)))
                .toList();

        return random.get(0).create(LEVEL);
    }
}
