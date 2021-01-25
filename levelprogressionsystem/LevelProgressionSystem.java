package com.ro11enteam.levelprogressionsystem;

import com.ro11enteam.levelprogressionsystem.points.PlayerAccount;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public final class LevelProgressionSystem extends JavaPlugin {

    public static HashMap<Player, PlayerAccount> accounts = new HashMap<>();

    public static HashMap<String, List<Integer>> prices = new HashMap<>();

    @Override
    public void onEnable() {

        loadPrices();
        try {
            loadAccounts();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onDisable() {
        try {
            saveAccounts();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveAccounts () throws IOException {

        YamlConfiguration c = new YamlConfiguration();

        for (Player key : accounts.keySet()) {

            PlayerAccount pa = accounts.get(key);

            c.set(key.getUniqueId() + ".mining", pa.mining);
            c.set(key.getUniqueId() + ".harvesting", pa.harvesting);
            c.set(key.getUniqueId() + ".defense", pa.defense);
            c.set(key.getUniqueId() + ".attack", pa.attack);
            c.set(key.getUniqueId() + ".magic", pa.magic);

        }

        c.save( new File( getDataFolder(), "accounts.yml"));

    }

    public void loadAccounts () throws IOException, InvalidConfigurationException {

        YamlConfiguration c = new YamlConfiguration();

        File file = new File(getDataFolder() + "accounts.yml");

        if (Files.exists( file.toPath() )) {
            c.load(file);

            Set<String> playerList = c.getKeys(false);

            for (String player : playerList) {

                UUID id;
                Player playerObj = Bukkit.getPlayer(UUID.fromString(player));

                int mining = c.getInt(player + ".mining");
                int harvesting = c.getInt(player + ".harvesting");
                int defense = c.getInt(player + ".defense");
                int attack = c.getInt(player + ".attack");
                int magic = c.getInt(player + ".magic");

                PlayerAccount pa = new PlayerAccount(mining, harvesting, defense, attack, magic);

                accounts.put(playerObj, pa);

            }
        }

    }

    public void loadPrices () {

        List<Integer> miningPrices    = Arrays.asList( 10, 30, 80, 90 );
        List<Integer> harvesterPrices = Arrays.asList( 10, 30, 80, 90 );
        List<Integer> defensePrices   = Arrays.asList( 15, 40, 100, 120 );
        List<Integer> attackPrices    = Arrays.asList( 15, 40, 100, 120 );
        List<Integer> magicPrices     = Arrays.asList( 10, 30, 80, 90 );

        prices.put("mining",  miningPrices);
        prices.put("harvesting", harvesterPrices);
        prices.put("defense", defensePrices);
        prices.put("attack",  attackPrices);
        prices.put("magic",   magicPrices);

    }

    public static HashMap<String, List<Integer>> getPrices() {
        return prices;
    }
}
