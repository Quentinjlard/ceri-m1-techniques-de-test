package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class IPokemonTrainerFactoryTest {

    @Mock
    IPokemonTrainerFactory trainerFactory;
    @Mock
    IPokedexFactory pokedexFactoryMock;

    @Before
    public void setUp() {
        // Créez un mock pour IPokedexFactory
        pokedexFactoryMock = mock(IPokedexFactory.class);

        // Initialisez l'instance de la classe PokemonTrainerFactory à tester
        //trainerFactory = new PokemonTrainerFactory();
    }

    @Test
    public void testCreateTrainer() {
        // Arrange
        String trainerName = "Ash Ketchum";
        Team trainerTeam = Team.MYSTIC;

        // Comportement simulé pour le mock pokedexFactoryMock
        IPokemonMetadataProvider metadataProviderMock = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactoryMock = mock(IPokemonFactory.class);

        // Créez une instance mockPokedex
        IPokedex mockPokedex = mock(IPokedex.class);

        // Configurez la création du mockPokedex dans pokedexFactoryMock
        when(pokedexFactoryMock.createPokedex(metadataProviderMock, pokemonFactoryMock)).thenReturn(mockPokedex);

        // Agissez
        PokemonTrainer createdTrainer = trainerFactory.createTrainer(trainerName, trainerTeam, pokedexFactoryMock);

        // Vérifiez
        assertEquals(trainerName, createdTrainer.getName());
        assertEquals(trainerTeam, createdTrainer.getTeam());
        assertEquals(mockPokedex, createdTrainer.getPokedex());
    }
}
