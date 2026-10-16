package dev.Bavrx.firstPlugin.execute.Player;

import dev.Bavrx.firstPlugin.PlayerCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.attribute.Attribute;

import java.util.Collection;
import java.util.List;
// extands PlayerCommand heißt das ich mir die eigenschafen von der Klasse PlayerCommand hole und hier vererbe so muss ich nicht immer copy and pasten
public class Heal extends PlayerCommand {

    @Override
    protected void executePlayer(Player player, String[] args) {

        // /heal
        if (args.length == 0) {

            double maxHealth =
                    player.getAttribute(Attribute.MAX_HEALTH).getValue();

            player.setHealth(maxHealth);
            player.setFoodLevel(20);
            player.setSaturation(20);

            player.sendMessage(
                    MiniMessage.miniMessage().deserialize("<gray>You have been <green><bold>healed</bold></green>!"));

            return;
        }


        // /heal <spieler>
        if (args.length == 1) {

            Player target = Bukkit.getPlayerExact(args[0]);

            if (target == null) {
                player.sendMessage(
                        MiniMessage.miniMessage().deserialize("<red>Player not found!"));
                return;
            }

            double targetMaxHealth =
                    target.getAttribute(Attribute.MAX_HEALTH).getValue();

            target.setHealth(targetMaxHealth);
            target.setFoodLevel(20);
            target.setSaturation(20);

            target.sendMessage(
                    MiniMessage.miniMessage().deserialize("<gray>You have been <green><bold>healed</bold></green>!"));

            target.sendMessage(
                    MiniMessage.miniMessage().deserialize("<gray>You healed</gray> " + target.getName()));

            return;
        }


        // /heal Steve irgendwas
        player.sendMessage(
                MiniMessage.miniMessage().deserialize("<gray>Use: /heal</gray> [player]"));
    }



    @Override
    public Collection<String> suggest(CommandSourceStack source, String[] args) {

        if (args.length == 0) {
            return Bukkit.getOnlinePlayers().stream()
                    .map(Player::getName)
                    .filter(name -> name.toLowerCase().startsWith(args[0].toLowerCase()))
                    .toList();
        }

        return List.of();
    }
}
