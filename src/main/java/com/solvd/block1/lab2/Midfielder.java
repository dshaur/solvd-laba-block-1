package com.solvd.block1.lab2;

/*
 * This class is a Subclass of Player and represents a Midfielder. It has a constructor that calls the super constructor
 *  with the type set to "Midfielder". It also overrides the performAction method to print out "Making a pass...".
 */

import com.solvd.block1.lab2.interfaces.Runnable;
import com.solvd.block1.lab2.interfaces.Substituable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Midfielder extends Player implements Runnable, Substituable {

    // Logger
    private static final Logger LOGGER = LogManager.getLogger(Midfielder.class);

    // Constructor
    public Midfielder(String name, int age, int number, String teamName) {
        super(name, age, number, teamName);
    }

    @Override
    public void performAction() {
        // Simulate the midfielders' ability to pass the ball
        LOGGER.info(getName() + " is passing the ball.");
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

        return "Midfielder";
    }

}

