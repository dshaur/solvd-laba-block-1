package com.solvd.block1.lab2.enums;

enum FormationType {
    FOUR_FOUR_TWO("4-4-2"),
    THREE_FIVE_TWO("3-5-2"),
    FOUR_THREE_THREE("4-3-3");

    private String name;

    private FormationType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Other fields, methods, and blocks can be added here
}
