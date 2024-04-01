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

    public static class RocketPokemonFactory implements IPokemonFactory {

        private static Map<Integer, String> index2name;
        static {
            Map<Integer, String> aMap = new HashMap<Integer, String>();
            aMap.put(-1, "Ash's Pikachu");
            aMap.put(0, "MISSINGNO");
            aMap.put(1, "Bulbasaur");
            //TODO : Gotta map them all !
            index2name = UnmodifiableMap.unmodifiableMap(aMap);
        }

        private static int generateRandomStat() {
            int total = 0;
            for(int i=0; i < 1000000; i++)
            {
                Random rn = new Random();
                int r = rn.nextInt(2);
                total = total + r;
            }
            return total / 10000;
        }

        @Override
        public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
            String name;
            if(!index2name.containsKey(index)) {
                name = index2name.get(0);
            } else {
                name = index2name.get(index);
            }
            int attack;
            int defense;
            int stamina;
            double iv;
            if(index < 0) {
                attack = 1000;
                defense = 1000;
                stamina = 1000;
                iv = 0;
            } else {
                attack = fr.univavignon.pokedex.api.RocketPokemonFactory.generateRandomStat();
                defense = fr.univavignon.pokedex.api.RocketPokemonFactory.generateRandomStat();
                stamina = fr.univavignon.pokedex.api.RocketPokemonFactory.generateRandomStat();
                iv = 1;
            }
            return new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, iv);
        }

    }
}
