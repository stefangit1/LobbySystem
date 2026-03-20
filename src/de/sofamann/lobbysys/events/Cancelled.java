package de.sofamann.lobbysys.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class Cancelled implements Listener {
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		
		e.setCancelled(true);
		
	}
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		
		e.setCancelled(true);
		
	}
	
	@EventHandler
	public void onBreak(PlayerDropItemEvent e) {
		
		e.setCancelled(true);
		
	}
	
	@EventHandler
	public void onBreak(PlayerPickupItemEvent e) {
		
		e.setCancelled(true);
		
	}
	
	@EventHandler
	public void onSpawn(CreatureSpawnEvent e) {
		
		e.setCancelled(true);
		
	}
	
	@EventHandler
	public void onChange(WeatherChangeEvent e) {
		
		e.setCancelled(true);
		
	}
	
	@EventHandler
	public void onChange(EntityChangeBlockEvent e) {
		
		e.setCancelled(true);
		
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		
		e.setCancelled(true);
		
	}
	
	@EventHandler
	public void onChange(FoodLevelChangeEvent e) {
		
		e.setCancelled(true);
		
	}

}