package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class IPokemonFactoryTest {

    @Mock
    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        // Initialisation des mocks
        pokemonFactory = mock(IPokemonFactory.class);
    }

    @Test
    public void testCreatePokemon() {
        int index = 0;
        int cp = 500;
        int hp = 100;
        int dust = 3000;
        int candy = 3;
        double iv = 0.85; // Nouveau paramètre IV

        // Création d'un Pokémon simulé avec les attributs donnés
        Pokemon simulatedPokemon = new Pokemon(index, "Pikachu", 70, 60, 80, cp, hp, dust, candy, iv);

        // Configuration du comportement du mock
        when(pokemonFactory.createPokemon(index, cp, hp, dust, candy, iv))
                .thenReturn(simulatedPokemon);

        // Appel de la méthode à tester
        Pokemon createdPokemon = pokemonFactory.createPokemon(index, cp, hp, dust, candy, iv);

        // Vérification des attributs du Pokémon créé
        assertNotNull(createdPokemon);
        assertEquals(index, createdPokemon.getIndex());
        assertEquals(cp, createdPokemon.getCp());
        assertEquals(hp, createdPokemon.getHp());
        assertEquals(dust, createdPokemon.getDust());
        assertEquals(candy, createdPokemon.getCandy());
        assertEquals(iv, createdPokemon.getIv(), 0.001); // Vérification de l'IV avec une tolérance de 0.001

        // Vérification que la méthode du mock a été appelée
        verify(pokemonFactory, times(1)).createPokemon(index, cp, hp, dust, candy, iv);
    }
}
