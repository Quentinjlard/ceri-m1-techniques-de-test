package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class RocketPokemonFactoryTest {

    private RocketPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        pokemonFactory = new RocketPokemonFactory();
    }

    @Test
    public void testCreatePokemon() {
        int index = 1; // Test with existing index
        int cp = 500;
        int hp = 100;
        int dust = 3000;
        int candy = 3;

        // Appel de la méthode à tester
        Pokemon createdPokemon = pokemonFactory.createPokemon(index, cp, hp, dust, candy);

        // Vérification des attributs du Pokémon créé
        assertNotNull(createdPokemon);
        assertEquals(index, createdPokemon.getIndex());
        assertEquals(cp, createdPokemon.getCp());
        assertEquals(hp, createdPokemon.getHp());
        assertEquals(dust, createdPokemon.getDust());
        assertEquals(candy, createdPokemon.getCandy());

        // Vérification que la méthode a renvoyé le bon nom de Pokémon pour l'index donné
        assertEquals("Bulbasaur", createdPokemon.getName());

        // Vérification que la méthode n'est pas appelée avec un index inconnu
        int unknownIndex = -1; // Change to -1 to reflect the behavior in RocketPokemonFactory
        Pokemon unknownPokemon = pokemonFactory.createPokemon(unknownIndex, cp, hp, dust, candy);
        assertNotNull(unknownPokemon);
        assertEquals(unknownIndex, unknownPokemon.getIndex()); // Expecting the default index for unknown Pokemon
        assertEquals("Ash's Pikachu", unknownPokemon.getName()); // Expecting the default name for unknown Pokemon
    }

}
