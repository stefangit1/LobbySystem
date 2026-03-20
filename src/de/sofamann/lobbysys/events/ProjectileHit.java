package de.sofamann.lobbysys.events;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ProjectileHit implements Listener {
	
	@EventHandler
	public void onHit(ProjectileHitEvent e) {
		
		Player p = (Player) e.getEntity().getShooter();
		
		Location loc = p.getLocation();
		Sound sound = Sound.EXPLODE;
		p.playSound(loc, sound, 100, (float) 1.0);
		
		e.getEntity().remove();
		p.playEffect(e.getEntity().getLocation(), Effect.EXPLOSION_HUGE, null);
		
	}

}