package dev.Bavrx.firstPlugin.Layer0;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class WorldProtector implements Listener {
    @EventHandler
    public void onBreak (BlockBreakEvent event) throws InterruptedException {
        event.setCancelled(true);
        Player player = event.getPlayer();
        Block block = event.getBlock();
        player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>You are not<red><bold> authorized </bold></red>to do that!"));
        Thread.sleep(1000);
        player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>You are being kicked in<red><bold> 5 sec </bold></red>for <red><bold>security</bold></red> reasons.!"));
        Thread.sleep(1000);

        for (int i = 5; i > 0; i--)
        {
            player.sendMessage(MiniMessage.miniMessage().deserialize("<red><bold>" + String.valueOf(i) + "</bold></red>"));
            Thread.sleep(1000);
        }

        player.sendMessage(MiniMessage.miniMessage().deserialize("<red><bold>Bye Bye"));
        Thread.sleep(1000);

        player.kick();
    }
}
