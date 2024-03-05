package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


public class IPokedexFactoryTest {

    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;
    private IPokedexFactory pokedexFactory;
    private IPokedex pokedex;
    @Before
    public void setUp(){

        IPokemonMetadataProvider metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);

        IPokedexFactory pokedexFactory = Mockito.mock(IPokedexFactory.class);

        IPokedex pokedex = Mockito.mock(IPokedex.class);

    }

    @Test
    public void testIPokedexFactoryTest(){

        assertNotNull(pokedex);
        assertNotNull(pokedexFactory);
        assertNotNull(pokemonFactory);
        assertNotNull(metadataProvider);

        assertNotNull(pokedexFactory.createPokedex(metadataProvider, pokemonFactory));

    }


}
