package com.solvd.block1.lab2;

/*
 * This class is used to create a Striker object which is a type of Player.
 * It has a constructor which takes the name, age, and number of the Player as parameters.
 * The performAction method is overridden to print "Scoring a goal..." when called.
 */

import com.solvd.block1.lab2.interfaces.Runnable;
import com.solvd.block1.lab2.interfaces.Substituable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

class Striker extends Player implements Runnable, Substituable {

    // Logger
    private static final Logger LOGGER = LogManager.getLogger(Striker.class);

    private static final double STRIKER_ABILITY = 0.4;

    public Striker(String name, int age, int number, String team) {
        super(name, age, number, team);
    }


    @Override
    public void performAction() {
        // Simulate the striker's goal-scoring ability
        Random random = new Random();
        if (random.nextDouble() < STRIKER_ABILITY) {
            LOGGER.info(getName() + " scored a goal!");
            celebrate();
            if (this.getTeam().equals("Home Team")) { // Check if the striker belongs to the home team
                Match.getScore().homeScored(); // The home team scores if the striker belongs to the home team

            } else {
                Match.getScore().awayScored(); // The away team scores if the striker belongs to the away team
            }
        } else {
            LOGGER.info(getName() + " missed.");
        }
    }

    @Override
    public void run() {
        LOGGER.info(getName() + " is running.");
    }

    // Substitution method
    @Override
    public void substitute() {
        LOGGER.info(getName() + " is going off the field and being replaced by a substitute.");
    }

    @Override
    public String getPosition() {

        return "Striker";
    }
}

