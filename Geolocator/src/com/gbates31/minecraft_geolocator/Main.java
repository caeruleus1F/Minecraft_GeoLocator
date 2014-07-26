package com.gbates31.minecraft_geolocator;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	public void onEnable () {
		getLogger().info("Geolocator enabled.");
		Bukkit.getServer().getPluginManager().registerEvents (new PlayerJoin(), this);
	}
	
	public void onDisable () {
		getLogger().info("Geolocator disabled.");
	}

	public boolean onCommand (CommandSender sender, Command cmd, String label, String [] args) {
		
		
		return true;
	}
}

