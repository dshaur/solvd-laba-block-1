package com.solvd.block1.reflection;

public class Main {
    public static void main(String[] args) throws Exception {

        // Create a SoccerPlayer object using reflection
        SoccerPlayer player = SoccerPlayer.createPlayer("Lionel Messi", 34, "Forward");

        // Invoke the performAction() method on the player object using reflection
        player.performAction("addStat", "goals", 534);

        // Extract information about the player object using reflection
        player.getStats();
    }
}