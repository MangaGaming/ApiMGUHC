package com.mguhc.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;

import com.mguhc.game.GamePhase;
import com.mguhc.game.UhcGame;

public class PlayerListener implements Listener {
	
	private UhcGame uhcgame;

	public PlayerListener(UhcGame uhcgame) {
		this.uhcgame = uhcgame;
	}

	@EventHandler
	private void OnJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		World world = Bukkit.getWorld("world");
		GamePhase currentphase = uhcgame.getCurrentPhase();
		
		if(currentphase.getName().equals("Waiting")) {
			player.setMaxHealth(20);
			player.setHealth(20);
			player.setSaturation(20);
			for (PotionEffect effect : player.getActivePotionEffects()) {
			    player.removePotionEffect(effect.getType());
			}
			player.teleport(new Location(world, 0, 202, 0));
		}
	}
}