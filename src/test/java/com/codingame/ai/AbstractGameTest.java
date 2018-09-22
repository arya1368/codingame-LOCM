package com.codingame.ai;

import java.util.LinkedList;
import java.util.Queue;

import static com.codingame.ai.Player.*;
import static com.codingame.ai.TestUtil.getHeroesDetails;
import static org.junit.Assert.assertNotNull;

@SuppressWarnings("unchecked")
public class AbstractGameTest {
    protected MockGameInput in;

    protected void setUpHeroes() {
        in = new MockGameInput();
        setGameInput(in);
        in.addAllToGameInput(getHeroesDetails());
        createHeroes();
        assertNotNull(me);
        assertNotNull(enemy);
    }

    protected void tearDownHeroes() {
        me = null;
        enemy = null;
    }
}
