package safeluren.mcpl.roll;

import org.bukkit.plugin.java.JavaPlugin;
import safeluren.mcpl.roll.Command.roll;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("—————————————————————");
        System.out.println("RollPoint plugins has been loaded");
        System.out.println("Author: Bilibili@平安路人Official");
        System.out.println("—————————————————————");

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getCommand("roll").setExecutor(new roll());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
