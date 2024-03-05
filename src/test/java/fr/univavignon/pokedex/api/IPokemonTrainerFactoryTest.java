package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory trainerFactory;
    private IPokedexFactory pokedexFactoryMock;

    @Before
    public void setUp() {
        // Create a mock for IPokedexFactory
        pokedexFactoryMock = mock(IPokedexFactory.class);

        // Create an instance of the actual PokemonTrainerFactory class to be tested
        // trainerFactory = new PokemonTrainerFactory();
    }

    @Test
    public void testCreateTrainer() {
        // Arrange
        String trainerName = "Ash Ketchum";
        Team trainerTeam = Team.MYSTIC;

        // Mock behavior for the pokedexFactoryMock
        IPokemonMetadataProvider metadataProviderMock = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactoryMock = mock(IPokemonFactory.class);

        // Create a mockPokedex instance
        IPokedex mockPokedex = mock(IPokedex.class);

        // Set up the mockPokedex creation in the pokedexFactoryMock
        when(pokedexFactoryMock.createPokedex(metadataProviderMock, pokemonFactoryMock)).thenReturn(mockPokedex);

        // Act
        PokemonTrainer createdTrainer = trainerFactory.createTrainer(trainerName, trainerTeam, pokedexFactoryMock);

        // Assert
        assertEquals(trainerName, createdTrainer.getName());
        assertEquals(trainerTeam, createdTrainer.getTeam());
        assertEquals(mockPokedex, createdTrainer.getPokedex());
    }


}
