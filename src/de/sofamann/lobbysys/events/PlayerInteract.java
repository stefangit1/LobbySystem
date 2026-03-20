package de.sofamann.lobbysys.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.sofamann.lobbysys.main.Main;

public class PlayerInteract implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		
		Player p = e.getPlayer();
		
		FileConfiguration config = Main.getPlugin().getConfig();

		e.setCancelled(true);
		
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				
			if(p.getItemInHand().getType().equals(Material.WRITTEN_BOOK) || p.getItemInHand().getType().equals(Material.COMPASS) || p.getItemInHand().getType().equals(Material.NAME_TAG)) {
			
				Inventory inv = Bukkit.createInventory(null, 9 * 6, "Navigator");
				
				Location loc = p.getLocation();
				Sound sound = Sound.CHEST_OPEN;
				p.playSound(loc, sound, 100, (float) 1.0);
			
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
				inv.setItem(27, itemstack);
				inv.setItem(28, itemstack);
				inv.setItem(29, itemstack);
				inv.setItem(30, itemstack);
				inv.setItem(31, itemstack);
				inv.setItem(32, itemstack);
				inv.setItem(33, itemstack);
				inv.setItem(34, itemstack);
				inv.setItem(35, itemstack);
				inv.setItem(36, itemstack);
				inv.setItem(37, itemstack);
				inv.setItem(38, itemstack);
				inv.setItem(39, itemstack);
				inv.setItem(40, itemstack);
				inv.setItem(41, itemstack);
				inv.setItem(42, itemstack);
				inv.setItem(43, itemstack);
				inv.setItem(44, itemstack);
				inv.setItem(45, itemstack);
				inv.setItem(46, itemstack);
				inv.setItem(47, itemstack);
				inv.setItem(48, itemstack);
				inv.setItem(49, itemstack);
				inv.setItem(50, itemstack);
				inv.setItem(51, itemstack);
				inv.setItem(52, itemstack);
				inv.setItem(53, itemstack);

				for(int i = 55; i > 0; i--) {
					
					if(config.contains(String.valueOf(i + ".World"))) {
						
						Material m = Material.matchMaterial(config.getString(i + ".Item"));
						ItemStack item = new ItemStack(m);
						ItemMeta itemm2 = item.getItemMeta();
						itemm2.setDisplayName(config.getString(i + ".Name"));
						item.setItemMeta(itemm2);
						int slot = config.getInt(i + ".Slot");
						inv.setItem(slot, item);
												
					}
					
				}
				
				p.openInventory(inv);
						
			} else if(p.getItemInHand().getType().equals(Material.GOLD_HOE)) {
			
				p.shootArrow();
			
				Location loc = p.getLocation();
				Sound sound = Sound.FIREWORK_LAUNCH;
				p.playSound(loc, sound, 100, (float) 1.0);
			
			} else if(p.getItemInHand().getType().equals(Material.SKULL_ITEM)) {
			
				Inventory inv = Bukkit.createInventory(null, 9 * 3, "Einstellungen");
			
				Location loc = p.getLocation();
				Sound sound = Sound.CHEST_OPEN;
				p.playSound(loc, sound, 100, (float) 1.0);
			
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
			
				if(Main.compassList.contains(p.getUniqueId().toString())) {
				
					ItemStack compass = new ItemStack(Material.COMPASS);
					ItemMeta compassmeta = compass.getItemMeta();
					compassmeta.setDisplayName("§c§lNAVIGATOR");
					compass.setItemMeta(compassmeta);
					inv.setItem(1, compass);
				
				} else if(Main.nametagList.contains(p.getUniqueId().toString())) {
				
					ItemStack nametag = new ItemStack(Material.NAME_TAG);
					ItemMeta nametagmeta = nametag.getItemMeta();
					nametagmeta.setDisplayName("§c§lNAVIGATOR");
					nametag.setItemMeta(nametagmeta);
					inv.setItem(1, nametag);
				
				} else if(Main.bookList.contains(p.getUniqueId().toString())) {
				
					ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
					ItemMeta bookmeta = book.getItemMeta();
					bookmeta.setDisplayName("§c§lNAVIGATOR");
					book.setItemMeta(bookmeta);
					inv.setItem(1, book);
				
				} 
			
				p.openInventory(inv);
			
			} else if(p.getItemInHand().getType().equals(Material.BONE)) {
				
				Location loc = p.getLocation();
				Sound sound = Sound.ZOMBIE_WOODBREAK;
				p.playSound(loc, sound, 100, (float) 1.0);
				
				Main.versteckList.add(p);
				
				for(Player all : Bukkit.getOnlinePlayers()) {
						
					p.hidePlayer(p);
					p.hidePlayer(all);
					
				}
					
				ItemStack verstecker = new ItemStack(Material.STICK);
				ItemMeta versteckmeta = verstecker.getItemMeta();
				versteckmeta.setDisplayName("§c§lVERSTECKER §7§l[§c§lKEINE§7§l]");
				verstecker.setItemMeta(versteckmeta);
				p.getInventory().setItem(1, verstecker);
				
			} else if(p.getItemInHand().getType().equals(Material.STICK)) {
				
				Location loc = p.getLocation();
				Sound sound = Sound.ZOMBIE_WOODBREAK;
				p.playSound(loc, sound, 100, (float) 1.0);
				
				Main.versteckList.remove(p);
				
				for(Player all : Bukkit.getOnlinePlayers()) {
						
					p.showPlayer(all);
					
				}
				
				ItemStack verstecker = new ItemStack(Material.BONE);
				ItemMeta versteckmeta = verstecker.getItemMeta();
				versteckmeta.setDisplayName("§c§lVERSTECKER §7§l[§c§lALLE§7§l]");
				verstecker.setItemMeta(versteckmeta);
				p.getInventory().setItem(1, verstecker);
				
			} else if(p.getItemInHand().getType().equals(Material.CHEST)) {
				
				Inventory inv = Bukkit.createInventory(null, 9 * 3, "Gadgets");
				
				Location loc = p.getLocation();
				Sound sound = Sound.CHEST_OPEN;
				p.playSound(loc, sound, 100, (float) 1.0);
			
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
				
				ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
				ItemMeta bootsmeta = boots.getItemMeta();
				bootsmeta.setDisplayName("§7§l> §c§lPARTIKEL SCHUHE");
				boots.setItemMeta(bootsmeta);
				inv.setItem(11, boots);
				
				ItemStack gadgets = new ItemStack(Material.FISHING_ROD);
				ItemMeta gadgetmeta = gadgets.getItemMeta();
				gadgetmeta.setDisplayName("§7§l> §c§lGADGETS");
				gadgets.setItemMeta(gadgetmeta);
				inv.setItem(15, gadgets);
				
				p.openInventory(inv);
				
			}
		
		}
		
	}

}