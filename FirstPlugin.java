package dev.Bavrx.firstPlugin;

import dev.Bavrx.firstPlugin.Layer0.GrassBomb;
import dev.Bavrx.firstPlugin.Layer0.WorldProtector;
import dev.Bavrx.firstPlugin.execute.Player.*;
import dev.Bavrx.firstPlugin.execute.Player.Fly;
import dev.Bavrx.firstPlugin.execute.Player.Heal;
import dev.Bavrx.firstPlugin.execute.Player.WalkSpeed;
import dev.Bavrx.firstPlugin.listeners.ConnectionListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class FirstPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        IO.println("--------------------------------\n" +
                   "|  Plugin from Bavrx Enabled!  |\n" +
                   "--------------------------------");
        getServer().getPluginManager().registerEvents(new ConnectionListener(),this);
        // getServer().getPluginManager().registerEvents(new WorldProtector(),this);
        getServer().getPluginManager().registerEvents(new GrassBomb(),this);

        registerCommand("heal", new Heal());

        registerCommand("fly", new Fly());

        registerCommand("godmode", new Godmode());

        registerCommand("vanish", new Vanish());

        registerCommand("helpy", new Help());

        registerCommand("walkspeed", new WalkSpeed());

        registerCommand("potion clear", new PotionClear());

        registerCommand("freez", new Freez());

        registerCommand("unfreez", new UnFreez());

        /*
        BasicCommand testerCommand = new Tester();
        registerCommand("devC", testerCommand);
         */

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        IO.println("--------------------------------\n" +
                   "|  Plugin from Bavrx Disabled!  |\n" +
                   "--------------------------------");
    }
}
