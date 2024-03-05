package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider metadataProvider;
    private PokemonMetadata expectedMetadata;

    @Before
    public void setUp() {
        metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        expectedMetadata = new PokemonMetadata(1, "Bulbasaur", 49, 49, 45);

        try {
            Mockito.when(metadataProvider.getPokemonMetadata(1)).thenReturn(expectedMetadata);
        } catch (PokedexException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getPokemonMetadataTest() throws PokedexException {
        PokemonMetadata actualMetadata = metadataProvider.getPokemonMetadata(1);

        assertEquals(expectedMetadata.getIndex(), actualMetadata.getIndex());
        assertEquals(expectedMetadata.getName(), actualMetadata.getName());
        assertEquals(expectedMetadata.getAttack(), actualMetadata.getAttack());
        assertEquals(expectedMetadata.getDefense(), actualMetadata.getDefense());
        assertEquals(expectedMetadata.getStamina(), actualMetadata.getStamina());
    }
}
