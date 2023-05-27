package com.solvd.block1.lab2;

/*
 * This class represents a Referee, which is a type of Person. It has a constructor that takes a name
 * and age as parameters, and it has a method whistle() that prints a message.
 */

import com.solvd.block1.lab2.exceptions.RefereeNotFoundException;
import com.solvd.block1.lab2.interfaces.Runnable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

class Referee extends Person implements Runnable {

    public enum RefereeRole {
        MAIN,
        ASSISTANT,
        LINE
    }

    // Attributes and Variables
    private final RefereeRole role;
    private Referee nextReferee;

    // Logger
    private static final Logger LOGGER = LogManager.getLogger(Referee.class);

    // Constructor
    Referee(String name, int age, RefereeRole role) throws RefereeNotFoundException {

        super(name, age);
        this.role = role;
        // Check if the referee name is empty
        if (Objects.equals(this.getName(), "")) {

            throw new RefereeNotFoundException("Referee name not found.");

        }
    }

    // Getters and Setters
    public RefereeRole getRole() {
        return role;
    }

    public void setNextReferee(Referee nextReferee) {
        this.nextReferee = nextReferee;
    }

    public Referee getNextReferee() {
        return nextReferee;
    }

    // method to display the referees
    public void displayReferees() {
        if (this.getRole() == RefereeRole.MAIN || this.getRole() == RefereeRole.ASSISTANT) {
            LOGGER.info(this.getName() + " as the " + this.getRole().toString() + " referee.");
        } else if (this.getRole() == RefereeRole.LINE) {
            LOGGER.info(this.getName() + " as a " + this.getRole().toString() + " referee.");
        }
    }

    // whistle() method
    public void whistle() {
        LOGGER.info("The referee " + this.getName() + " is whistling...");
    }

    //  run() method
    @Override
    public void run() {
        LOGGER.info(getName() + " is running.");
    }
}
