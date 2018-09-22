package com.codingame.ai;

import java.util.Queue;

import static com.codingame.ai.TestUtil.convert;

@SuppressWarnings("unused")
public class CardGameInputBuilder {

    private int number;
    private int id;
    private int location;
    private int type;
    private int cost;
    private int attack;
    private int defense;
    private String abilities;
    private int myHealthChange;
    private int enemyHealthChange;
    private int draw;

    public Queue build() {
        return convert(new Object[]{number, id, location, type, cost, attack, defense, abilities,
                myHealthChange, enemyHealthChange, draw});
    }

    public CardGameInputBuilder id(int id) {
        this.id = id;
        return this;
    }

    public CardGameInputBuilder number(int number) {
        this.number = number;
        return this;
    }

    public CardGameInputBuilder location(int location) {
        this.location = location;
        return this;
    }

    public CardGameInputBuilder type(int type) {
        this.type = type;
        return this;
    }

    public CardGameInputBuilder cost(int cost) {
        this.cost = cost;
        return this;
    }

    public CardGameInputBuilder attack(int attack) {
        this.attack = attack;
        return this;
    }

    public CardGameInputBuilder defense(int defense) {
        this.defense = defense;
        return this;
    }

    public CardGameInputBuilder abilities(String abilities) {
        this.abilities = abilities;
        return this;
    }

    public CardGameInputBuilder myHealthChange(int myHealthChange) {
        this.myHealthChange = myHealthChange;
        return this;
    }

    public CardGameInputBuilder enemyHealthChange(int enemyHealthChange) {
        this.enemyHealthChange = enemyHealthChange;
        return this;
    }

    public CardGameInputBuilder draw(int draw) {
        this.draw = draw;
        return this;
    }
}
