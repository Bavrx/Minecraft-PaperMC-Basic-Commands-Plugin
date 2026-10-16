package dev.Bavrx.firstPlugin;

import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.entity.Player;

public abstract class PlayerCommand implements BasicCommand {

    @Override
    public final void execute(CommandSourceStack source, String[] args) {

        if (!(source.getSender() instanceof Player player)) {
            source.getSender().sendMessage("Only players can use this command!");
            return;
        }

        executePlayer(player, args);
    }

    protected abstract void executePlayer(Player player, String[] args);
}
