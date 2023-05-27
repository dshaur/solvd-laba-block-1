package com.solvd.block1.lab2;

import com.solvd.block1.lab2.interfaces.Runnable;
import com.solvd.block1.lab2.interfaces.Substituable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

/*
 * This class represents a Goalkeeper Player. It extends the Player class and
 * overrides the performAction() method to print a statement specific to the Goalkeeper.
 */
class Goalkeeper extends Player implements Runnable, Substituable {


    // Logger
    private static final Logger LOGGER = LogManager.getLogger(Goalkeeper.class);

    // Constructor
    public Goalkeeper(String name, int age, int number, String teamName) {
        super(name, age, number, teamName);
    }

    @Override
    public void performAction() {
        // Simulate the goalkeeper's ability to save a goal
        Random random = new Random();
        if (random.nextDouble() < 0.3) {
            LOGGER.info(getName() + " made a great save!");
        } else {
            LOGGER.info(getName() + " performed a goal kick.");
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

        return "Goalkeeper";
    }
}

