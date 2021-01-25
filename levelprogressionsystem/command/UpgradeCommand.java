package com.ro11enteam.levelprogressionsystem.command;

import com.ro11enteam.levelprogressionsystem.LevelProgressionSystem;
import com.ro11enteam.levelprogressionsystem.points.PlayerAccount;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class UpgradeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if ( !(sender instanceof Player) ) {
            return false;
        }

        String topic = args[0];
        Player player = (Player) sender;
        PlayerAccount pa = LevelProgressionSystem.accounts.get(player);
        int level = player.getLevel();

        int playerLevel;
        switch (topic) {
            case "mining":;
                playerLevel = pa.mining;
                break;
            case "harvesting":
                playerLevel = pa.harvesting;
                break;
            case "defense":
                playerLevel = pa.defense;
                break;
            case "attack":
                playerLevel = pa.attack;
                break;
            case "magic":
                playerLevel = pa.magic;
                break;
            default:
                sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Skill not Recognized, please input a correct skill");
                return false;

        }

        int levelsNeeded = LevelProgressionSystem.prices.get(topic).get(playerLevel);

        if ( level < levelsNeeded ) {

            player.setLevel( level - levelsNeeded );
            pa.setLevel(topic, playerLevel + 1);

            sender.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Skill " + topic.toUpperCase() + " upgraded.");

        } else {
            sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You do not have enough levels! Please collect " + LevelProgressionSystem.prices.get(topic).get(playerLevel) + " levels to upgrade.");
            return false;
        }

        return true;
    }

}
