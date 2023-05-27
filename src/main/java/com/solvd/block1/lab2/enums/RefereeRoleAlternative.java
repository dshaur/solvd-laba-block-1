package com.solvd.block1.lab2.enums;

public enum RefereeRoleAlternative {
    MAIN("Main Referee"),
    ASSISTANT("Assistant Referee"),
    LINE("Line Referee");

    private final String displayName;

    RefereeRoleAlternative(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    // Example usage of the enum in a method
    public static RefereeRoleAlternative getRoleFromDisplayName(String displayName) {
        for (RefereeRoleAlternative role : RefereeRoleAlternative.values()) {
            if (role.getDisplayName().equals(displayName)) {
                return role;
            }
        }
        throw new IllegalArgumentException("No RefereeRole with the specified display name exists.");
    }
}
