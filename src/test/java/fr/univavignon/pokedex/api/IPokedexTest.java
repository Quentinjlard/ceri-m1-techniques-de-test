package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class IPokedexTest {

    private IPokedex pokedex;

    @Before
    public void setUp() {
        // Créer un mock pour l'interface IPokedex
        pokedex = mock(IPokedex.class);

        // Configurer le comportement du mock pour la méthode getPokemons
        // On suppose que la méthode getPokemons fonctionne correctement
        List<Pokemon> mockPokemons = new ArrayList<>();
        mockPokemons.add(new Pokemon(1, "Bulbasaur", 45, 49,
                                   49, 500, 50, 200, 10, 0.8));
        mockPokemons.add(new Pokemon(2, "Ivysaur", 60, 62,
                                    63, 800, 80, 400, 20, 0.7));
        mockPokemons.add(new Pokemon(3, "Venusaur", 80, 82, 83,
                                    1200, 120, 800, 40, 0.9));

        when(pokedex.getPokemons()).thenReturn(mockPokemons);
    }

    @Test
    public void testGetPokemonsSorted() {
        // Créer un comparateur pour trier les pokemons par leur nom en ordre croissant
        Comparator<Pokemon> nameComparator = Comparator.comparing(Pokemon::getName);

        // Appeler la méthode getPokemons avec le comparateur
        List<Pokemon> sortedPokemons = pokedex.getPokemons(nameComparator);

        // Vérifier que la liste est triée correctement
        assertEquals("Bulbasaur", sortedPokemons.get(0).getName());
        assertEquals("Ivysaur", sortedPokemons.get(1).getName());
        assertEquals("Venusaur", sortedPokemons.get(2).getName());
    }
}
