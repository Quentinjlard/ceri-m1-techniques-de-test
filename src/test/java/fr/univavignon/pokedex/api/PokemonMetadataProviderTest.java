package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Test;


public class PokemonMetadataProviderTest {

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();

        // Test avec un index valide
        PokemonMetadata bulbasaurMetadata = metadataProvider.getPokemonMetadata(0);
        assertEquals(126, bulbasaurMetadata.getIndex());
        assertEquals("Bulbasaur", bulbasaurMetadata.getName());
        assertEquals(126, bulbasaurMetadata.getAttack());
        assertEquals(90, bulbasaurMetadata.getDefense());
        assertEquals(60, bulbasaurMetadata.getStamina());

        // Test avec un autre index valide
        PokemonMetadata ivysaurMetadata = metadataProvider.getPokemonMetadata(1);
        assertEquals(156, ivysaurMetadata.getIndex());
        assertEquals("Ivysaur", ivysaurMetadata.getName());
        assertEquals(158, ivysaurMetadata.getAttack());
        assertEquals(120, ivysaurMetadata.getDefense());
        assertEquals(80, ivysaurMetadata.getStamina());
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadataWithInvalidIndex() throws PokedexException {
        PokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        metadataProvider.getPokemonMetadata(10); // Index invalide, doit lancer une exception PokedexException
    }
}