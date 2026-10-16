package dev.Bavrx.firstPlugin.listeners;

import net.kyori.adventure.sound.Sound;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.eclipse.sisu.Nullable;

public class ConnectionListener implements Listener {

    @EventHandler
    public void onJoin (PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.joinMessage(Component.text("Wilkommen in MB MC Studios!")
                .color(NamedTextColor.RED));


    }

}
