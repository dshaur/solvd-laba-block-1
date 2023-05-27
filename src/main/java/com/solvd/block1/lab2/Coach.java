package com.solvd.block1.lab2;

/*
 * This class represents a Coach. It is a subclass of the Person class.
 * It has a constructor that takes in a name and age as parameters,
 * and a method called motivateTeam() which prints a motivational message.
 */


import com.solvd.block1.lab2.exceptions.CoachNotFoundException;
import com.solvd.block1.lab2.interfaces.Cheerable;
import com.solvd.block1.lab2.interfaces.Coachable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;


class Coach extends Person implements Coachable, Cheerable {

    // Logger
    private static final Logger LOGGER = LogManager.getLogger(Coach.class);

    // Constructor
    Coach(String name, int age) throws CoachNotFoundException {

        super(name, age);

        // Check if the home Coach or away Coach is empty
        if (Objects.equals(this.getName(), "")) {

            throw new CoachNotFoundException("Home coach or away coach name not found.");

        }
    }

    // motivateTeam() method
    public void instructTeam() {
        LOGGER.info(this.getName() + " is instructing his team...");
    }

    // cheer() method
    public void cheer() {
        LOGGER.info(this.getName() + " is cheering up his team...");
    }
}
