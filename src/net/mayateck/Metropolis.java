package net.mayateck;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.command.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")

public final class Metropolis extends JavaPlugin{

	String release = "0"; String verNum = "1.0";
	String ver = "" + verNum + "R0" + release + "";
	
	@Override
	public void onEnable(){
		Logger log = getLogger();
		log.info("1 of 2 | Loading Metropolis files...");
		File cfg = new File(getDataFolder() + File.separator + "config.yml");
		File plyrs = new File(getDataFolder() + File.separator + "players.yml");
		File cities = new File(getDataFolder() + File.separator + "cities.yml");
		
		if (!cfg.exists()){
			log.info("File 'config.yml' not found. Creating one...");
			this.saveConfig();
		}
		log.info("2 of 2 | Preloading data...");
		
		log.info("Loading completed.");
	}
	
	@Override
	public void onDisable(){
		Logger log = getLogger();
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player plyr = (Player) sender;
		String tag = Color.GRAY + "[" + Color.AQUA + "MP" + Color.GRAY + "] " + Color.WHITE;
		String error = tag + Color.RED + "Error: " + Color.WHITE;
		String usage = tag + Color.RED + "Usage: " + Color.WHITE;
		String success = tag + Color.AQUA + "Success! " + Color.WHITE;
		if (cmd.getName().equalsIgnoreCase("city")){
			if (!(sender instanceof Player)){
				sender.sendMessage("This command is only accessable by in-game players.");
			} else {
				if (args[1]=="create"){
					if (args.length > 2){
						sender.sendMessage(error + "Too many arguments provided.");
						sender.sendMessage(usage + "'/city create [name]'");
					} else if (false){ // TODO: Check for valid funds
						sender.sendMessage(error + "Insufficient funds to create city.");
					} else if (false){ // TODO: Check for already existent city
						sender.sendMessage(error + "A city has already claimed this area.");
					} else {
						String name = args[2];
						String createCity = CityHandler.createCity(plyr, name);
						String claim = CityHandler.claim(plyr);
						if (createCity==""){
							sender.sendMessage(success + name + " founded successfully!");
						} else {
							sender.sendMessage(error + createCity);
						}
						if (claim==""){
							Location loc = plyr.getLocation();
							double x = Math.floor(loc.getX()/16);
							double z = Math.floor(loc.getZ()/16);
							sender.sendMessage(tag + "Claimed current chunk. (" + x + "," + z + ")");
						}
						
					}
				} else if(args[1]=="claim") {
					if (args.length > 1){
						sender.sendMessage(error + "Too many arguments provided!");
						sender.sendMessage(usage + "'/city claim'");
					} else if (false){// TODO: Check for valid funds
						
					} else if (false){// TODO: Check for already existent city
						
					} else {
						String name = args[2];
						CityHandler.claim(plyr);
					}
				}
			}
		} else if(cmd.getName().equalsIgnoreCase("mp")){
			
		}
		return true;
	}
}