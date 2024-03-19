package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class PokemonComparatorsTest {

    @Test
    public void testComparatorByName() {
        // Créer des Pokémon pour les tests
        Pokemon pikachu = new Pokemon(20, "Pikachu", 70, 60, 80, 10, 50, 20, 10, 5);
        Pokemon charmander = new Pokemon(20, "Charmander", 80, 60, 90, 25, 60, 10, 15, 5);

        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(pikachu);
        pokemons.add(charmander);

        // Trier les Pokémon par nom
        Collections.sort(pokemons, PokemonComparators.NAME);

        // Vérifier que le premier Pokémon est Charmander et le deuxième est Pikachu
        assertEquals("Charmander", pokemons.get(0).getName());
        assertEquals("Pikachu", pokemons.get(1).getName());
    }

    @Test
    public void testComparatorByIndex() {
        // Créer des Pokémon pour les tests
        Pokemon pikachu = new Pokemon(25, "Pikachu", 70, 60, 80, 10, 50, 20, 10, 5);
        Pokemon charmander = new Pokemon(4, "Charmander", 80, 60, 90, 25, 60, 10, 15, 5);

        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(pikachu);
        pokemons.add(charmander);

        // Trier les Pokémon par index
        Collections.sort(pokemons, PokemonComparators.INDEX);

        // Vérifier que le premier Pokémon a l'index 4 et le deuxième a l'index 25
        assertEquals(4, pokemons.get(0).getIndex());
        assertEquals(25, pokemons.get(1).getIndex());
    }

    @Test
    public void testComparatorByCP() {
        // Créer des mocks pour les Pokémon
        Pokemon pikachu = new Pokemon(20, "Pikachu", 70, 60, 80, 300, 50, 20, 10, 5);
        Pokemon charmander = new Pokemon(20, "Charmander", 80, 60, 90, 500, 60, 10, 15, 5);

        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(pikachu);
        pokemons.add(charmander);

        // Trier les Pokémon par point de combat
        Collections.sort(pokemons, PokemonComparators.CP);

        // Vérifier que le premier Pokémon a 300 CP et le deuxième a 500 CP
        assertEquals(300, pokemons.get(0).getCp());
        assertEquals(500, pokemons.get(1).getCp());
    }
}
