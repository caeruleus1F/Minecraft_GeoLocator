package com.gbates31.minecraft_geolocator;

import java.net.MalformedURLException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
	String location;
	
	public PlayerJoin () {
		
	}
	
	@EventHandler
	public void playerJoined (PlayerJoinEvent evt) throws MalformedURLException {
		String IPAddress = evt.getPlayer().getAddress().getAddress().getHostAddress();
		Runnable task = new EndpointInterfacer (IPAddress, evt.getPlayer().getDisplayName());
		Thread worker = new Thread (task);
		
		//if (!IPAddress.contains("192.168.") && !IPAddress.contains("127.0.0.1")) {
			worker.start();
		//}
	}
}
