package dev.Bavrx.firstPlugin;

import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;

public class Help extends PlayerCommand {

    @Override
    protected void executePlayer(Player player, String[] args) {

        player.sendMessage(MiniMessage.miniMessage().deserialize("<bold>All commands:"));
        player.sendMessage("/fly <player | speed> <0-1 | normal | player>");
        player.sendMessage("/godmode");
        player.sendMessage("/heal <player>");
        player.sendMessage("/vanish");
        player.sendMessage("/walkspeed <player | speed | 0-1 | normal | player>");
        player.sendMessage("/potion clear");
        player.sendMessage("/freez");
        player.sendMessage("/unfreez");

    }

}
