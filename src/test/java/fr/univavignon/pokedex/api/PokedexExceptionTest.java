package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class PokedexExceptionTest {

    @Test
    public void testPokedexExceptionMessage() {
        // Mock du message d'erreur
        String errorMessage = "Erreur dans le Pokédex";

        // Création de l'exception avec le mock du message
        PokedexException pokedexException = new PokedexException(errorMessage);

        // Vérification que le message de l'exception est correct
        assertEquals(errorMessage, pokedexException.getMessage());
    }

    @Test
    public void testPokedexExceptionThrow() throws PokedexException {
        // Création d'un mock d'une opération qui lève une PokedexException
        SomeClassWithPokedexOperation mockClass = mock(SomeClassWithPokedexOperation.class);

        // Définir le comportement du mock pour lancer l'exception
        when(mockClass.doSomethingThatThrowsPokedexException()).thenThrow(new PokedexException("Une erreur s'est produite dans le Pokédex."));

        // Appel de la méthode de la classe qui lève l'exception
        try {
            mockClass.doSomethingThatThrowsPokedexException();
            // Si l'exception n'est pas levée, le test échoue
            fail("Une PokedexException aurait dû être levée");
        } catch (PokedexException e) {
            // Si une PokedexException est levée, le test réussit
            assertEquals("Une erreur s'est produite dans le Pokédex.", e.getMessage());
        }
    }

    // Classe fictive utilisée pour les exemples
    // Classe fictive utilisée pour les exemples
    static class SomeClassWithPokedexOperation {
        int doSomethingThatThrowsPokedexException() throws PokedexException {
            throw new PokedexException("Une erreur s'est produite dans le Pokédex.");
        }
    }
}
