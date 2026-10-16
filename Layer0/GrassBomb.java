package dev.Bavrx.firstPlugin.Layer0;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.awt.*;

public class GrassBomb implements Listener {
    @EventHandler
    public void onBreake (BlockBreakEvent event){
        Player player = event.getPlayer();
        Material material = event.getBlock().getType();
        Block block = event.getBlock();

        if(block.getType() == Material.GRASS_BLOCK)
        {
            Location location = block.getLocation();
            block.setType(Material.AIR);
            TNTPrimed tnt = block.getWorld().spawn(location, TNTPrimed.class);
            tnt.setFuseTicks(10);
        }

        /*
        if (material == Material.GRASS_BLOCK) {
            event.getBlock().getWorld().createExplosion(
                    event.getBlock().getLocation(),
                    4.0f,
                    false,
                    true
            );
        }
         */

    }

}
