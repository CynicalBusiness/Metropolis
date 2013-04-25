package net.mayateck;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

@SuppressWarnings("unused")
public class MetropolisPlayerListener implements Listener {

	private final Metropolis plugin;
	
	public MetropolisPlayerListener (Metropolis instance){
		plugin = instance;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event){
		
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event){
		
	}
}
