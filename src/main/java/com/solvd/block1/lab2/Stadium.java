package com.solvd.block1.lab2;

/*
 * This class is used to represent a Stadium. It contains fields of the Stadium's name and capacity. It has getters and
 * setters for each field. It also has proper implementation of the toString(), equals(), and hashCode() methods.
 */

import com.solvd.block1.lab2.exceptions.StadiumCapacityException;

import java.util.Objects;

class Stadium {

    // Attributes and variables
    private String name;
    private int capacity;

    // Constructor
    Stadium(String name, int capacity) throws StadiumCapacityException {
        this.name = name;
        this.capacity = capacity;

        if (this.getCapacity() < 0 || this.getCapacity() > 50000) {
            throw new StadiumCapacityException("Stadium capacity is invalid or exceeded for the match.");
        }

    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // Override of the toString() method from Objects Class
    @Override
    public String toString() {
        return "Stadium{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    // Override of the equals() method from Objects Class
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stadium stadium = (Stadium) o;
        return capacity == stadium.capacity &&
                Objects.equals(name, stadium.name);
    }

    // Override of the hashCode() method from Objects Class
    @Override
    public int hashCode() {
        return Objects.hash(name, capacity);
    }
}


