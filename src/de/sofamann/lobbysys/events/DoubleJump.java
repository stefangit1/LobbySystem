package de.sofamann.lobbysys.events;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class DoubleJump implements Listener {
	
private List<Player> doubleJump = new ArrayList<>();

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		event.getPlayer().setAllowFlight(true);
		
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		
		doubleJump.remove(event.getPlayer());
		
	}

	@EventHandler
	public void onToggleFlight(PlayerToggleFlightEvent event) {
		
		Player p = event.getPlayer();
		GameMode gameMode = p.getGameMode();
		
		if(gameMode == GameMode.CREATIVE || gameMode == GameMode.SPECTATOR || p.isFlying()) {
			
			return;
			
		}

		event.setCancelled(true);
		doubleJump.add(p);

		p.setAllowFlight(false);
		p.setFlying(false);
		p.setVelocity(p.getLocation().getDirection().multiply(2).setY(1.2));
		
		Location loc = p.getLocation();
		Sound sound = Sound.FIREWORK_LAUNCH;
		p.playSound(loc, sound, 100, (float) 1.0);
		
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onHitGround(PlayerMoveEvent event) {
		
		Player p = event.getPlayer();

		if ((p.isOnGround() || event.getTo().getBlock().isLiquid()) && doubleJump.remove(p)) {
			
			p.setAllowFlight(true);
			
		}
	}

}