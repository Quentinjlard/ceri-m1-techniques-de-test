package fr.univavignon.pokedex.api;

import org.apache.commons.collections4.map.UnmodifiableMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    private static final PokemonMetadata[] metadata = {
            new PokemonMetadata(126, "Bulbasaur", 126, 90,60),
            new PokemonMetadata(156, "Ivysaur",  158, 120,80),
            new PokemonMetadata(198, "Venusaur", 200, 160,100),
            // Add more PokemonMetadata objects as needed
    };

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (index < 0 || index >= metadata.length) {
            throw new PokedexException("Invalid index: " + index);
        }
        return metadata[index];
    }
}
