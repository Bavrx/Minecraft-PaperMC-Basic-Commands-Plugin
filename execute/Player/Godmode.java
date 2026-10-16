package dev.Bavrx.firstPlugin.execute.Player;

import dev.Bavrx.firstPlugin.PlayerCommand;
import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Godmode extends PlayerCommand {

    @Override
    protected void executePlayer(Player player, String[] args) {

        if (args.length == 0)
        {
            if (player.isInvulnerable())
            {
                player.setInvulnerable(false);
                player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Godmode<red><bold> disabled</bold></red>!"));
            }
            else
            {
                player.setInvulnerable(true);
                player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Godmode<green><bold> enabled</bold></green>!"));
            }
        }

        if (args.length == 1)
        {
            Player target = Bukkit.getPlayerExact(args[0]);

            if (target == null)
            {
                player.sendMessage(MiniMessage.miniMessage().deserialize("<red>Player not found!"));
                return;
            }

            if (target.isInvisible())
            {
                target.setInvulnerable(false);
                target.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Godmode<red><bold> disabled</bold></red>!"));
                player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>You disabled godmode</gray> " + target.getName()));
            }
            else
            {
                target.setInvulnerable(true);
                target.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Godmode<green><bold> enabled</bold></green>!"));
                player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>You enabled godmode</gray> " + target.getName()));
            }

        }
    }
}
