package com.codingame.ai;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static com.codingame.ai.Player.*;
import static com.codingame.ai.TestUtil.*;
import static org.junit.Assert.*;

@SuppressWarnings("unchecked")
public class PlayerTest extends AbstractGameTest {

    @Before
    public void setUp() throws Exception {
        setUpHeroes();
    }

    @After
    public void tearDown() {
        tearDownHeroes();
    }

    @Test
    public void createHeroes_shouldInitialMeAndEnemy() throws Exception {
        assertMeObject();
        assertEnemyObject();
    }

    @Test
    public void enemyActions_shouldDefineEnemyActionsForLastTurn() throws Exception {
        in.addToGameInput(14);
        in.addToGameInput(3);
        in.addToGameInput("1 SUMMON");
        in.addToGameInput("2 USE");
        in.addToGameInput("3 ATTACK");

        enemyActions();
        assertEquals(14, enemy.hand);
        assertEquals(3, enemy.actionCount);
        assertEquals(Arrays.asList("1 SUMMON", "2 USE", "3 ATTACK"), enemy.actions);
    }

    @Test
    public void createThreeCardsInDraftPhase() throws Exception {
        addCardsDetailToGameInput(3, 0);
        Player.createCards();
        assertEquals(3, me.handCards.size());
    }

    @Test
    public void createSevenCardsInMeHandCards() throws Exception {
        addCardsDetailToGameInput(7, 0);
        Player.createCards();
        assertEquals(7, me.handCards.size());
    }

    @Test
    public void createThreeCardsInMeBoard() throws Exception {
        addCardsDetailToGameInput(3, 1);
        Player.createCards();
        assertEquals(3, me.boardCards.size());
    }

    @Test
    public void createFiveCardsInEnemyBoard() throws Exception {
        addCardsDetailToGameInput(5, -1);
        Player.createCards();
        assertEquals(5, enemy.boardCards.size());
    }

    private void addCardsDetailToGameInput(int cardCount, int location) {
        in.addAllToGameInput(createCardDetails(cardCount, location));
    }

    private void assertMeObject() {
        assertEquals(ME_HEALTH, me.health);
        assertEquals(ME_MANA, me.mana);
        assertEquals(ME_RUNE_COUNT, me.rune);
        assertEquals(ME_DECK_COUNT, me.deck);
        assertEquals(ME_DRAW_COUNT, me.draw);
    }

    private void assertEnemyObject() {
        assertEquals(ENEMY_HEALTH, enemy.health);
        assertEquals(ENEMY_MANA, enemy.mana);
        assertEquals(ENEMY_DECK_COUNT, enemy.deck);
        assertEquals(ENEMY_RUNE_COUNT, enemy.rune);
        assertEquals(ENEMY_DRAW_COUNT, enemy.draw);
    }
}