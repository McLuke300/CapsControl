package me.mcluke300.capscontrol;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CapsControl extends JavaPlugin{


	@Override
	public void onEnable() {
		LoadConfiguration();
		System.out.println(this+" has been Enabled");
		Bukkit.getServer().getPluginManager().registerEvents(new CCListener(), this);
	}


	@Override
	public void onDisable() {
		System.out.println(this+" has been Disabled");
	}



	public void LoadConfiguration() {
		String path = "CapsControl.ConvertToLowerCase";
		String path2 = "CapsControl.Message";
		String path3 = "CapChecker.MinimumCharacterCount";
		String path4 = "CapChecker.Percent";
		String path5 = "CapChecker.CheckCommands";
		getConfig().addDefault(path, true);
		getConfig().addDefault(path2, "&6Do not use all caps!");
		getConfig().addDefault(path3, 6);
		getConfig().addDefault(path4, 60);
		getConfig().addDefault(path5, true);
		getConfig().options().copyDefaults(true);
		saveConfig();
	}





	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		boolean op = false;
		if ((sender instanceof Player)) {
			Player player = (Player)sender;
			op = player.isOp();
		}
		if ((commandLabel.equalsIgnoreCase("CapsControl"))) {
			if (args.length == 1 && args[0].equalsIgnoreCase("reload") || (op)) {
				if(sender.hasPermission("capscontrol.reload")) {
					reloadConfig();
					sender.sendMessage(ChatColor.AQUA+"CapsControl Config Reloaded");
				}
			}
			return false;
		}
		return false;
	}
}

