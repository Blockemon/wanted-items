package kiwiapollo.wanteditems.luckyegg;

import com.cobblemon.mod.common.api.pokemon.PokemonSpecies;
import com.cobblemon.mod.common.pokemon.Pokemon;
import com.cobblemon.mod.common.pokemon.Species;
import kiwiapollo.wanteditems.common.SimpleFactory;

import java.util.ArrayList;
import java.util.Collections;
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
        List<Species> random = new ArrayList<>(PokemonSpecies.INSTANCE.getImplemented().stream()
                .filter(species -> !FORBIDDEN_SPECIES.contains(species.getResourceIdentifier().toString()))
                .filter(species -> required.isEmpty() || required.stream().anyMatch(label -> species.getLabels().contains(label)))
                .filter(species -> forbidden.isEmpty() || forbidden.stream().noneMatch(label -> species.getLabels().contains(label)))
                .toList());

        Collections.shuffle(random);

        return random.get(0).create(LEVEL);
    }
}
