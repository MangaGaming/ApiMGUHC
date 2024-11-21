package com.mguhc.player;

import org.bukkit.entity.Player;

public class UhcPlayer {
    private Player player;
    private boolean isAlive;
    private int health;
    // Ajoutez d'autres attributs si nécessaire

    public UhcPlayer(Player player) {
        this.player = player;
        this.isAlive = true;
        this.health = 20; // Santé par défaut
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}