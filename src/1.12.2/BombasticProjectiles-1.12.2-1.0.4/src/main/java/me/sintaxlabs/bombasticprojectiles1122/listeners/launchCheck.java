package me.sintaxlabs.bombasticprojectiles1122.listeners;

import me.sintaxlabs.bombasticprojectiles1122.EPmain;
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
        Projectile projectile = e.getEntity();
        Object shooter = projectile.getShooter();
        if (shooter instanceof Player)
        {
            Player player = ((Player) shooter).getPlayer();

            if (player.hasPermission("bombasticProjectiles.all"))
            {
                launchGlobal.permAll = true;
            }
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
        }



        //Arrow CHECK ----------------------------------------------------------
        if (e.getEntity() instanceof Arrow)
        {
            if (EPmain.Global.configToggleVerbose)
            {getServer().broadcastMessage("Player shot Arrow.");}
            launchGlobal.playerShotItem = true;
        }

        //Egg CHECK ----------------------------------------------------------
        else if (e.getEntity() instanceof Egg)
        {
            if (EPmain.Global.configToggleVerbose)
            {getServer().broadcastMessage("Player tossed Egg.");}
            launchGlobal.playerShotItem = true;
        }

        //EnderPearl CHECK ----------------------------------------------------------
        else if (e.getEntity() instanceof EnderPearl)
        {
            if (EPmain.Global.configToggleVerbose)
            {getServer().broadcastMessage("Player chucked Enderpearl.");}
            launchGlobal.playerShotItem = true;
        }

        //ExpBottle CHECK ----------------------------------------------------------
        else if (e.getEntity() instanceof ThrownExpBottle)
        {
            if (EPmain.Global.configToggleVerbose)
            {getServer().broadcastMessage("Player tossed ExpBottle.");}
            launchGlobal.playerShotItem = true;
        }

        //FishingBobber CHECK ----------------------------------------------------------
        else if (e.getEntity() instanceof FishHook)
        {
            if (EPmain.Global.configToggleVerbose)
            {getServer().broadcastMessage("Player swung fishing hook.");}
            launchGlobal.playerShotItem = true;
        }

        //Potion CHECK ----------------------------------------------------------
        else if (e.getEntity() instanceof ThrownPotion)
        {
            if (EPmain.Global.configToggleVerbose)
            {getServer().broadcastMessage("Player threw Potion.");}
            launchGlobal.playerShotItem = true;
        }

        //Snowball CHECK ----------------------------------------------------------
        else if (e.getEntity() instanceof Snowball)
        {
            if (EPmain.Global.configToggleVerbose)
            {getServer().broadcastMessage("Player tossed Snowball.");}
            launchGlobal.playerShotItem = true;
        }
    }
}
