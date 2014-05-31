package me.lorddominayte.admincontrol;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class AdminControl extends JavaPlugin {
	public final Logger logger = Logger.getLogger("Minecraft");
	public static AdminControl plugin;

	@Override
	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " has been disabled");
	}
	
	@Override
	public void onEnable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " version " + pdfFile.getVersion() + " has been enabled");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player player = (Player) sender;
		PluginDescriptionFile pdfFile = this.getDescription();
		if(commandLabel.equalsIgnoreCase("admincontrol")) {
			if(args.length == 0) {
				player.sendMessage(ChatColor.GOLD + pdfFile.getName() + " version " + pdfFile.getVersion() + " is currently running on this server.");
			}
			if(args.length == 1 && args[0] == "heal") {
				player.setHealth(player.getMaxHealth());
				player.sendMessage(ChatColor.GREEN + "You were healed!");
			}
		}
		return false;
	}
}
