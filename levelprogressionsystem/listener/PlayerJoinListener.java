package com.ro11enteam.levelprogressionsystem.listener;

import com.ro11enteam.levelprogressionsystem.LevelProgressionSystem;
import com.ro11enteam.levelprogressionsystem.points.PlayerAccount;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin (PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if ( !(LevelProgressionSystem.accounts.containsKey(player)) ) {
            LevelProgressionSystem.accounts.put(player, new PlayerAccount());
            player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "New Player Account Created!");
        }
    }

}
