package de.sofamann.lobbysys.main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.sofamann.lobbysys.commands.CMD_lobby;
import de.sofamann.lobbysys.events.Cancelled;
import de.sofamann.lobbysys.events.DoubleJump;
import de.sofamann.lobbysys.events.InventoryClick;
import de.sofamann.lobbysys.events.JoinQuit;
import de.sofamann.lobbysys.events.PlayerInteract;
import de.sofamann.lobbysys.events.ProjectileHit;

public class Main extends JavaPlugin {
	
	public static String PREFIX = "§cLobby §8»§7";
	
	public static List<String> compassList = new ArrayList<>();
	public static List<String> nametagList = new ArrayList<>();
	public static List<String> bookList = new ArrayList<>();
	public static LinkedList<Player> versteckList = new LinkedList<>();
	public static LinkedList<Player> heartList = new LinkedList<>();
	public static LinkedList<Player> rainbowList = new LinkedList<>();
	
	private static Main plugin;
	
	public void onEnable() {
		
		plugin= this;
				
		getCommand("system").setExecutor(new CMD_lobby());
		
		PluginManager plm = Bukkit.getPluginManager();
		plm.registerEvents(new Cancelled(), this);
		plm.registerEvents(new JoinQuit(), this);
		plm.registerEvents(new PlayerInteract(), this);
		plm.registerEvents(new ProjectileHit(), this);
		plm.registerEvents(new InventoryClick(), this);
		plm.registerEvents(new DoubleJump(), this);
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			
			@Override
			public void run() {
				
				for(Player all : heartList) {
					
					Bukkit.getWorld(all.getWorld().getUID()).playEffect(all.getLocation(), Effect.HEART, 0);
					
				}
				
				for(Player all : rainbowList) {
					
					Bukkit.getWorld(all.getWorld().getUID()).playEffect(all.getLocation(), Effect.COLOURED_DUST, 0);
					
				}
				
			}
			
		}, 0, 3);
		
	}
	
public static Main getPlugin() {
		
		return plugin;
		
	}

}