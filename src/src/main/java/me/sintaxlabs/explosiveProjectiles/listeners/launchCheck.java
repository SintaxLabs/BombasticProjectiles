package me.sintaxlabs.explosiveProjectiles.listeners;

import me.sintaxlabs.explosiveProjectiles.EPmain;
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
        public static boolean permAll;
        public static boolean permProjectiles;
        public static boolean permBreakBlocks;
        public static boolean permHarmPlayers;
        public static boolean permHarmMobs;
    }
    @EventHandler
    public void projectileLaunchCheck (ProjectileLaunchEvent e)
    {

        launchGlobal.playerShotItem = false;
        var object = e.getEntity();
        var shooter = object.getShooter();
        if (shooter instanceof Player)
        {
            Player player = ((Player) shooter).getPlayer();

            if (player.hasPermission("explosiveProjectiles.all"))
            {
                launchGlobal.permAll = true;
            }
            if (player.hasPermission("explosiveProjectiles.projectiles"))
            {
                launchGlobal.permProjectiles = true;
            }
            if (player.hasPermission("explosiveProjectiles.breakBlocks"))
            {
                launchGlobal.permBreakBlocks = true;
            }
            if (player.hasPermission("explosiveProjectiles.harmPlayers"))
            {
                launchGlobal.permHarmPlayers = true;
            }
            if (player.hasPermission("explosiveProjectiles.harmMobs"))
            {
                launchGlobal.permHarmMobs = true;
            }
            else
            {
                if (EPmain.Global.configToggleRequirePermission)
                {
                    if (EPmain.Global.configToggleVerbose)
                    {
                        player.sendMessage(Component.text("It appears you don't have any permission enabled despite requiring permission.", NamedTextColor.RED));
                    }
                }
            }
        }



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
            {getServer().sendMessage(Component.text("Player tossed ExpBottle.", NamedTextColor.GREEN));}
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
            {getServer().sendMessage(Component.text("Player threw Potion.", NamedTextColor.GREEN));}
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
}
