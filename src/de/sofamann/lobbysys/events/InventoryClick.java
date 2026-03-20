package de.sofamann.lobbysys.events;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import de.sofamann.lobbysys.main.Main;

public class InventoryClick implements Listener {
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		
		Player p = (Player) e.getWhoClicked();
		
		FileConfiguration config = Main.getPlugin().getConfig();
		
		e.setCancelled(true);
		
		if(e.getInventory().getTitle() == "Navigator") {
		
			for(int i = 55; i > 0; i--) {
			
				if(config.getInt(i + ".Slot") == e.getSlot()) {
				
					Location loc = p.getLocation();
					Sound sound = Sound.EXPLODE;
					p.playSound(loc, sound, 100, (float) 1.0);
				
					World world = Bukkit.getWorld(config.getString(i + ".World"));
		        	double x = config.getDouble(i + ".X");
		        	double y = config.getDouble(i + ".Y");
		        	double z = config.getDouble(i + ".Z");
		        	float yaw = (float) config.getDouble(i + ".Yaw");
		        	float pitch = (float) config.getDouble(i + ".Pitch");
		        	Location location = new Location(world, x, y, z, yaw, pitch);
		        	p.teleport(location);
		        	
		        	p.playEffect(p.getLocation(), Effect.PARTICLE_SMOKE, null);
		        
		        	p.sendMessage(Main.PREFIX + " §7Du wurdest zu " + config.getString(i + ".Name") + " §7teleportiert!");
		        	
		        	i = 0;
		        	
				}
			
			}
		
		}
		
		if(e.getCurrentItem().getType().equals(Material.NAME_TAG)) {
			
			Location loc = p.getLocation();
			Sound sound = Sound.LEVEL_UP;
			p.playSound(loc, sound, 100, (float) 1.0);
			
			Main.nametagList.remove(p.getUniqueId().toString());	
			Main.compassList.add(p.getUniqueId().toString());
			
			Inventory inv = Bukkit.createInventory(null, 9 * 3, "Einstellungen");
			
			ItemStack itemstack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
			ItemMeta itemmeta = itemstack.getItemMeta();
			itemmeta.setDisplayName("§7");
			itemstack.setItemMeta(itemmeta);
			
			inv.setItem(0, itemstack);
			inv.setItem(1, itemstack);
			inv.setItem(2, itemstack);
			inv.setItem(3, itemstack);
			inv.setItem(4, itemstack);
			inv.setItem(5, itemstack);
			inv.setItem(6, itemstack);
			inv.setItem(7, itemstack);
			inv.setItem(8, itemstack);
			inv.setItem(9, itemstack);
			inv.setItem(10, itemstack);
			inv.setItem(11, itemstack);
			inv.setItem(12, itemstack);
			inv.setItem(13, itemstack);
			inv.setItem(14, itemstack);
			inv.setItem(15, itemstack);
			inv.setItem(16, itemstack);
			inv.setItem(17, itemstack);
			inv.setItem(18, itemstack);
			inv.setItem(19, itemstack);
			inv.setItem(20, itemstack);
			inv.setItem(21, itemstack);
			inv.setItem(22, itemstack);
			inv.setItem(23, itemstack);
			inv.setItem(24, itemstack);
			inv.setItem(25, itemstack);
			inv.setItem(26, itemstack);
				
			ItemStack compass = new ItemStack(Material.COMPASS);
			ItemMeta compassmeta = compass.getItemMeta();
			compassmeta.setDisplayName("§c§lNAVIGATOR");
			compass.setItemMeta(compassmeta);
			inv.setItem(1, compass);
			p.getInventory().setItem(0, compass);
			
			p.openInventory(inv);

		} else if(e.getCurrentItem().getType().equals(Material.COMPASS)) {
			
			Location loc = p.getLocation();
			Sound sound = Sound.LEVEL_UP;
			p.playSound(loc, sound, 100, (float) 1.0);
			
			Main.compassList.remove(p.getUniqueId().toString());
			Main.bookList.add(p.getUniqueId().toString());
			
			Inventory inv = Bukkit.createInventory(null, 9 * 3, "Einstellungen");
			
			ItemStack itemstack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
			ItemMeta itemmeta = itemstack.getItemMeta();
			itemmeta.setDisplayName("§7");
			itemstack.setItemMeta(itemmeta);
			
			inv.setItem(0, itemstack);
			inv.setItem(1, itemstack);
			inv.setItem(2, itemstack);
			inv.setItem(3, itemstack);
			inv.setItem(4, itemstack);
			inv.setItem(5, itemstack);
			inv.setItem(6, itemstack);
			inv.setItem(7, itemstack);
			inv.setItem(8, itemstack);
			inv.setItem(9, itemstack);
			inv.setItem(10, itemstack);
			inv.setItem(11, itemstack);
			inv.setItem(12, itemstack);
			inv.setItem(13, itemstack);
			inv.setItem(14, itemstack);
			inv.setItem(15, itemstack);
			inv.setItem(16, itemstack);
			inv.setItem(17, itemstack);
			inv.setItem(18, itemstack);
			inv.setItem(19, itemstack);
			inv.setItem(20, itemstack);
			inv.setItem(21, itemstack);
			inv.setItem(22, itemstack);
			inv.setItem(23, itemstack);
			inv.setItem(24, itemstack);
			inv.setItem(25, itemstack);
			inv.setItem(26, itemstack);
			
			ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
			ItemMeta bookmeta = book.getItemMeta();
			bookmeta.setDisplayName("§c§lNAVIGATOR");
			book.setItemMeta(bookmeta);
			inv.setItem(1, book);
			p.getInventory().setItem(0, book);
			
			p.openInventory(inv);

		} else if(e.getCurrentItem().getType().equals(Material.WRITTEN_BOOK)) {
			
			Location loc = p.getLocation();
			Sound sound = Sound.LEVEL_UP;
			p.playSound(loc, sound, 100, (float) 1.0);
			
			Main.bookList.remove(p.getUniqueId().toString());
			Main.nametagList.add(p.getUniqueId().toString());
			
			Inventory inv = Bukkit.createInventory(null, 9 * 3, "Einstellungen");
			
			ItemStack itemstack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
			ItemMeta itemmeta = itemstack.getItemMeta();
			itemmeta.setDisplayName("§7");
			itemstack.setItemMeta(itemmeta);
			
			inv.setItem(0, itemstack);
			inv.setItem(1, itemstack);
			inv.setItem(2, itemstack);
			inv.setItem(3, itemstack);
			inv.setItem(4, itemstack);
			inv.setItem(5, itemstack);
			inv.setItem(6, itemstack);
			inv.setItem(7, itemstack);
			inv.setItem(8, itemstack);
			inv.setItem(9, itemstack);
			inv.setItem(10, itemstack);
			inv.setItem(11, itemstack);
			inv.setItem(12, itemstack);
			inv.setItem(13, itemstack);
			inv.setItem(14, itemstack);
			inv.setItem(15, itemstack);
			inv.setItem(16, itemstack);
			inv.setItem(17, itemstack);
			inv.setItem(18, itemstack);
			inv.setItem(19, itemstack);
			inv.setItem(20, itemstack);
			inv.setItem(21, itemstack);
			inv.setItem(22, itemstack);
			inv.setItem(23, itemstack);
			inv.setItem(24, itemstack);
			inv.setItem(25, itemstack);
			inv.setItem(26, itemstack);
			
			ItemStack nametag = new ItemStack(Material.NAME_TAG);
			ItemMeta nametagmeta = nametag.getItemMeta();
			nametagmeta.setDisplayName("§c§lNAVIGATOR");
			nametag.setItemMeta(nametagmeta);
			inv.setItem(1, nametag);
			p.getInventory().setItem(0, nametag);
				
			p.openInventory(inv);	
			
		} else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§l> §c§lPARTIKEL SCHUHE")) {
			
			Location loc = p.getLocation();
			Sound sound = Sound.ORB_PICKUP;
			p.playSound(loc, sound, 100, (float) 1.0);
			
			Inventory inv = Bukkit.createInventory(null, 9 * 3, "Partikel Schuhe");
			
			ItemStack itemstack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
			ItemMeta itemmeta = itemstack.getItemMeta();
			itemmeta.setDisplayName("§7");
			itemstack.setItemMeta(itemmeta);
			
			inv.setItem(0, itemstack);
			inv.setItem(1, itemstack);
			inv.setItem(2, itemstack);
			inv.setItem(3, itemstack);
			inv.setItem(4, itemstack);
			inv.setItem(5, itemstack);
			inv.setItem(6, itemstack);
			inv.setItem(7, itemstack);
			inv.setItem(8, itemstack);
			inv.setItem(9, itemstack);
			inv.setItem(10, itemstack);
			inv.setItem(11, itemstack);
			inv.setItem(12, itemstack);
			inv.setItem(13, itemstack);
			inv.setItem(14, itemstack);
			inv.setItem(15, itemstack);
			inv.setItem(16, itemstack);
			inv.setItem(17, itemstack);
			inv.setItem(18, itemstack);
			inv.setItem(19, itemstack);
			inv.setItem(20, itemstack);
			inv.setItem(21, itemstack);
			inv.setItem(22, itemstack);
			inv.setItem(23, itemstack);
			inv.setItem(24, itemstack);
			inv.setItem(25, itemstack);
			inv.setItem(26, itemstack);
			
			ItemStack heart = new ItemStack(Material.LEATHER_BOOTS);
			LeatherArmorMeta heartmeta = (LeatherArmorMeta) heart.getItemMeta();
			heartmeta.setDisplayName("§7§l> §c§lHERZ SCHUHE");
			heartmeta.setColor(Color.RED);
			heart.setItemMeta(heartmeta);
			inv.setItem(11, heart);
			
			ItemStack rainbow = new ItemStack(Material.LEATHER_BOOTS);
			LeatherArmorMeta rainbowmeta = (LeatherArmorMeta) rainbow.getItemMeta();
			rainbowmeta.setDisplayName("§7§l> §c§lREGENBOGEN SCHUHE");
			rainbowmeta.setColor(Color.BLACK);
			rainbow.setItemMeta(rainbowmeta);
			inv.setItem(15, rainbow);
			
			ItemStack cancel = new ItemStack(Material.BARRIER);
			ItemMeta cancelmeta = cancel.getItemMeta();
			cancelmeta.setDisplayName("§c§lBoots entfernen!");
			cancel.setItemMeta(cancelmeta);
			inv.setItem(26, cancel);
			
			p.openInventory(inv);
			
		} else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§l> §c§lHERZ SCHUHE")) {
			
			if(p.getInventory().getBoots() != null) {
				
				Location loc = p.getLocation();
				Sound sound = Sound.NOTE_BASS;
				p.playSound(loc, sound, 100, (float) 1.0);
				
				return;
				
			} else {
			
				ItemStack heart = new ItemStack(Material.LEATHER_BOOTS);
				LeatherArmorMeta heartmeta = (LeatherArmorMeta) heart.getItemMeta();
				heartmeta.setDisplayName("§7§l> §c§lHERZ SCHUHE");
				heartmeta.setColor(Color.RED);
				heart.setItemMeta(heartmeta);
			
				Location loc = p.getLocation();
				Sound sound = Sound.LEVEL_UP;
				p.playSound(loc, sound, 100, (float) 1.0);
			
				p.closeInventory();
				p.getInventory().setBoots(heart);
				
				Main.heartList.add(p);
				
			}
			
		} else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§c§lBoots entfernen!")) {
			
			p.closeInventory();
			p.getInventory().setBoots(null);
			
			Location loc = p.getLocation();
			Sound sound = Sound.LEVEL_UP;
			p.playSound(loc, sound, 100, (float) 1.0);
			
			Main.heartList.remove(p);
			Main.rainbowList.remove(p);
			
		} else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§l> §c§lREGENBOGEN SCHUHE")) {
			
			if(p.getInventory().getBoots() != null) {
				
				Location loc = p.getLocation();
				Sound sound = Sound.NOTE_BASS;
				p.playSound(loc, sound, 100, (float) 1.0);
				
				return;
				
			} else {
			
				ItemStack rainbow = new ItemStack(Material.LEATHER_BOOTS);
				LeatherArmorMeta rainbowmeta = (LeatherArmorMeta) rainbow.getItemMeta();
				rainbowmeta.setDisplayName("§7§l> §c§lREGENBOGEN SCHUHE");
				rainbowmeta.setColor(Color.BLACK);
				rainbow.setItemMeta(rainbowmeta);
			
				Location loc = p.getLocation();
				Sound sound = Sound.LEVEL_UP;
				p.playSound(loc, sound, 100, (float) 1.0);
			
				p.closeInventory();
				p.getInventory().setBoots(rainbow);
				
				Main.rainbowList.add(p);
				
			}
			
		}
			
	}

}