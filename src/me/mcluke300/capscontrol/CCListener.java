package me.mcluke300.capscontrol;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CCListener implements Listener {
	CapsControl plugin;



	@EventHandler
	public void onPlayerEvent(PlayerChatEvent e) {
		Player player = e.getPlayer();

		if (!player.hasPermission("capscontrol.bypass")) {
			int min = plugin.getConfig().getInt("CapChecker.MinimumCharacterCount"); 
			String msg = e.getMessage();

			if (msg.length() >= min) {
				int up = 0;
				int down = 0;
				for(int i=0; i<msg.length(); i++) {
					char character = msg.charAt(i);

					if (Character.isLetter(character)) {

						if (Character.isUpperCase(character))
							up += 1;
						else {
							down += 1;

						}}

				}
				if (down + up != 0) {
					double Percent = 1. * up / (up+down) * 100.0D;
					int configpercent = plugin.getConfig().getInt("CapChecker.Percent");
					if (Percent > configpercent) {
						e.setMessage(e.getMessage().toLowerCase());
						String result = plugin.getConfig().getString("CapsControl.Message");
						result = result.replaceAll("&([0-9a-fA-F])", "§$1");
						player.sendMessage(result);
					}
				}
			}
		}
	}



	@EventHandler
	public void onPlayerEvent(PlayerCommandPreprocessEvent e) {
		Player player = e.getPlayer();

		if (plugin.getConfig().getBoolean("CapChecker.CheckCommands") == true) {
			if (!player.hasPermission("capscontrol.bypass")) {
				int min = plugin.getConfig().getInt("CapChecker.MinimumCharacterCount"); 
				String msg = e.getMessage();

				if (msg.length() >= min) {
					int up = 0;
					int down = 0;
					for(int i=0; i<msg.length(); i++) {
						char character = msg.charAt(i);

						if (Character.isLetter(character)) {

							if (Character.isUpperCase(character))
								up += 1;
							else {
								down += 1;

							}}

					}
					if (down + up != 0) {
						double Percent = 1. * up / (up+down) * 100.0D;
						int configpercent = plugin.getConfig().getInt("CapChecker.Percent");
						if (Percent > configpercent) {
							e.setMessage(e.getMessage().toLowerCase());
							String result = plugin.getConfig().getString("CapsControl.Message");
							result = result.replaceAll("&([0-9a-fA-F])", "§$1");
							player.sendMessage(result);
						}
					}
				}
			}
		}
	}
}








