package me.sintaxlabs.bombasticProjectiles121x.listeners;

import me.sintaxlabs.bombasticProjectiles121x.EPmain;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;

import static org.bukkit.Bukkit.getServer;

//Projectile Check Order
//----------------------
//Arrow
//Egg
//EnderPearl
//ExpBottle
//FishingBobber
//Potion
//Snowball
//Trident
//----------------------

public class launchCheck implements Listener
{

    public static class launchGlobal
    {
        public static boolean playerShotItem;
        public static boolean mobShotItem;
        public static boolean permProjectiles;
        public static boolean permBreakBlocks;
        public static boolean permHarmPlayers;
        public static boolean permHarmMobs;
    }
    @EventHandler
    public void projectileLaunchCheck (ProjectileLaunchEvent e)
    {
        launchGlobal.mobShotItem = false;
        launchGlobal.playerShotItem = false;
        var object = e.getEntity();
        var shooter = object.getShooter();
        if (shooter instanceof Player)
        {
            Player player = ((Player) shooter).getPlayer();

            if (player.hasPermission("bombasticProjectiles.projectiles"))
            {
                launchGlobal.permProjectiles = true;
            }
            if (player.hasPermission("bombasticProjectiles.breakBlocks"))
            {
                launchGlobal.permBreakBlocks = true;
            }
            if (player.hasPermission("bombasticProjectiles.harmPlayers"))
            {
                launchGlobal.permHarmPlayers = true;
            }
            if (player.hasPermission("bombasticProjectiles.harmMobs"))
            {
                launchGlobal.permHarmMobs = true;
            }
            else
            {
                if (EPmain.Global.configToggleRequirePermission)
                {
                    if (EPmain.Global.configToggleVerbose)
                    {
                        player.sendMessage(Component.text("BombasticProjectiles - You don't have any permission enabled despite requiring permission.", NamedTextColor.RED));
                    }
                    return;
                }
            }
        }

        if (e.getEntity().getShooter() instanceof Player)
        {
            //Arrow CHECK ----------------------------------------------------------
            if (e.getEntity() instanceof Arrow)
            {
                if (EPmain.Global.configToggleVerbose)
                {getServer().sendMessage(Component.text("Player shot Arrow.", NamedTextColor.GREEN));}
                launchGlobal.playerShotItem = true;
            }

            //Egg CHECK ----------------------------------------------------------
            else if (e.getEntity() instanceof Egg)
            {
                if (EPmain.Global.configToggleVerbose)
                {getServer().sendMessage(Component.text("Player tossed Egg.", NamedTextColor.GREEN));}
                launchGlobal.playerShotItem = true;
            }

            //EnderPearl CHECK ----------------------------------------------------------
            else if (e.getEntity() instanceof EnderPearl)
            {
                if (EPmain.Global.configToggleVerbose)
                {getServer().sendMessage(Component.text("Player chucked Enderpearl.", NamedTextColor.GREEN));}
                launchGlobal.playerShotItem = true;
            }

            //ExpBottle CHECK ----------------------------------------------------------
            else if (e.getEntity() instanceof ThrownExpBottle)
            {
                if (EPmain.Global.configToggleVerbose)
                {getServer().sendMessage(Component.text("Player threw ExpBottle.", NamedTextColor.GREEN));}
                launchGlobal.playerShotItem = true;
            }

            //FishingBobber CHECK ----------------------------------------------------------
            else if (e.getEntity() instanceof FishHook)
            {
                if (EPmain.Global.configToggleVerbose)
                {getServer().sendMessage(Component.text("Player swung fishing hook.", NamedTextColor.GREEN));}
                launchGlobal.playerShotItem = true;
            }

            //Potion CHECK ----------------------------------------------------------
            else if (e.getEntity() instanceof ThrownPotion)
            {
                if (EPmain.Global.configToggleVerbose)
                {getServer().sendMessage(Component.text("Player lunged Potion.", NamedTextColor.GREEN));}
                launchGlobal.playerShotItem = true;
            }

            //Snowball CHECK ----------------------------------------------------------
            else if (e.getEntity() instanceof Snowball)
            {
                if (EPmain.Global.configToggleVerbose)
                {getServer().sendMessage(Component.text("Player tossed Snowball.", NamedTextColor.GREEN));}
                launchGlobal.playerShotItem = true;
            }

            //Trident CHECK ----------------------------------------------------------
            else if (e.getEntity() instanceof Trident)
            {
                if (EPmain.Global.configToggleVerbose)
                {getServer().sendMessage(Component.text("Player chucked Trident.", NamedTextColor.GREEN));}
                launchGlobal.playerShotItem = true;
            }
        }
        else
        {
            launchGlobal.mobShotItem = true;
        }
    }
}
