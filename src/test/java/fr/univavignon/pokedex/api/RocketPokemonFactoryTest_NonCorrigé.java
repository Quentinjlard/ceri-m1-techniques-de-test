package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RocketPokemonFactoryTest_NonCorrigé {

    private RocketPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        pokemonFactory = new RocketPokemonFactory();
    }

    @Test
    public void testCreatePokemon() {

        int index = 0;
        int cp = 613;
        int hp = 64;
        int dust = 200;
        int candy = 1;

        Pokemon missingno = pokemonFactory.createPokemon(index, cp, hp, dust, candy);

        // Vérification des valeurs initiales de Missingno
        assertEquals(index, missingno.getIndex());
        assertEquals("MISSINGNO", missingno.getName());
        assertEquals(70, missingno.getAttack());
        assertEquals(60, missingno.getDefense());
        assertEquals(80, missingno.getStamina());
        assertEquals(cp,missingno.getCp());
        assertEquals(hp, missingno.getHp());
        assertEquals(dust, missingno.getDust());
        assertEquals(candy, missingno.getCandy());
        assertEquals(0.85, missingno.getIv(), 0.001);
    }

}
