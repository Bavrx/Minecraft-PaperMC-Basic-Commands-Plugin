package dev.Bavrx.firstPlugin.execute.Player;

import dev.Bavrx.firstPlugin.PlayerCommand;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Freez extends PlayerCommand {
    @Override
    protected void executePlayer(Player player, String[] args) {
        Location loc = player.getLocation();


        // boden
        loc.clone().add(0, -1, 0).getBlock().setType(Material.BARRIER);

        // decke
        loc.clone().add(0, 2, 0).getBlock().setType(Material.BARRIER);

        //x
        loc.clone().add(1, 0, 0).getBlock().setType(Material.BARRIER);
        loc.clone().add(-1, 0, 0).getBlock().setType(Material.BARRIER);
        loc.clone().add(1, 1, 0).getBlock().setType(Material.BARRIER);
        loc.clone().add(-1, 1, 0).getBlock().setType(Material.BARRIER);

        //y
        loc.clone().add(0, 0, 1).getBlock().setType(Material.BARRIER);
        loc.clone().add(0, 0, -1).getBlock().setType(Material.BARRIER);
        loc.clone().add(0, 1, 1).getBlock().setType(Material.BARRIER);
        loc.clone().add(0, 1, -1).getBlock().setType(Material.BARRIER);


    }
}
