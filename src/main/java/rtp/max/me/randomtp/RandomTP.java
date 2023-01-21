package rtp.max.me.randomtp;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public class RandomTP extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("rtp").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("rtp")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("This command can only be run by a player.");
                return true;
            }
            Player player = (Player) sender;
            World world = player.getWorld();
            Random random = new Random();
            int x = (int) (random.nextInt((int) (world.getWorldBorder().getSize() / 2)) - (world.getWorldBorder().getSize() / 2));
            int z = (int) (random.nextInt((int) (world.getWorldBorder().getSize() / 2)) - (world.getWorldBorder().getSize() / 2));
            Location randomLocation = new Location(world, x, world.getHighestBlockYAt(x, z), z);
        }
        return false;
    }
}