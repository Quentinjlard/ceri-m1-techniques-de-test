package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PokemonTrainerFactoryTest {

    private PokemonTrainerFactory pokemonTrainerFactory;
    private PokedexFactory pokedexFactory;

    @BeforeEach
    public void setUp() {
        pokemonTrainerFactory = new PokemonTrainerFactory();
        pokedexFactory = new PokedexFactory();
    }

    @Test
    public void testCreateTrainer() throws PokedexException {
        // Créer un entraîneur avec l'équipe Team.VALOR
        PokemonTrainer trainer1 = pokemonTrainerFactory.createTrainer("Ash", Team.VALOR, pokedexFactory);
        assertEquals("Ash", trainer1.getName());
        assertEquals(Team.VALOR, trainer1.getTeam());
        assertEquals(0, trainer1.getPokedex().size());

        // Créer un entraîneur avec l'équipe Team.MYSTIC
        PokemonTrainer trainer2 = pokemonTrainerFactory.createTrainer("Misty", Team.MYSTIC, pokedexFactory);
        assertEquals("Misty", trainer2.getName());
        assertEquals(Team.MYSTIC, trainer2.getTeam());
        assertEquals(0, trainer2.getPokedex().size());

        // Vérifier que deux entraîneurs différents sont créés
        assertNotSame(trainer1, trainer2);
    }
}
