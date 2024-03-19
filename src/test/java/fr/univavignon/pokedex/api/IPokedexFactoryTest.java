package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;


public class IPokedexFactoryTest {

    @Mock
    private IPokemonMetadataProvider metadataProvider;
    @Mock
    private IPokemonFactory pokemonFactory;
    @Mock
    private IPokedexFactory pokedexFactory;
    @Mock
    private IPokedex pokedex;


    @Test
    public void testIPokedexFactory() {
        IPokemonMetadataProvider metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);
        IPokedexFactory pokedexFactory = Mockito.mock(IPokedexFactory.class);

        IPokedex expectedPokedex = pokedex;

        Mockito.when(pokedexFactory.createPokedex(metadataProvider,pokemonFactory)).thenReturn(expectedPokedex);

        // Assuming createPokedex method is part of the IPokedexFactory interface
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        assertEquals(expectedPokedex, pokedex);
    }


}
