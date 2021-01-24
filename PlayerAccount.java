import org.bukkit.entity.Player;

public class PlayerAccount {

    public int mining;
    public int harvesting;
    public int defense;
    public int attack;
    public int magic;

    public PlayerAccount () {
        this.mining = 1;
        this.harvesting = 1;
        this.defense = 1;
        this.attack = 1;
        this.magic = 1;
    }

    public PlayerAccount (int mining, int harvesting, int defense, int attack, int magic) {
        this.mining = mining;
        this.harvesting = harvesting;
        this.defense = defense;
        this.attack = attack;
        this.magic = magic;
    }

}
