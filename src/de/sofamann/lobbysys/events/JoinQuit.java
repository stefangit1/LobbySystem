package de.sofamann.lobbysys.events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import de.sofamann.lobbysys.main.Main;

public class JoinQuit implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		
		FileConfiguration config = Main.getPlugin().getConfig();
		
		e.setJoinMessage(null);
		
		if(config.contains("Spawn.World")) {
			
	        World world = Bukkit.getWorld(config.getString("Spawn.World"));
	        double x = config.getDouble("Spawn.X");
	        double y = config.getDouble("Spawn.Y");
	        double z = config.getDouble("Spawn.Z");
	        float yaw = (float) config.getDouble("Spawn.Yaw");
	        float pitch = (float) config.getDouble("Spawn.Pitch");
	        Location location = new Location(world, x, y, z, yaw, pitch);
	        p.teleport(location);
	        
			}
		
		if(Main.compassList.contains(p.getUniqueId().toString())) {
			
		} else if(Main.bookList.contains(p.getUniqueId().toString())) {
			
		} else if(Main.nametagList.contains(p.getUniqueId().toString())) {
			
		} else {
			
			Main.bookList.add(p.getUniqueId().toString());
			
		}
		
		Location loc = p.getLocation();
		Sound sound = Sound.EXPLODE;
		p.playSound(loc, sound, 100, (float) 1.0);
		
		p.setHealth(20);
		p.setFoodLevel(20);
		p.setGameMode(GameMode.SURVIVAL);
		p.getInventory().clear();
		p.getInventory().setBoots(null);
		p.getInventory().setHelmet(null);
		p.getInventory().setChestplate(null);
		p.getInventory().setLeggings(null);
		p.setLevel(2021);
		p.setAllowFlight(true);
		
		if(Main.compassList.contains(p.getUniqueId().toString())) {
			
			ItemStack compass = new ItemStack(Material.COMPASS);
			ItemMeta compassmeta = compass.getItemMeta();
			compassmeta.setDisplayName("§c§lNAVIGATOR");
			compass.setItemMeta(compassmeta);
			p.getInventory().setItem(0, compass);
			
		} else if(Main.nametagList.contains(p.getUniqueId().toString())) {
			
			ItemStack nametag = new ItemStack(Material.NAME_TAG);
			ItemMeta nametagmeta = nametag.getItemMeta();
			nametagmeta.setDisplayName("§c§lNAVIGATOR");
			nametag.setItemMeta(nametagmeta);
			p.getInventory().setItem(0, nametag);
			
		} else if(Main.bookList.contains(p.getUniqueId().toString())) {
			
			ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
			ItemMeta bookmeta = book.getItemMeta();
			bookmeta.setDisplayName("§c§lNAVIGATOR");
			book.setItemMeta(bookmeta);
			p.getInventory().setItem(0, book);
			
		}
		
		ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta skullmeta = (SkullMeta) skull.getItemMeta();
		skullmeta.setDisplayName("§c§lEINSTELLUNGEN");
		skullmeta.setOwner(p.getName());
		skull.setItemMeta(skullmeta);
		p.getInventory().setItem(8, skull);
		
		ItemStack barrier = new ItemStack(Material.BARRIER);
		ItemMeta barriermeta = barrier.getItemMeta();
		barriermeta.setDisplayName("§c§lKeine Gadgets ausgewählt!");
		barrier.setItemMeta(barriermeta);
		p.getInventory().setItem(4, barrier);
		
		ItemStack verstecker = new ItemStack(Material.BONE);
		ItemMeta versteckmeta = verstecker.getItemMeta();
		versteckmeta.setDisplayName("§c§lVERSTECKER §7§l[§c§lALLE§7§l]");
		verstecker.setItemMeta(versteckmeta);
		p.getInventory().setItem(1, verstecker);
		
		ItemStack gadgets = new ItemStack(Material.CHEST);
		ItemMeta gadgetmeta = gadgets.getItemMeta();
		gadgetmeta.setDisplayName("§c§lGADGETS");
		gadgets.setItemMeta(gadgetmeta);
		p.getInventory().setItem(7, gadgets);
		
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
				
		Player p = e.getPlayer();
		
		e.setQuitMessage(null);
		
		Main.heartList.remove(p);
		Main.rainbowList.remove(p);
		
	}

}