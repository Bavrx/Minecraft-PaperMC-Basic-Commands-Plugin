package dev.Bavrx.firstPlugin.execute.Player;

import dev.Bavrx.firstPlugin.PlayerCommand;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Vanish extends PlayerCommand {

    @Override
    protected void executePlayer(Player player, String[] args) {

        if (args.length == 0)
        {
            if (player.isInvisible())
            {
                player.setInvisible(false);
                player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Vanish<red><bold> disabled</bold></red>!"));
            }
            else
            {
                player.setInvisible(true);
                player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Vanish<green><bold> enabled</bold></green>!"));
                return;
            }
        }

        if (args.length == 1)
        {

            Player target = Bukkit.getPlayerExact(args[0]);

            if (target == null) {
                player.sendMessage(MiniMessage.miniMessage().deserialize("<red>Player not found!"));
                return;
            }

            if (target.isInvisible())
            {
                target.setInvisible(false);
                target.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Vanish<red><bold> disabled</bold></red>!"));
                player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>You disabled vanish</gray> " + target.getName()));
            }
            else
            {
                target.setInvisible(true);
                target.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Vanish<green><bold> enabled</bold></green>!"));
                player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>You enabled vanish</gray> " + target.getName()));
                return;
            }
            return;
        }

    }
}
