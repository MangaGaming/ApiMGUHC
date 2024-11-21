package com.mguhc;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.Listener;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

import com.mguhc.commands.AssignRoleCommand;
import com.mguhc.game.UhcGame;
import com.mguhc.listeners.PlayerListener;
import com.mguhc.player.PlayerManager;

public class UhcAPI extends JavaPlugin implements Listener {
    private PlayerManager playermanager;
    private UhcGame uhcgame;
    private static UhcAPI instance;
    private World world;

    @Override
    public void onEnable() {
        instance = this;
        playermanager = new PlayerManager();
        uhcgame = new UhcGame();
        
        world = Bukkit.getWorld("world");
        if (world == null) {
            getLogger().severe("Le monde 'world' n'est pas chargé !");
            return; // Sortir si le monde n'est pas trouvé
        }
        
        

        // Enregistrer l'écouteur
        Bukkit.getPluginManager().registerEvents(this, this);
        Bukkit.getPluginManager().registerEvents(new PlayerListener(uhcgame), this);
        
        // Enregistrer les commands
        getCommand("giverole").setExecutor(new AssignRoleCommand(uhcgame));
    }

    @Override
    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
        return new ChunkGenerator() {
            @Override
            public List<BlockPopulator> getDefaultPopulators (World world) {
                List<BlockPopulator> populators = new ArrayList<>();
                // Ajoutez d'autres populators si nécessaire
                return populators;
            }
        };
    }

    public static UhcAPI getInstance() {
        return instance;
    }

    public PlayerManager getPlayerManager() {
        return playermanager;
    }
}