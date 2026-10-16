package dev.Bavrx.firstPlugin.execute.Player;

import dev.Bavrx.firstPlugin.PlayerCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.List;

public class WalkSpeed extends PlayerCommand {
    @Override
    protected void executePlayer(Player player, String[] args) {



        if (args.length == 0)
        {
            player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Use: /walkspeed</gray> <0-1 | normal>"));
            return;
        }

        if (args[0].equalsIgnoreCase("normal"))
        {
            player.setWalkSpeed(0.2f);
            player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Walkspeed has been reset."));
            return;
        }

        try
        {
            float speed = Float.parseFloat(args[0]);

            if (speed < 0 || speed > 1)
            {
                player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>The speed must be between</gray> 0 <gray>and</gray> 1<gray>."));
                return;
            }

            player.setWalkSpeed(speed);
            player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Walkspeed is now</gray> " + speed));

        }

        catch (NumberFormatException e)
        {
            player.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Please enter a</gray> number <gray>or</gray> 'normal'<gray>."));
        }
    }

    public Collection<String> suggest(CommandSourceStack source, String[] args) {

        if (args.length == 1) {
            return List.of("normal", "0.1", "0.5", "1");
        }

        return List.of();
    }

}
