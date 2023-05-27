package com.solvd.block1.lab2.enums;

import java.util.Random;

public enum WeatherCondition {
    SUNNY("Sunny"),
    CLOUDY("Cloudy"),
    RAINY("Rainy"),
    SNOWY("Snowy");

    private final String label;

    WeatherCondition(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static WeatherCondition getRandomCondition() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}

