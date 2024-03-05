package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import jdk.jfr.internal.MirrorEvent;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class IPokemonTrainerFactoryTest {

    @Mock
    private IPokemonTrainerFactory trainerFactory;

    @Mock
    private IPokedexFactory pokedexFactory;

    @Mock
    private IPokedex mockPokedex;

    @Before
    public void setUp() {
        // Créez un mock pour IPokedexFactory
        pokedexFactory = mock(IPokedexFactory.class);

        // Initialisez l'instance de la classe PokemonTrainerFactory à tester
        trainerFactory = mock(IPokemonTrainerFactory.class);

        mockPokedex = mock(IPokedex.class);
    }

    @Test
    public void testCreateTrainer() {
        // Arrange
        String trainerName = "Ash Ketchum";
        Team trainerTeam = Team.MYSTIC;

        // Comportement simulé pour le mock pokedexFactoryMock
        IPokemonMetadataProvider metadataProviderMock = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactoryMock = mock(IPokemonFactory.class);

        // Configurez la création du mockPokedex dans pokedexFactoryMock
        when(pokedexFactory.createPokedex(metadataProviderMock, pokemonFactoryMock)).thenReturn(mockPokedex);

        // WHEN DE Create TrainerFactory
        PokemonTrainer mockTrainer = new PokemonTrainer(trainerName, trainerTeam, mockPokedex);
        when(trainerFactory.createTrainer(trainerName, trainerTeam, pokedexFactory)).thenReturn(mockTrainer);

        // Agissez
        PokemonTrainer createdTrainer = trainerFactory.createTrainer(trainerName, trainerTeam, pokedexFactory);

        // Vérifiez
        assertEquals(trainerName, createdTrainer.getName());
        assertEquals(trainerTeam, createdTrainer.getTeam());
        assertEquals(mockPokedex, createdTrainer.getPokedex());
    }
}
