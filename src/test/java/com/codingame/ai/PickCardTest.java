package com.codingame.ai;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static com.codingame.ai.Player.me;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("unchecked")
public class PickCardTest extends AbstractGameTest {
    private CardGameInputBuilder cardBuilder;

    @Before
    public void setUp() throws Exception {
        setUpHeroes();
        cardBuilder = new CardGameInputBuilder();
    }

    @After
    public void tearDown() throws Exception {
        tearDownHeroes();
    }

    @Test
    public void pickTankCard() throws Exception {
        Queue cardDetails = createCardsFor_pickTankCard();
        in.addAllToGameInput(cardDetails);
        Player.createCards();
        int picked = me.pickCard();
        assertEquals(1, picked);
    }

    private Queue createCardsFor_pickTankCard() {
        Queue cardDetails = new LinkedList();
        cardDetails.add(3);
        cardDetails.addAll(
                cardBuilder.abilities("----W")
                .build()
        );
        cardDetails.addAll(
                cardBuilder.abilities("--G--")
                        .build()
        );
        cardDetails.addAll(
                cardBuilder.abilities("-C---")
                .build()
        );
        return cardDetails;
    }

    @Test
    public void fromTwoTankPickWardedTank() throws Exception {
        Queue cardDetails = createCardsFor_fromTwoTankPickWardedTank();
        in.addAllToGameInput(cardDetails);
        Player.createCards();
        int picked = me.pickCard();
        assertEquals(2, picked);
    }

    private Queue createCardsFor_fromTwoTankPickWardedTank() {
        Queue cardDetails = new LinkedList();
        cardDetails.add(3);
        cardDetails.addAll(
                cardBuilder.abilities("----W")
                        .build()
        );
        cardDetails.addAll(
                cardBuilder.abilities("--G--")
                        .build()
        );
        cardDetails.addAll(
                cardBuilder.abilities("-WG--")
                        .build()
        );
        return cardDetails;
    }
}
