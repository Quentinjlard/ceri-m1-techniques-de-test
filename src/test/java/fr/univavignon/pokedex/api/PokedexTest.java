package fr.univavignon.pokedex.api;


import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;



public class PokedexTest {

    private Pokedex pokedex;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        metadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);
        pokedex = new Pokedex(metadataProvider, pokemonFactory);
    }

    @Test
    public void testSize() {
        assertEquals(0, pokedex.size());
    }

    @Test
    public void testAddPokemon() {
        Pokemon pokemon = new Pokemon(1, "Bulbasaur", 118, 118, 90, 613, 64, 200, 1, 90.0);
        assertEquals(0, pokedex.addPokemon(pokemon));
        assertEquals(1, pokedex.size());
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        Pokemon pokemon = new Pokemon(1, "Bulbasaur", 118, 118, 90, 613, 64, 200, 1, 90.0);
        pokedex.addPokemon(pokemon);
        assertEquals(pokemon, pokedex.getPokemon(0));
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonWithInvalidIndex() throws PokedexException {
        pokedex.getPokemon(10);
    }

    @Test
    public void testGetPokemons() {
        Pokemon pokemon1 = new Pokemon(1, "Bulbasaur", 118, 118, 90, 613, 64, 200, 1, 90.0);
        Pokemon pokemon2 = new Pokemon(4, "Charmander", 116, 96, 78, 581, 60, 200, 1, 80.0);
        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);

        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(2, pokemons.size());
        assertTrue(pokemons.contains(pokemon1));
        assertTrue(pokemons.contains(pokemon2));
    }

    @Test
    public void testGetPokemonsWithComparator() {
        Pokemon pokemon1 = new Pokemon(1, "Bulbasaur", 118, 118, 90, 613, 64, 200, 1, 90.0);
        Pokemon pokemon2 = new Pokemon(4, "Charmander", 116, 96, 78, 581, 60, 200, 1, 80.0);
        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);

        Comparator<Pokemon> cpComparator = Comparator.comparingInt(Pokemon::getCp);
        List<Pokemon> pokemons = pokedex.getPokemons(cpComparator);
        assertEquals(2, pokemons.size());
        assertEquals(pokemon2, pokemons.get(0)); // Charmander has lower CP than Bulbasaur
        assertEquals(pokemon1, pokemons.get(1));
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata pokemonMetadata = new PokemonMetadata(1, "Bulbasaur", 118, 118, 90);
        when(metadataProvider.getPokemonMetadata(1)).thenReturn(pokemonMetadata);

        assertEquals(pokemonMetadata, pokedex.getPokemonMetadata(1));
    }

    @Test
    public void testCreatePokemon() {
        Pokemon pokemon = new Pokemon(1, "Bulbasaur", 118, 118, 90, 613, 64, 200, 1, 90.0);
        when(pokemonFactory.createPokemon(1, 613, 64, 200, 1)).thenReturn(pokemon);

        assertEquals(pokemon, pokedex.createPokemon(1, 613, 64, 200, 1));
    }
}
