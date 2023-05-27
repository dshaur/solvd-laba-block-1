package com.solvd.block1.lab2.enums;

enum MatchEventType {
    GOAL("Goal"),
    YELLOW_CARD("Yellow Card"),
    RED_CARD("Red Card"),
    SUBSTITUTION("Substitution"),
    INJURY("Injury");

    private String name;

    MatchEventType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Other fields, methods, and blocks can be potentially added here
}