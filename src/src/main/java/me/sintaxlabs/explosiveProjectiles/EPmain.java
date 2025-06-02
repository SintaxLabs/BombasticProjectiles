////////////////////////////////////
///                              ///
///         Sintax Labs          ///
///                              ///
////////////////////////////////////

// https://github.com/SintaxLabs

// Game: 1.21.4
// Version: 1.0.4


package me.sintaxlabs.explosiveProjectiles;
import me.sintaxlabs.explosiveProjectiles.listeners.*;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class EPmain extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new entityHurtCheck(), this);
        getServer().getPluginManager().registerEvents(new projectileHitEntityCheck(), this);
        getServer().getPluginManager().registerEvents(new projectileHitBlockCheck(), this);
        getServer().getPluginManager().registerEvents(new launchCheck(), this);


        Global.configToggleRequirePermission = this.getConfig().getBoolean("require-Permission");
        Global.configImpactAll = this.getConfig().getInt("impact-All");
        Global.configToggleImpactCustom = this.getConfig().getBoolean("impact-Custom");
        Global.configImpactMobDamage = this.getConfig().getInt("Mob-Impact-Damage");
        Global.configToggleMobImpact = this.getConfig().getBoolean("Mob-Impact");
        Global.configToggleMobsExplodeEntities = this.getConfig().getBoolean("mobs-Explode-Entities");
        Global.configToggleMobsExplodeBlocks = this.getConfig().getBoolean("mobs-Explode-Blocks");
        Global.configToggleFire = this.getConfig().getBoolean("toggle-Fire");
        Global.configToggleBreakBlocks = this.getConfig().getBoolean("toggle-BreakBlocks");
        Global.configToggleHurtPlayer = this.getConfig().getBoolean("toggle-HurtPlayer");
        Global.configToggleHurtMobs = this.getConfig().getBoolean("toggle-HurtMobs");
        Global.configToggleTridentTeleport = this.getConfig().getBoolean("trident-Teleport");
        Global.configToggleTridentTeleportMessage = this.getConfig().getBoolean("trident-TP-Message");

        Global.configToggleEgg = this.getConfig().getBoolean("Egg");
        Global.configToggleArrow = this.getConfig().getBoolean("Arrow");
        Global.configTogglePotion = this.getConfig().getBoolean("Potion");
        Global.configToggleTrident = this.getConfig().getBoolean("Trident");
        Global.configToggleSnowball = this.getConfig().getBoolean("Snowball");
        Global.configToggleExpBottle = this.getConfig().getBoolean("ExpBottle");
        Global.configToggleEnderpearl = this.getConfig().getBoolean("Enderpearl");
        Global.configToggleFishingBobber = this.getConfig().getBoolean("FishingBobber");

        Global.configImpactEgg = this.getConfig().getInt("Egg-Impact");
        Global.configImpactArrow = this.getConfig().getInt("Arrow-Impact");
        Global.configImpactPotion = this.getConfig().getInt("Potion-Impact");
        Global.configImpactTrident = this.getConfig().getInt("Trident-Impact");
        Global.configImpactSnowball = this.getConfig().getInt("Snowball-Impact");
        Global.configImpactExpBottle = this.getConfig().getInt("ExpBottle-Impact");
        Global.configImpactEnderpearl = this.getConfig().getInt("Enderpearl-Impact");
        Global.configImpactFishingBobber = this.getConfig().getInt("FishingBobber-Impact");

        Global.configToggleVerbose = this.getConfig().getBoolean("verbose");

        if (Global.configToggleVerbose)
        {
            getLogger().warning("Verbose is enabled for ExplosiveProjectiles. This can be changed in your config file.");
        }
    }



    public static class Global
    {
        public static boolean playerHit = false;

        public static boolean configToggleRequirePermission;
        public static int configImpactAll;
        public static boolean configToggleImpactCustom;
        public static int configImpactMobDamage;
        public static boolean configToggleMobImpact;
        public static boolean configToggleMobsExplodeEntities;
        public static boolean configToggleMobsExplodeBlocks;
        public static boolean configToggleFire;
        public static boolean configToggleBreakBlocks;
        public static boolean configToggleHurtPlayer;
        public static boolean configToggleHurtMobs;
        public static boolean configToggleTridentTeleport;
        public static boolean configToggleTridentTeleportMessage;
        public static boolean configToggleVerbose;

        public static boolean configToggleEgg;
        public static boolean configToggleArrow;
        public static boolean configTogglePotion;
        public static boolean configToggleTrident;
        public static boolean configToggleSnowball;
        public static boolean configToggleExpBottle;
        public static boolean configToggleEnderpearl;
        public static boolean configToggleFishingBobber;

        public static int configImpactEgg;
        public static int configImpactArrow;
        public static int configImpactPotion;
        public static int configImpactTrident;
        public static int configImpactSnowball;
        public static int configImpactExpBottle;
        public static int configImpactEnderpearl;
        public static int configImpactFishingBobber;



        public static int kaboom;


    }


    //Verbose Operator Join Disclaimer
    @EventHandler
    public void playerJoinEvent (PlayerJoinEvent e)
    {
        if (Global.configToggleVerbose)
        {
            Player player = e.getPlayer();
            if (player.isOp())
            {
                //player.sendMessage("ExplosiveProjectiles - Verbose is enabled. This can be changed in your config file.");
                player.sendMessage(Component.text("ExplosiveProjectiles - Verbose is enabled. This can be changed in your config file.", NamedTextColor.RED));
            }
        }
    }



    @Override
    public void onDisable()
    {
        // Plugin shutdown logic
    }
}
