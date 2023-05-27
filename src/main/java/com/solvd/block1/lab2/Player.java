package com.solvd.block1.lab2;

/*
 * This is the Player abstract class which extends from the Person class. It contains variables for number and position
 * as well as getter and setter methods for them. There is also an abstract method performAction() which should be
 * overridden in a derived class.
 */

import com.solvd.block1.lab2.interfaces.Celebratable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Player extends Person implements Celebratable {

    // Logger
    private static final Logger LOGGER = LogManager.getLogger(Player.class);

    // Attributes and variables
    private int number;
    private String team;

    // Constructor
    Player(String name, int age, int number, String team) {
        super(name, age);
        this.number = number;
        this.team = team;

    }

    // Getters and Setters
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    // Abstract method to be overridden in subclass
    abstract void performAction();

    @Override
    public void celebrate() {
        LOGGER.info(getName() + " is celebrating!");
    }

    public String getPosition() {
        return null;
    }
}