package com.ro11enteam.levelprogressionsystem.command;

import com.ro11enteam.levelprogressionsystem.LevelProgressionSystem;
import com.ro11enteam.levelprogressionsystem.points.PlayerAccount;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class SkillsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        PlayerAccount pa;
        try {
            pa = LevelProgressionSystem.accounts.get(player);
        } catch (Exception e) {
            sender.sendMessage(ChatColor.RED + "You do not have a skills account! Please contact a moderator!");
            return false;
        }

        String miningString;
        switch (pa.mining) {
            case 1:
                miningString = "Mining I";
            case 2:
                miningString = "Mining II";
            case 3:
                miningString = "Mining III";
            case 4:
                miningString = "Mining IV";
            default:
                miningString = "ERROR";
        }

        String harvestingString;
        switch (pa.harvesting) {
            case 1:
                harvestingString = "Harvesting I";
            case 2:
                harvestingString = "Harvesting II";
            case 3:
                harvestingString = "Harvesting III";
            case 4:
                harvestingString = "Harvesting IV";
            default:
                harvestingString = "ERROR";
        }

        String defenseString;
        switch (pa.defense) {
            case 1:
                defenseString = "Defense I";
            case 2:
                defenseString = "Defense II";
            case 3:
                defenseString = "Defense III";
            case 4:
                defenseString = "Defense IV";
            default:
                defenseString = "ERROR";
        }

        String attackString;
        switch (pa.attack) {
            case 1:
                attackString = "Attack I";
            case 2:
                attackString = "Attack II";
            case 3:
                attackString = "Attack III";
            case 4:
                attackString = "Attack IV";
            default:
                attackString = "ERROR";
        }

        String magicString;
        switch (pa.magic) {
            case 1:
                magicString = "Magic I";
            case 2:
                magicString = "Magic II";
            case 3:
                magicString = "Magic III";
            case 4:
                magicString = "Magic IV";
            default:
                magicString = "ERROR";
        }

        List<String> messages = new ArrayList<String>();

        messages.add(ChatColor.GRAY + "------------------------------" + ChatColor.GREEN);
        messages.add(ChatColor.GREEN + "" + ChatColor.BOLD + "Current Skills: ");
        messages.add(miningString);
        messages.add(harvestingString);
        messages.add(defenseString);
        messages.add(attackString);
        messages.add(magicString);
        messages.add(ChatColor.GRAY + "------------------------------");

        sender.sendMessage( messages.toArray(new String[0]) );

        return true;
    }
}
