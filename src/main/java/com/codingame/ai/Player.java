package com.codingame.ai;

import java.util.*;

@SuppressWarnings("unused")
class Player {

    interface GameInput {
        int nextInt();

        String nextLine();

        String next();

        boolean hasNextLine();
    }

    static class GameInputImpl implements GameInput {
        private Scanner in = new Scanner(System.in);

        @Override
        public int nextInt() {
            return in.nextInt();
        }

        @Override
        public String nextLine() {
            return in.nextLine();
        }

        @Override
        public String next() {
            return in.next();
        }

        @Override
        public boolean hasNextLine() {
            return in.hasNext();
        }
    }

    private static GameInput in;

    /**
     * need this for mock scanner in test
     */
    public static void setGameInput(GameInput input) {
        in = input;
    }

    static Me me;
    static Enemy enemy;
    static int turn = 1;
    final static int BATTLE_PHASE_START = 31;

    public static void main(String args[]) {
        in = new GameInputImpl();

        // game loop
        while (true) {
            createHeroes();
            enemyActions();
            createCards();

            System.out.println("PASS");
            turn++;
        }
    }

    static void createHeroes() {
        me = new Me();
        enemy = new Enemy();
    }

    static void enemyActions() {
        enemy.hand = in.nextInt();
        enemy.actionCount = in.nextInt();
        if (in.hasNextLine())
            in.nextLine();

        for (int i = 0; i < enemy.actionCount; i++)
            enemy.addAction(in.nextLine());
    }

    static void createCards() {
        int cardCount = in.nextInt();
        for (int i = 0; i < cardCount; i++) {
           Card c = new Card();
           switch (c.location) {
               case 0:
                   me.addToHand(c);
                   break;
               case 1:
                   me.addToBoard(c);
                   break;
               case -1:
                   enemy.addToBoard(c);
                   break;
           }
        }
    }


    /**
     *
     *       helper classes
     *
     */


    static abstract class Hero {
        int health;
        int mana;
        int deck;
        int rune;
        int draw;
        List<Card> boardCards;

        Hero() {
            health = in.nextInt();
            mana = in.nextInt();
            deck = in.nextInt();
            rune = in.nextInt();
            draw = in.nextInt();
            boardCards = new ArrayList<>();
        }

        void addToBoard(Card c) {
            boardCards.add(c);
        }
    }

    static class Me extends Hero {
        List<Card> handCards;

        Me() {
            handCards = new ArrayList<>();
        }

        void addToHand(Card c) {
            handCards.add(c);
        }

        /**
         * @return the index of picked card in draft phase
         */
        int pickCard() {
            int picked = 0;
            Card pickedCard = handCards.get(0);
            for (int i = 1; i < handCards.size(); i++) {
                Card c = handCards.get(i);
                if (c.isBetter(pickedCard)) {
                    picked = i;
                    pickedCard = c;
                }
            }
            return picked;
        }
    }

    static class Enemy extends Hero {
        int hand;
        int actionCount;
        List<String> actions;

        Enemy() {
            actions = new ArrayList<>();
        }

        void addAction(String act) {
            actions.add(act);
        }
    }

    static class Card {
        int number;
        int id;
        int location;
        int type;
        int cost;
        int attack;
        int defense;
        String abilities;
        int myHealthChange;
        int enemyHealthChange;
        int draw;

        Card() {
            number = in.nextInt();
            id = in.nextInt();
            location = in.nextInt();
            type = in.nextInt();
            cost = in.nextInt();
            attack = in.nextInt();
            defense = in.nextInt();
            abilities = in.next();
            myHealthChange = in.nextInt();
            enemyHealthChange = in.nextInt();
            draw = in.nextInt();
        }

        boolean isBetter(Card another) {
            return isBetterByAbilities(another);
        }

        private boolean isBetterByAttackAndHealth(Card another) {
            return true;
        }

        private boolean isBetterByAbilities(Card another) {
            if (isTank()) {
                if (!another.isTank())
                    return true;

                if (isWarded()) {
                    if (!another.isWarded())
                        return true;
                }
            }
            return false;
        }

        boolean isTank() {
            return abilities.contains("G");
        }

        boolean isWarded() {
            return abilities.contains("W");
        }
    }
}
