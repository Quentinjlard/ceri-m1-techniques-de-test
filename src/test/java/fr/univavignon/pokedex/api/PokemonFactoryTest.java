package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Test;


public class PokemonFactoryTest {

    @Test
    public void testCreatePokemon() {
        PokemonFactory pokemonFactory = new PokemonFactory();

        int index = 25; // Pikachu's index
        int cp = 613;
        int hp = 64;
        int dust = 200;
        int candy = 1;

        Pokemon pikachu = pokemonFactory.createPokemon(index, cp, hp, dust, candy);

        // Vérification des valeurs initiales de Pikachu
        assertEquals(index, pikachu.getIndex());
        assertEquals("Pikachu", pikachu.getName());
        assertEquals(70, pikachu.getAttack());
        assertEquals(60, pikachu.getDefense());
        assertEquals(80, pikachu.getStamina());
        assertEquals(cp, pikachu.getCp());
        assertEquals(hp, pikachu.getHp());
        assertEquals(dust, pikachu.getDust());
        assertEquals(candy, pikachu.getCandy());
        assertEquals(0.85, pikachu.getIv(), 0.001);
    }
}
