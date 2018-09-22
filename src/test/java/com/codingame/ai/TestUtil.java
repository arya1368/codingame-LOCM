package com.codingame.ai;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unchecked")
public class TestUtil {
    public static final int ME_HEALTH = 30;
    public static final int ME_MANA = 3;
    public static final int ME_DECK_COUNT = 12;
    public static final int ME_RUNE_COUNT = 5;
    public static final int ME_DRAW_COUNT = 0;
    public static final Object[] ME_DETAILS = {ME_HEALTH, ME_MANA, ME_DECK_COUNT, ME_RUNE_COUNT, ME_DRAW_COUNT};

    public static final int ENEMY_HEALTH = 25;
    public static final int ENEMY_MANA = 5;
    public static final int ENEMY_DECK_COUNT = 14;
    public static final int ENEMY_RUNE_COUNT = 4;
    public static final int ENEMY_DRAW_COUNT = 2;
    public static final Object[] ENEMY_DETAILS = new Object[]{ENEMY_HEALTH, ENEMY_MANA, ENEMY_DECK_COUNT, ENEMY_RUNE_COUNT, ENEMY_DRAW_COUNT};

    public static Queue getHeroesDetails() {
        Queue heroes = new LinkedList();
        heroes.addAll(convert(ME_DETAILS));
        heroes.addAll(convert(ENEMY_DETAILS));
        return heroes;
    }

    public static Queue createCardDetails(int cardCount, int location) {
        Queue card = new CardGameInputBuilder()
                .location(location)
                .build();

        Queue cardDetails = new LinkedList();
        cardDetails.add(cardCount);
        for (int i = 0; i < cardCount; i++)
            cardDetails.addAll(card);

        return cardDetails;
    }

    public static Queue convert(Object[] objs) {
        Queue q = new LinkedList();
        Collections.addAll(q, objs);
        return q;
    }
}
