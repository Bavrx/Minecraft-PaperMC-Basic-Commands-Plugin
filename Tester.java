package dev.Bavrx.firstPlugin;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.security.Permission;

public class Tester implements Listener {
    @EventHandler
    public void onBreak (BlockBreakEvent event) throws InterruptedException {
        event.setCancelled(true);
        Player player = event.getPlayer();
        Block block = event.getBlock();
        player.sendMessage("You are not authorized to do that!");
        Thread.sleep(1000);
        player.sendMessage("You are being kicked in 5sec for security reasons.");
        Thread.sleep(1000);

        for (int i = 5; i > 0; i--)
        {
            player.sendMessage(String.valueOf(i));
            Thread.sleep(1000);
        }

        player.sendMessage("Bye Bye");
        Thread.sleep(1000);

        player.kick();
    }

}
