package com.solvd.block1.lab2.enums;

import com.solvd.block1.lab2.Player;

import java.util.ArrayList;

public enum Country {
    ARGENTINA("Argentina", new ArrayList<>()),
    BRAZIL("Brazil", new ArrayList<>()),
    GERMANY("Germany", new ArrayList<>()),
    SPAIN("Spain", new ArrayList<>()),
    ENGLAND("England", new ArrayList<>());

    private final String name;
    private final ArrayList<Player> players;

    Country(String name, ArrayList<Player> players) {
        this.name = name;
        this.players = players;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public int getNumberOfPlayers() {
        return players.size();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }
}
