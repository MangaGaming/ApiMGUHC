package com.mguhc.game;

import com.mguhc.UhcAPI;
import com.mguhc.player.UhcPlayer;
import com.mguhc.roles.RoleManager;
import com.mguhc.roles.UhcRole;

import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class UhcGame {
    private RoleManager roleManager;
    private GamePhase currentPhase; // Champ pour la phase actuelle
    private int timePassed;

    public UhcGame() {
        this.roleManager = new RoleManager();
        this.currentPhase = new GamePhase("Waiting"); // Initialiser la phase à "Waiting"
    }

    public void startGame(List<UhcPlayer> players) {
        // Changer la phase actuelle à "Playing"
        this.currentPhase = new GamePhase("Playing");

        // Ajouter les joueurs à la phase actuelle
        for (UhcPlayer player : players) {
            currentPhase.addPlayer(player);
        }

        // Attribuer des rôles aux joueurs à partir du RoleManager
        List<UhcRole> validRoles = roleManager.getValidRoles(); // Récupérer les rôles valides
        for (UhcPlayer player : players) {
            // Assigner un rôle aléatoire parmi les rôles valides
            UhcRole assignedRole = validRoles.get((int) (Math.random() * validRoles.size()));
            roleManager.assignRole(player, assignedRole);
        }

        new BukkitRunnable() {
            @Override
            public void run() {
                timePassed ++;
            }
        }.runTaskTimer(UhcAPI.getInstance(), 0, 20); // Exécute toutes les secondes
    }

    public void nextPhase() {
        // Logique pour passer à la phase suivante
    }

    public RoleManager getRoleManager() {
        return roleManager;
    }

    public GamePhase getCurrentPhase() {
        return currentPhase; // Méthode pour récupérer la phase actuelle
    }
    
    public int gettimePassed() {
    	return timePassed;
    }
}