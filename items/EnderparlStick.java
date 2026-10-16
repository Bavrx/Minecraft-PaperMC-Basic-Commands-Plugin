package dev.Bavrx.firstPlugin.items;

import dev.Bavrx.firstPlugin.PlayerCommand;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EnderparlStick extends PlayerCommand {

    @Override
    protected void executePlayer(Player player, String[] args) {
        ItemStack wand = new ItemStack(Material.BLAZE_ROD);
        ItemMeta meta = wand.getItemMeta();
    }


}
