package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Test;

public class PokedexFactoryTest {

        @Test
        public void testCreatePokedex() {
            // Création de mocks pour les dépendances
            IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);
            IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);

            // Création de l'instance de PokedexFactory à tester
            PokedexFactory pokedexFactory = new PokedexFactory();

            // Appel de la méthode createPokedex de PokedexFactory
            IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

            // Vérification que l'objet retourné n'est pas null
            assertNotNull(pokedex);
        }
}

