package de.sofamann.lobbysys.commands;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.sofamann.lobbysys.main.Main;

public class CMD_lobby implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			
			FileConfiguration config = Main.getPlugin().getConfig();
			
			if(args.length == 0) {
			
				if(p.hasPermission("lobby.*") || p.isOp()) {
				
					p.sendMessage("§7 §7 §7 §c§lLOBBY §7 §7 §7 \n"
							+ " \n"
							+ "§7/system setspawn §8Setzt den Spawnpunkt der Lobby \n"
							+ "§7/system setwarp <Warp> <Item> <Name> <Slot> §8Setzt einen bestimmten Warp \n"
							+ "§7/system infowarp <Warp> §8Zeigt alle Infos des bestimmten Warps \n"
							+ "§7/system removewarp <Warp> §8 Entfernt einen bestimmten Warp \n"
							+ " ");
				
					Location loc = p.getLocation();
					Sound sound = Sound.ORB_PICKUP;
					p.playSound(loc, sound, 100, (float) 1.0);
					
				} else {
					
					Location loc = p.getLocation();
					Sound sound = Sound.NOTE_BASS;
					p.playSound(loc, sound, 100, (float) 1.0);
					
					p.sendMessage(Main.PREFIX + " Du hast nicht genügend Berechtigung!");
					
				}
			
			} else if(args[0].equals("setspawn")) {
				
				if(p.hasPermission("lobby.*") || p.hasPermission("lobby.setspawn") || p.isOp()) {
					
					Location loc = p.getLocation();
					Sound sound = Sound.LEVEL_UP;
					p.playSound(loc, sound, 100, (float) 1.0);
					
					p.sendMessage(Main.PREFIX + " Du hast den Spawnpunkt gesetzt!");
					
					config.set("Spawn.World", p.getWorld().getName());
					config.set("Spawn.X", p.getLocation().getX());
					config.set("Spawn.Y", p.getLocation().getY());
					config.set("Spawn.Z", p.getLocation().getZ());
					config.set("Spawn.Yaw", p.getLocation().getYaw());
					config.set("Spawn.Pitch", p.getLocation().getPitch());
					Main.getPlugin().saveConfig();
					
				} else {
					
					Location loc = p.getLocation();
					Sound sound = Sound.NOTE_BASS;
					p.playSound(loc, sound, 100, (float) 1.0);
					
					p.sendMessage(Main.PREFIX + " Du hast nicht genügend Berechtigung!");
					
				}
				
			} else if(args[0].equals("setwarp")) {
				
				if(p.hasPermission("lobby.*") || p.hasPermission("lobby.setwarp") || p.isOp()) {
					
					if(args.length == 2) {
						
						config.set(args[1].toString() + ".World", p.getWorld().getName());
						config.set(args[1].toString() + ".X", p.getLocation().getX());
						config.set(args[1].toString() + ".Y", p.getLocation().getY());
						config.set(args[1].toString() + ".Z", p.getLocation().getZ());
						config.set(args[1].toString() + ".Yaw", p.getLocation().getYaw());
						config.set(args[1].toString() + ".Pitch", p.getLocation().getPitch());
						
						config.set(args[1].toString() + ".Item", "dirt");
						config.set(args[1].toString() + ".Name", "Hello :)");
						config.set(args[1].toString() + ".Slot", 0);
						
						Main.getPlugin().saveConfig();
						
						p.sendMessage(Main.PREFIX + " Der Warp §c" + args[1].toString() + " §7wurde gesetzt!");
						
						Location loc = p.getLocation();
						Sound sound = Sound.LEVEL_UP;
						p.playSound(loc, sound, 100, (float) 1.0);
						
					} else if(args.length == 3) {
						
						config.set(args[1].toString() + ".World", p.getWorld().getName());
						config.set(args[1].toString() + ".X", p.getLocation().getX());
						config.set(args[1].toString() + ".Y", p.getLocation().getY());
						config.set(args[1].toString() + ".Z", p.getLocation().getZ());
						config.set(args[1].toString() + ".Yaw", p.getLocation().getYaw());
						config.set(args[1].toString() + ".Pitch", p.getLocation().getPitch());
						
						config.set(args[1].toString() + ".Item", args[2].toString());
						config.set(args[1].toString() + ".Name", "Hello :)");
						config.set(args[1].toString() + ".Slot", 0);
						
						Main.getPlugin().saveConfig();
						
						p.sendMessage(Main.PREFIX + " Der Warp §c" + args[1] + " §7wurde gesetzt!");
						
						Location loc = p.getLocation();
						Sound sound = Sound.LEVEL_UP;
						p.playSound(loc, sound, 100, (float) 1.0);

					} else if(args.length == 4) {
						
						config.set(args[1].toString() + ".World", p.getWorld().getName());
						config.set(args[1].toString() + ".X", p.getLocation().getX());
						config.set(args[1].toString() + ".Y", p.getLocation().getY());
						config.set(args[1].toString() + ".Z", p.getLocation().getZ());
						config.set(args[1].toString() + ".Yaw", p.getLocation().getYaw());
						config.set(args[1].toString() + ".Pitch", p.getLocation().getPitch());
						
						String name = args[3].replaceAll("&", "§");
						
						config.set(args[1].toString() + ".Item", args[2].toString());
						config.set(args[1].toString() + ".Name", name);
						config.set(args[1].toString() + ".Slot", 0);
						
						Main.getPlugin().saveConfig();
						
						p.sendMessage(Main.PREFIX + " Der Warp §c" + args[1] + " §7wurde gesetzt!");
						
						Location loc = p.getLocation();
						Sound sound = Sound.LEVEL_UP;
						p.playSound(loc, sound, 100, (float) 1.0);

					} else if(args.length == 5) {
						
						config.set(args[1].toString() + ".World", p.getWorld().getName());
						config.set(args[1].toString() + ".X", p.getLocation().getX());
						config.set(args[1].toString() + ".Y", p.getLocation().getY());
						config.set(args[1].toString() + ".Z", p.getLocation().getZ());
						config.set(args[1].toString() + ".Yaw", p.getLocation().getYaw());
						config.set(args[1].toString() + ".Pitch", p.getLocation().getPitch());
						
						String name = args[3].replaceAll("&", "§");
						
						config.set(args[1].toString() + ".Item", args[2].toString());
						config.set(args[1].toString() + ".Name", name);
						config.set(args[1].toString() + ".Slot", Integer.valueOf(args[4]));
						
						Main.getPlugin().saveConfig();
						
						p.sendMessage(Main.PREFIX + " Der Warp §c" + args[1] + " §7wurde gesetzt!");
						
						Location loc = p.getLocation();
						Sound sound = Sound.LEVEL_UP;
						p.playSound(loc, sound, 100, (float) 1.0);

					} else {
						
						Location loc = p.getLocation();
						Sound sound = Sound.NOTE_BASS;
						p.playSound(loc, sound, 100, (float) 1.0);
						
						p.sendMessage(Main.PREFIX + " Bitte nenne einen Warp! /system setwarp <Warp>");
						
					}
					
				} else {
					
					Location loc = p.getLocation();
					Sound sound = Sound.NOTE_BASS;
					p.playSound(loc, sound, 100, (float) 1.0);
					
					p.sendMessage(Main.PREFIX + " Du hast nicht genügend Berechtigung!");
					
				}
				
			} else if(args[0].equals("removewarp")) {
				
				if(p.hasPermission("lobby.*") || p.hasPermission("lobby.removewarp") || p.isOp()) {
					
					if(args.length == 2) {
						
						if(config.contains(args[1].toString() + ".World")) {
							
							config.set(args[1].toString() + ".World", null);
							config.set(args[1].toString() + ".X", null);
							config.set(args[1].toString() + ".Y", null);
							config.set(args[1].toString() + ".Z", null);
							config.set(args[1].toString() + ".Yaw", null);
							config.set(args[1].toString() + ".Pitch", null);
							
							config.set(args[1].toString() + ".Item", null);
							config.set(args[1].toString() + ".Name", null);
							config.set(args[1].toString() + ".Slot", null);
							config.set(args[1].toString(), null);
							
							Main.getPlugin().saveConfig();
							
							p.sendMessage(Main.PREFIX + " Der Warp §c" + args[1] + " §7wurde entfernt!");
							
							Location loc = p.getLocation();
							Sound sound = Sound.LEVEL_UP;
							p.playSound(loc, sound, 100, (float) 1.0);
							
						} else {
							
							Location loc = p.getLocation();
							Sound sound = Sound.NOTE_BASS;
							p.playSound(loc, sound, 100, (float) 1.0);
							
							p.sendMessage(Main.PREFIX + " Dieser Warp existiert nicht!");
							
						}
						
					} else {
						
						Location loc = p.getLocation();
						Sound sound = Sound.NOTE_BASS;
						p.playSound(loc, sound, 100, (float) 1.0);
						
						p.sendMessage(Main.PREFIX + " Du hast nicht genügend Berechtigung!");
						
					}
					
				} else {
					
					Location loc = p.getLocation();
					Sound sound = Sound.NOTE_BASS;
					p.playSound(loc, sound, 100, (float) 1.0);
					
					p.sendMessage(Main.PREFIX + " Bitte nenne einen Warp! /system removewarp <Warp>");
					
				}
				
			} else if(args[0].equals("infowarp")) {
				
				if(args.length == 2) {
					
					if(config.getString(args[1] + ".Name") != null) {
				
						Location loc = p.getLocation();
						Sound sound = Sound.LEVEL_UP;
						p.playSound(loc, sound, 100, (float) 1.0);
				
						p.sendMessage(Main.PREFIX + " §7Infos von Warp §c" + args[1] + "\n"
						+ " §7Item: §c" + config.getString(args[1] + ".Item") + "\n"
						+ " §7Name: §c" + config.getString(args[1] + ".Name") + "\n"
						+ " §7Slot: §c" + config.getString(args[1] + ".Slot") + "\n");
				
					} else {
						
						Location loc = p.getLocation();
						Sound sound = Sound.NOTE_BASS;
						p.playSound(loc, sound, 100, (float) 1.0);
						
						p.sendMessage(Main.PREFIX + " Dieser Warp existiert nicht!");
						
					}
				
				} else {
					
					Location loc = p.getLocation();
					Sound sound = Sound.NOTE_BASS;
					p.playSound(loc, sound, 100, (float) 1.0);
					
					p.sendMessage(Main.PREFIX + " Bitte nenne einen Warp! /system infowarp <Warp>");
					
				}
				
			} else {
				
				Location loc = p.getLocation();
				Sound sound = Sound.NOTE_BASS;
				p.playSound(loc, sound, 100, (float) 1.0);
				
				p.sendMessage(Main.PREFIX + " Der Befehl wurde nicht gefunden!");
				
			}
			
		}
		return false;
	}

}