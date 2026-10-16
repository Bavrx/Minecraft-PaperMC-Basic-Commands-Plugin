package dev.Bavrx.firstPlugin.execute.Player;

import dev.Bavrx.firstPlugin.PlayerCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.List;

public class Fly extends PlayerCommand {
    @Override
    protected void executePlayer(Player player, String[] args) {

        if(args.length == 0)
        {
            if (player.getAllowFlight())
            {
                player.setFlying(false);
                player.setAllowFlight(false);
                player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Fly<red><bold> disabled</bold></red>!"));
            }
            else
            {
                player.setAllowFlight(true);
                player.setFlying(true);
                player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Fly<green><bold> enabled!</bold></green>!"));
            }
            return;
        }

        if(!args[0].equalsIgnoreCase("speed"))
        {
            player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Use: /fly</gray> speed <0-1 | normal | player>"));
            return;
        }

        if (args[1].equalsIgnoreCase("normal"))
        {
            player.getFlySpeed();
            player.setFlySpeed(0.1f);
            player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Fly Speed has been reset."));
            return;
        }
        try
        {
            float speed = Float.parseFloat(args[1]);

            if (speed < 0 || speed > 1)
            {
                player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>The speed must be between</gray> 0 <gray>and</gray> 1<gray>."));
                return;
            }

            player.setFlySpeed(speed);
            player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Fly Speed is now</gray> " + speed));

        }
        catch (NumberFormatException e)
        {
            player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Please enter a</gray> number <gray>or</gray> 'normal'<gray>."));
        }


    }

    @Override
    public Collection<String> suggest(CommandSourceStack source, String[] args) {

        if (args.length == 0) {
            return List.of("speed", "0.1", "0.5", "1");
        }

        if (args.length == 1 && args[0].equalsIgnoreCase("speed")) {
            return List.of("normal", "0.1", "0.5", "1").stream()
                    .filter(s -> s.startsWith(args[1].toLowerCase()))
                    .toList();
        }

        return List.of();
    }
}
