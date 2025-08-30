package me.sintaxlabs.bombasticprojectiles1165.listeners;

import me.sintaxlabs.bombasticprojectiles1165.EPmain;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

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

public final class projectileHitBlockCheck implements Listener
{
    @EventHandler
    public void projectileBlockCheck(ProjectileHitEvent e) {

        if (e.getEntity().getShooter() instanceof Player)
        {
            //Now the show starts
            //IF PLAYER WAS THE SHOOTER
            //Check #1 - Entity Hit Check
            if (e.getHitBlock() != null)
            {
                //Projectile Check - Arrow
                //------------------------------------
                if (e.getEntity() instanceof Arrow)
                {
                    if (EPmain.Global.configToggleArrow)
                    {
                        //----------------------------------------------------------------------------
                        if (EPmain.Global.configToggleVerbose)
                        {getServer().sendMessage(Component.text("B-Arrow-1 Complete. ToggleArrow is Enabled.", NamedTextColor.GRAY));}
                        //----------------------------------------------------------------------------
                        if (launchCheck.launchGlobal.playerShotItem)
                        {
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.configToggleVerbose)
                            {getServer().sendMessage(Component.text("B-Arrow-2 Complete. playerShotItem flagged.", NamedTextColor.GRAY));}
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.playerHit == 1)
                            {
                                entityHurtCheck.hurtGlobal.mobCount = 1;
                            }
                            if (!EPmain.Global.configToggleRequirePermission)
                            {
                                Location locationBlock = e.getHitBlock().getLocation();
                                World worldBlock = locationBlock.getWorld();
                                if (EPmain.Global.configToggleImpactCustom)
                                {
                                    //----------------------------------------------------------------------------
                                    if (EPmain.Global.configToggleVerbose)
                                    {getServer().sendMessage(Component.text("B-Arrow-3c Complete. customImpact was enabled.", NamedTextColor.GRAY));}
                                    //----------------------------------------------------------------------------
                                    EPmain.Global.kaboom = 1;
                                    worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactArrow, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                    EPmain.Global.playerHit = 0;
                                    EPmain.Global.kaboom = 0;
                                    entityHurtCheck.hurtGlobal.mobCount = 1;
                                    e.getEntity().remove();
                                }
                                else
                                {
                                    //----------------------------------------------------------------------------
                                    if (EPmain.Global.configToggleVerbose)
                                    {getServer().sendMessage(Component.text("B-Arrow-3d Complete. customImpact was disabled however.", NamedTextColor.GRAY));}
                                    //----------------------------------------------------------------------------

                                    EPmain.Global.kaboom = 1;
                                    worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactAll, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                    EPmain.Global.playerHit = 0;
                                    EPmain.Global.kaboom = 0;
                                    entityHurtCheck.hurtGlobal.mobCount = 1;
                                    e.getEntity().remove();
                                }
                            }
                            else
                            {
                                if (launchCheck.launchGlobal.permProjectiles)
                                {
                                    //----------------------------------------------------------------------------
                                    if (EPmain.Global.configToggleVerbose)
                                    {getServer().sendMessage(Component.text("B-Arrow-3a-2 Complete. Player had permProjectiles", NamedTextColor.GRAY));}
                                    //----------------------------------------------------------------------------
                                    Location locationBlock = e.getHitBlock().getLocation();
                                    World worldBlock = locationBlock.getWorld();

                                    if (launchCheck.launchGlobal.permBreakBlocks)
                                    {
                                        //----------------------------------------------------------------------------
                                        if (EPmain.Global.configToggleVerbose)
                                        {getServer().sendMessage(Component.text("B-Arrow-3b-2 Complete. Player had permBreakBlocks", NamedTextColor.GRAY));}
                                        //----------------------------------------------------------------------------
                                        if (EPmain.Global.configToggleImpactCustom)
                                        {
                                            //----------------------------------------------------------------------------
                                            if (EPmain.Global.configToggleVerbose)
                                            {getServer().sendMessage(Component.text("B-Arrow-3c-2 Complete. customImpact was enabled.", NamedTextColor.GRAY));}
                                            //----------------------------------------------------------------------------
                                            EPmain.Global.kaboom = 1;
                                            worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactArrow, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                            EPmain.Global.playerHit = 0;
                                            EPmain.Global.kaboom = 0;
                                            entityHurtCheck.hurtGlobal.mobCount = 1;
                                            e.getEntity().remove();
                                        }
                                        else
                                        {
                                            //----------------------------------------------------------------------------
                                            if (EPmain.Global.configToggleVerbose)
                                            {getServer().sendMessage(Component.text("B-Arrow-3d-2 Complete. customImpact was disabled however.", NamedTextColor.GRAY));}
                                            //----------------------------------------------------------------------------

                                            EPmain.Global.kaboom = 1;
                                            worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactAll, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                            EPmain.Global.playerHit = 0;
                                            EPmain.Global.kaboom = 0;
                                            entityHurtCheck.hurtGlobal.mobCount = 1;
                                            e.getEntity().remove();
                                        }
                                    }
                                    else
                                    {
                                        //----------------------------------------------------------------------------
                                        if (EPmain.Global.configToggleVerbose)
                                        {getServer().sendMessage(Component.text("B-Arrow-3e Complete. permBreakBlocks was disabled however.", NamedTextColor.GRAY));}
                                        //----------------------------------------------------------------------------

                                        EPmain.Global.kaboom = 1;
                                        worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactAll, false, false);
                                        EPmain.Global.playerHit = 0;
                                        EPmain.Global.kaboom = 0;
                                        entityHurtCheck.hurtGlobal.mobCount = 1;
                                        e.getEntity().remove();
                                    }
                                }
                                else
                                {
                                    //----------------------------------------------------------------------------
                                    if (EPmain.Global.configToggleVerbose)
                                    {getServer().sendMessage(Component.text("B-Arrow-3a Failed. Player does not have permProjectiles", NamedTextColor.RED));}
                                    //----------------------------------------------------------------------------
                                }
                            }
                        }
                        else
                        {
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.configToggleVerbose)
                            {getServer().sendMessage(Component.text("Consecutive explosion prevented. Item landed once already.", NamedTextColor.RED));}
                            //----------------------------------------------------------------------------
                        }
                    }
                }
                //Projectile Check - Egg
                //------------------------------------
                else if (e.getEntity() instanceof Egg)
                {
                    if (EPmain.Global.configToggleEgg)
                    {
                        //----------------------------------------------------------------------------
                        if (EPmain.Global.configToggleVerbose)
                        {getServer().sendMessage(Component.text("B-Egg-1 Complete. ToggleEgg is Enabled.", NamedTextColor.GRAY));}
                        //----------------------------------------------------------------------------
                        if (launchCheck.launchGlobal.playerShotItem)
                        {
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.configToggleVerbose)
                            {getServer().sendMessage(Component.text("B-Egg-2 Complete. playerShotItem flagged.", NamedTextColor.GRAY));}
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.playerHit == 1)
                            {
                                entityHurtCheck.hurtGlobal.mobCount = 1;
                            }
                            if (!EPmain.Global.configToggleRequirePermission)
                            {
                                Location locationBlock = e.getHitBlock().getLocation();
                                World worldBlock = locationBlock.getWorld();
                                if (EPmain.Global.configToggleImpactCustom)
                                {
                                    //----------------------------------------------------------------------------
                                    if (EPmain.Global.configToggleVerbose)
                                    {getServer().sendMessage(Component.text("B-Egg-3c Complete. customImpact was enabled.", NamedTextColor.GRAY));}
                                    //----------------------------------------------------------------------------
                                    EPmain.Global.kaboom = 1;
                                    worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactEgg, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                    EPmain.Global.playerHit = 0;
                                    EPmain.Global.kaboom = 0;
                                    entityHurtCheck.hurtGlobal.mobCount = 1;
                                    //e.getEntity().remove();
                                }
                                else
                                {
                                    //----------------------------------------------------------------------------
                                    if (EPmain.Global.configToggleVerbose)
                                    {getServer().sendMessage(Component.text("B-Egg-3d Complete. customImpact was disabled however.", NamedTextColor.GRAY));}
                                    //----------------------------------------------------------------------------

                                    EPmain.Global.kaboom = 1;
                                    worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactAll, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                    EPmain.Global.playerHit = 0;
                                    EPmain.Global.kaboom = 0;
                                    entityHurtCheck.hurtGlobal.mobCount = 1;
                                    //e.getEntity().remove();
                                }
                            }
                            else
                            {
                                if (launchCheck.launchGlobal.permProjectiles)
                                {
                                    //----------------------------------------------------------------------------
                                    if (EPmain.Global.configToggleVerbose)
                                    {getServer().sendMessage(Component.text("B-Egg-3a-2 Complete. Player had permProjectiles", NamedTextColor.GRAY));}
                                    //----------------------------------------------------------------------------
                                    Location locationBlock = e.getHitBlock().getLocation();
                                    World worldBlock = locationBlock.getWorld();

                                    if (launchCheck.launchGlobal.permBreakBlocks)
                                    {
                                        //----------------------------------------------------------------------------
                                        if (EPmain.Global.configToggleVerbose)
                                        {getServer().sendMessage(Component.text("B-Egg-3b-2 Complete. Player had permBreakBlocks", NamedTextColor.GRAY));}
                                        //----------------------------------------------------------------------------
                                        if (EPmain.Global.configToggleImpactCustom)
                                        {
                                            //----------------------------------------------------------------------------
                                            if (EPmain.Global.configToggleVerbose)
                                            {getServer().sendMessage(Component.text("B-Egg-3c-2 Complete. customImpact was enabled.", NamedTextColor.GRAY));}
                                            //----------------------------------------------------------------------------
                                            EPmain.Global.kaboom = 1;
                                            worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactEgg, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                            EPmain.Global.playerHit = 0;
                                            EPmain.Global.kaboom = 0;
                                            entityHurtCheck.hurtGlobal.mobCount = 1;
                                            //e.getEntity().remove();
                                        }
                                        else
                                        {
                                            //----------------------------------------------------------------------------
                                            if (EPmain.Global.configToggleVerbose)
                                            {getServer().sendMessage(Component.text("B-Egg-3d-2 Complete. customImpact was disabled however.", NamedTextColor.GRAY));}
                                            //----------------------------------------------------------------------------

                                            EPmain.Global.kaboom = 1;
                                            worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactAll, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                            EPmain.Global.playerHit = 0;
                                            EPmain.Global.kaboom = 0;
                                            entityHurtCheck.hurtGlobal.mobCount = 1;
                                            //e.getEntity().remove();
                                        }
                                    }
                                    else
                                    {
                                        //----------------------------------------------------------------------------
                                        if (EPmain.Global.configToggleVerbose)
                                        {getServer().sendMessage(Component.text("B-Egg-3e Complete. permBreakBlocks was disabled however.", NamedTextColor.GRAY));}
                                        //----------------------------------------------------------------------------

                                        EPmain.Global.kaboom = 1;
                                        worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactAll, false, false);
                                        EPmain.Global.playerHit = 0;
                                        EPmain.Global.kaboom = 0;
                                        entityHurtCheck.hurtGlobal.mobCount = 1;
                                        //e.getEntity().remove();
                                    }
                                }
                                else
                                {
                                    //----------------------------------------------------------------------------
                                    if (EPmain.Global.configToggleVerbose)
                                    {getServer().sendMessage(Component.text("B-Egg-3a Failed. Player does not have permProjectiles", NamedTextColor.RED));}
                                    //----------------------------------------------------------------------------
                                }
                            }
                        }
                    }
                }
                //Projectile Check - EnderPearl
                //------------------------------------
                else if (e.getEntity() instanceof EnderPearl)
                {
                    if (EPmain.Global.configToggleEnderpearl)
                    {
                        //----------------------------------------------------------------------------
                        if (EPmain.Global.configToggleVerbose)
                        {getServer().sendMessage(Component.text("B-EnderPearl-1 Complete. ToggleEnderPearl is Enabled.", NamedTextColor.GRAY));}
                        //----------------------------------------------------------------------------
                        if (launchCheck.launchGlobal.playerShotItem)
                        {
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.configToggleVerbose)
                            {getServer().sendMessage(Component.text("B-EnderPearl-2 Complete. playerShotItem flagged.", NamedTextColor.GRAY));}
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.playerHit == 1)
                            {
                                entityHurtCheck.hurtGlobal.mobCount = 1;
                            }
                            if (!EPmain.Global.configToggleRequirePermission)
                            {
                                Location locationBlock = e.getHitBlock().getLocation();
                                World worldBlock = locationBlock.getWorld();
                                if (EPmain.Global.configToggleImpactCustom)
                                {
                                    //----------------------------------------------------------------------------
                                    if (EPmain.Global.configToggleVerbose)
                                    {getServer().sendMessage(Component.text("B-EnderPearl-3c Complete. customImpact was enabled.", NamedTextColor.GRAY));}
                                    //----------------------------------------------------------------------------
                                    EPmain.Global.kaboom = 1;
                                    worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactEnderpearl, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                    EPmain.Global.playerHit = 0;
                                    EPmain.Global.kaboom = 0;
                                    entityHurtCheck.hurtGlobal.mobCount = 1;
                                    //e.getEntity().remove();
                                }
                                else
                                {
                                    //----------------------------------------------------------------------------
                                    if (EPmain.Global.configToggleVerbose)
                                    {getServer().sendMessage(Component.text("B-EnderPearl-3d Complete. customImpact was disabled however.", NamedTextColor.GRAY));}
                                    //----------------------------------------------------------------------------

                                    EPmain.Global.kaboom = 1;
                                    worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactAll, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                    EPmain.Global.playerHit = 0;
                                    EPmain.Global.kaboom = 0;
                                    entityHurtCheck.hurtGlobal.mobCount = 1;
                                    //e.getEntity().remove();
                                }
                            }
                            else
                            {
                                if (launchCheck.launchGlobal.permProjectiles)
                                {
                                    //----------------------------------------------------------------------------
                                    if (EPmain.Global.configToggleVerbose)
                                    {getServer().sendMessage(Component.text("B-EnderPearl-3a-2 Complete. Player had permProjectiles", NamedTextColor.GRAY));}
                                    //----------------------------------------------------------------------------
                                    Location locationBlock = e.getHitBlock().getLocation();
                                    World worldBlock = locationBlock.getWorld();

                                    if (launchCheck.launchGlobal.permBreakBlocks)
                                    {
                                        //----------------------------------------------------------------------------
                                        if (EPmain.Global.configToggleVerbose)
                                        {getServer().sendMessage(Component.text("B-EnderPearl-3b-2 Complete. Player had permBreakBlocks", NamedTextColor.GRAY));}
                                        //----------------------------------------------------------------------------
                                        if (EPmain.Global.configToggleImpactCustom)
                                        {
                                            //----------------------------------------------------------------------------
                                            if (EPmain.Global.configToggleVerbose)
                                            {getServer().sendMessage(Component.text("B-EnderPearl-3c-2 Complete. customImpact was enabled.", NamedTextColor.GRAY));}
                                            //----------------------------------------------------------------------------
                                            EPmain.Global.kaboom = 1;
                                            worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactEnderpearl, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                            EPmain.Global.playerHit = 0;
                                            EPmain.Global.kaboom = 0;
                                            entityHurtCheck.hurtGlobal.mobCount = 1;
                                            //e.getEntity().remove();
                                        }
                                        else
                                        {
                                            //----------------------------------------------------------------------------
                                            if (EPmain.Global.configToggleVerbose)
                                            {getServer().sendMessage(Component.text("B-EnderPearl-3d-2 Complete. customImpact was disabled however.", NamedTextColor.GRAY));}
                                            //----------------------------------------------------------------------------

                                            EPmain.Global.kaboom = 1;
                                            worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactAll, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                            EPmain.Global.playerHit = 0;
                                            EPmain.Global.kaboom = 0;
                                            entityHurtCheck.hurtGlobal.mobCount = 1;
                                            //e.getEntity().remove();
                                        }
                                    }
                                    else
                                    {
                                        //----------------------------------------------------------------------------
                                        if (EPmain.Global.configToggleVerbose)
                                        {getServer().sendMessage(Component.text("B-EnderPearl-3e Complete. permBreakBlocks was disabled however.", NamedTextColor.GRAY));}
                                        //----------------------------------------------------------------------------

                                        EPmain.Global.kaboom = 1;
                                        worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactAll, false, false);
                                        EPmain.Global.playerHit = 0;
                                        EPmain.Global.kaboom = 0;
                                        entityHurtCheck.hurtGlobal.mobCount = 1;
                                        //e.getEntity().remove();
                                    }
                                }
                                else
                                {
                                    //----------------------------------------------------------------------------
                                    if (EPmain.Global.configToggleVerbose)
                                    {getServer().sendMessage(Component.text("B-EnderPearl-3a Failed. Player does not have permProjectiles", NamedTextColor.RED));}
                                    //----------------------------------------------------------------------------
                                }
                            }
                        }
                    }
                }
                //Projectile Check - ExpBottle
                //------------------------------------
                else if (e.getEntity() instanceof ThrownExpBottle)
                {
                    if (EPmain.Global.configToggleExpBottle)
                    {
                        //----------------------------------------------------------------------------
                        if (EPmain.Global.configToggleVerbose)
                        {getServer().sendMessage(Component.text("B-ExpBottle-1 Complete. ToggleExpBottle is Enabled.", NamedTextColor.GRAY));}
                        //----------------------------------------------------------------------------
                        if (launchCheck.launchGlobal.playerShotItem)
                        {
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.configToggleVerbose)
                            {getServer().sendMessage(Component.text("B-ExpBottle-2 Complete. playerShotItem flagged.", NamedTextColor.GRAY));}
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.playerHit == 1)
                            {
                                entityHurtCheck.hurtGlobal.mobCount = 1;
                            }
                            if (!EPmain.Global.configToggleRequirePermission)
                            {
                                Location locationBlock = e.getHitBlock().getLocation();
                                World worldBlock = locationBlock.getWorld();
                                if (EPmain.Global.configToggleImpactCustom)
                                {
                                    //----------------------------------------------------------------------------
                                    if (EPmain.Global.configToggleVerbose)
                                    {getServer().sendMessage(Component.text("B-ExpBottle-3c Complete. customImpact was enabled.", NamedTextColor.GRAY));}
                                    //----------------------------------------------------------------------------
                                    EPmain.Global.kaboom = 1;
                                    worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactExpBottle, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                    EPmain.Global.playerHit = 0;
                                    EPmain.Global.kaboom = 0;
                                    entityHurtCheck.hurtGlobal.mobCount = 1;
                                    //e.getEntity().remove();
                                }
                                else
                                {
                                    //----------------------------------------------------------------------------
                                    if (EPmain.Global.configToggleVerbose)
                                    {getServer().sendMessage(Component.text("B-ExpBottle-3d Complete. customImpact was disabled however", NamedTextColor.GRAY));}
                                    //----------------------------------------------------------------------------

                                    EPmain.Global.kaboom = 1;
                                    worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactAll, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                    EPmain.Global.playerHit = 0;
                                    EPmain.Global.kaboom = 0;
                                    entityHurtCheck.hurtGlobal.mobCount = 1;
                                    //e.getEntity().remove();
                                }
                            }
                            else
                            {
                                if (launchCheck.launchGlobal.permProjectiles)
                                {
                                    //----------------------------------------------------------------------------
                                    if (EPmain.Global.configToggleVerbose)
                                    {getServer().sendMessage(Component.text("B-ExpBottle-3a-2 Complete. Player had permProjectiles", NamedTextColor.GRAY));}
                                    //----------------------------------------------------------------------------
                                    Location locationBlock = e.getHitBlock().getLocation();
                                    World worldBlock = locationBlock.getWorld();

                                    if (launchCheck.launchGlobal.permBreakBlocks)
                                    {
                                        //----------------------------------------------------------------------------
                                        if (EPmain.Global.configToggleVerbose)
                                        {getServer().sendMessage(Component.text("B-ExpBottle-3b-2 Complete. Player had permBreakBlocks", NamedTextColor.GRAY));}
                                        //----------------------------------------------------------------------------
                                        if (EPmain.Global.configToggleImpactCustom)
                                        {
                                            //----------------------------------------------------------------------------
                                            if (EPmain.Global.configToggleVerbose)
                                            {getServer().sendMessage(Component.text("B-ExpBottle-3c-2 Complete. customImpact was enabled.", NamedTextColor.GRAY));}
                                            //----------------------------------------------------------------------------
                                            EPmain.Global.kaboom = 1;
                                            worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactExpBottle, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                            EPmain.Global.playerHit = 0;
                                            EPmain.Global.kaboom = 0;
                                            entityHurtCheck.hurtGlobal.mobCount = 1;
                                            //e.getEntity().remove();
                                        }
                                        else
                                        {
                                            //----------------------------------------------------------------------------
                                            if (EPmain.Global.configToggleVerbose)
                                            {getServer().sendMessage(Component.text("B-ExpBottle-3d-2 Complete. customImpact was disabled however.", NamedTextColor.GRAY));}
                                            //----------------------------------------------------------------------------

                                            EPmain.Global.kaboom = 1;
                                            worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactAll, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                            EPmain.Global.playerHit = 0;
                                            EPmain.Global.kaboom = 0;
                                            entityHurtCheck.hurtGlobal.mobCount = 1;
                                            //e.getEntity().remove();
                                        }
                                    }
                                    else
                                    {
                                        //----------------------------------------------------------------------------
                                        if (EPmain.Global.configToggleVerbose)
                                        {getServer().sendMessage(Component.text("B-ExpBottle-3e Complete. permBreakBlocks was disabled however.", NamedTextColor.GRAY));}
                                        //----------------------------------------------------------------------------

                                        EPmain.Global.kaboom = 1;
                                        worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactAll, false, false);
                                        EPmain.Global.playerHit = 0;
                                        EPmain.Global.kaboom = 0;
                                        entityHurtCheck.hurtGlobal.mobCount = 1;
                                        //e.getEntity().remove();
                                    }
                                }
                                else
                                {
                                    //----------------------------------------------------------------------------
                                    if (EPmain.Global.configToggleVerbose)
                                    {getServer().sendMessage(Component.text("B-ExpBottle-3a Failed. Player does not have permProjectiles", NamedTextColor.RED));}
                                    //----------------------------------------------------------------------------
                                }
                            }
                        }
                    }
                }
                //Projectile Check - FishingBobber
                //------------------------------------
                else if (e.getEntity() instanceof FishHook)
                {
                    if (EPmain.Global.configToggleFishingBobber)
                    {
                        //----------------------------------------------------------------------------
                        if (EPmain.Global.configToggleVerbose)
                        {getServer().sendMessage(Component.text("B-FishingBobber-1 Complete. ToggleFishingBobber is Enabled.", NamedTextColor.GRAY));}
                        //----------------------------------------------------------------------------
                        if (launchCheck.launchGlobal.playerShotItem)
                        {
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.configToggleVerbose)
                            {getServer().sendMessage(Component.text("B-FishingBobber-2 Complete. playerShotItem flagged.", NamedTextColor.GRAY));}
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.playerHit == 1)
                            {
                                entityHurtCheck.hurtGlobal.mobCount = 1;
                            }
                            if (!EPmain.Global.configToggleRequirePermission)
                            {
                                Location locationBlock = e.getHitBlock().getLocation();
                                World worldBlock = locationBlock.getWorld();
                                if (EPmain.Global.configToggleImpactCustom)
                                {
                                    //----------------------------------------------------------------------------
                                    if (EPmain.Global.configToggleVerbose)
                                    {getServer().sendMessage(Component.text("B-FishingBobber-3c Complete. customImpact was enabled.", NamedTextColor.GRAY));}
                                    //----------------------------------------------------------------------------
                                    EPmain.Global.kaboom = 1;
                                    worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactFishingBobber, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                    EPmain.Global.playerHit = 0;
                                    EPmain.Global.kaboom = 0;
                                    entityHurtCheck.hurtGlobal.mobCount = 1;
                                    launchCheck.launchGlobal.playerShotItem = false;
                                }
                                else
                                {
                                    //----------------------------------------------------------------------------
                                    if (EPmain.Global.configToggleVerbose)
                                    {getServer().sendMessage(Component.text("B-FishingBobber-3d Complete. customImpact was disabled however.", NamedTextColor.GRAY));}
                                    //----------------------------------------------------------------------------

                                    EPmain.Global.kaboom = 1;
                                    worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactAll, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                    EPmain.Global.playerHit = 0;
                                    EPmain.Global.kaboom = 0;
                                    entityHurtCheck.hurtGlobal.mobCount = 1;
                                    launchCheck.launchGlobal.playerShotItem = false;
                                }
                            }
                            else
                            {
                                if (launchCheck.launchGlobal.permProjectiles)
                                {
                                    //----------------------------------------------------------------------------
                                    if (EPmain.Global.configToggleVerbose)
                                    {getServer().sendMessage(Component.text("B-FishingBobber-3a-2 Complete. Player had permProjectiles", NamedTextColor.GRAY));}
                                    //----------------------------------------------------------------------------
                                    Location locationBlock = e.getHitBlock().getLocation();
                                    World worldBlock = locationBlock.getWorld();

                                    if (launchCheck.launchGlobal.permBreakBlocks)
                                    {
                                        //----------------------------------------------------------------------------
                                        if (EPmain.Global.configToggleVerbose)
                                        {getServer().sendMessage(Component.text("B-FishingBobber-3b-2 Complete. Player had permBreakBlocks", NamedTextColor.GRAY));}
                                        //----------------------------------------------------------------------------
                                        if (EPmain.Global.configToggleImpactCustom)
                                        {
                                            //----------------------------------------------------------------------------
                                            if (EPmain.Global.configToggleVerbose)
                                            {getServer().sendMessage(Component.text("B-FishingBobber-3c-2 Complete. customImpact was enabled.", NamedTextColor.GRAY));}
                                            //----------------------------------------------------------------------------
                                            EPmain.Global.kaboom = 1;
                                            worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactFishingBobber, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                            EPmain.Global.playerHit = 0;
                                            EPmain.Global.kaboom = 0;
                                            entityHurtCheck.hurtGlobal.mobCount = 1;
                                            launchCheck.launchGlobal.playerShotItem = false;
                                        }
                                        else
                                        {
                                            //----------------------------------------------------------------------------
                                            if (EPmain.Global.configToggleVerbose)
                                            {getServer().sendMessage(Component.text("B-FishingBobber-3d-2 Complete. customImpact was disabled however.", NamedTextColor.GRAY));}
                                            //----------------------------------------------------------------------------

                                            EPmain.Global.kaboom = 1;
                                            worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactAll, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                            EPmain.Global.playerHit = 0;
                                            EPmain.Global.kaboom = 0;
                                            entityHurtCheck.hurtGlobal.mobCount = 1;
                                            launchCheck.launchGlobal.playerShotItem = false;
                                        }
                                    }
                                    else
                                    {
                                        //----------------------------------------------------------------------------
                                        if (EPmain.Global.configToggleVerbose)
                                        {getServer().sendMessage(Component.text("B-FishingBobber-3e Complete. permBreakBlocks was disabled however.", NamedTextColor.GRAY));}
                                        //----------------------------------------------------------------------------

                                        EPmain.Global.kaboom = 1;
                                        worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactAll, false, false);
                                        EPmain.Global.playerHit = 0;
                                        EPmain.Global.kaboom = 0;
                                        entityHurtCheck.hurtGlobal.mobCount = 1;
                                        launchCheck.launchGlobal.playerShotItem = false;
                                    }
                                }
                                else
                                {
                                    //----------------------------------------------------------------------------
                                    if (EPmain.Global.configToggleVerbose)
                                    {getServer().sendMessage(Component.text("B-FishingBobber-3a Failed. Player does not have permProjectiles", NamedTextColor.RED));}
                                    //----------------------------------------------------------------------------
                                }
                            }
                        }
                        else
                        {
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.configToggleVerbose)
                            {getServer().sendMessage(Component.text("Consecutive explosion prevented. Item landed once already.", NamedTextColor.RED));}
                            //----------------------------------------------------------------------------
                        }
                    }
                }
                //Projectile Check - Potion
                //------------------------------------
                else if (e.getEntity() instanceof ThrownPotion)
                {
                    if (EPmain.Global.configTogglePotion)
                    {
                        //----------------------------------------------------------------------------
                        if (EPmain.Global.configToggleVerbose)
                        {getServer().sendMessage(Component.text("B-Potion-1 Complete. TogglePotion is Enabled.", NamedTextColor.GRAY));}
                        //----------------------------------------------------------------------------
                        if (launchCheck.launchGlobal.playerShotItem)
                        {
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.configToggleVerbose)
                            {getServer().sendMessage(Component.text("B-Potion-2 Complete. playerShotItem flagged.", NamedTextColor.GRAY));}
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.playerHit == 1)
                            {
                                entityHurtCheck.hurtGlobal.mobCount = 1;
                            }
                            if (!EPmain.Global.configToggleRequirePermission)
                            {
                                Location locationBlock = e.getHitBlock().getLocation();
                                World worldBlock = locationBlock.getWorld();
                                if (EPmain.Global.configToggleImpactCustom)
                                {
                                    //----------------------------------------------------------------------------
                                    if (EPmain.Global.configToggleVerbose)
                                    {getServer().sendMessage(Component.text("B-Potion-3c Complete. customImpact was enabled.", NamedTextColor.GRAY));}
                                    //----------------------------------------------------------------------------
                                    EPmain.Global.kaboom = 1;
                                    worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactPotion, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                    EPmain.Global.playerHit = 0;
                                    EPmain.Global.kaboom = 0;
                                    entityHurtCheck.hurtGlobal.mobCount = 1;
                                    //e.getEntity().remove();
                                }
                                else
                                {
                                    //----------------------------------------------------------------------------
                                    if (EPmain.Global.configToggleVerbose)
                                    {getServer().sendMessage(Component.text("B-Potion-3d Complete. customImpact was disabled however.", NamedTextColor.GRAY));}
                                    //----------------------------------------------------------------------------

                                    EPmain.Global.kaboom = 1;
                                    worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactAll, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                    EPmain.Global.playerHit = 0;
                                    EPmain.Global.kaboom = 0;
                                    entityHurtCheck.hurtGlobal.mobCount = 1;
                                    //e.getEntity().remove();
                                }
                            }
                            else
                            {
                                if (launchCheck.launchGlobal.permProjectiles)
                                {
                                    //----------------------------------------------------------------------------
                                    if (EPmain.Global.configToggleVerbose)
                                    {getServer().sendMessage(Component.text("B-Potion-3a-2 Complete. Player had permProjectiles", NamedTextColor.GRAY));}
                                    //----------------------------------------------------------------------------
                                    Location locationBlock = e.getHitBlock().getLocation();
                                    World worldBlock = locationBlock.getWorld();

                                    if (launchCheck.launchGlobal.permBreakBlocks)
                                    {
                                        //----------------------------------------------------------------------------
                                        if (EPmain.Global.configToggleVerbose)
                                        {getServer().sendMessage(Component.text("B-Potion-3b-2 Complete. Player had permBreakBlocks", NamedTextColor.GRAY));}
                                        //----------------------------------------------------------------------------
                                        if (EPmain.Global.configToggleImpactCustom)
                                        {
                                            //----------------------------------------------------------------------------
                                            if (EPmain.Global.configToggleVerbose)
                                            {getServer().sendMessage(Component.text("B-Potion-3c-2 Complete. customImpact was enabled.", NamedTextColor.GRAY));}
                                            //----------------------------------------------------------------------------
                                            EPmain.Global.kaboom = 1;
                                            worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactPotion, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                            EPmain.Global.playerHit = 0;
                                            EPmain.Global.kaboom = 0;
                                            entityHurtCheck.hurtGlobal.mobCount = 1;
                                            //e.getEntity().remove();
                                        }
                                        else
                                        {
                                            //----------------------------------------------------------------------------
                                            if (EPmain.Global.configToggleVerbose)
                                            {getServer().sendMessage(Component.text("B-Potion-3d-2 Complete. customImpact was disabled however.", NamedTextColor.GRAY));}
                                            //----------------------------------------------------------------------------

                                            EPmain.Global.kaboom = 1;
                                            worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactAll, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                            EPmain.Global.playerHit = 0;
                                            EPmain.Global.kaboom = 0;
                                            entityHurtCheck.hurtGlobal.mobCount = 1;
                                            //e.getEntity().remove();
                                        }
                                    }
                                    else
                                    {
                                        //----------------------------------------------------------------------------
                                        if (EPmain.Global.configToggleVerbose)
                                        {getServer().sendMessage(Component.text("B-Potion-3e Complete. permBreakBlocks was disabled however.", NamedTextColor.GRAY));}
                                        //----------------------------------------------------------------------------

                                        EPmain.Global.kaboom = 1;
                                        worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactAll, false, false);
                                        EPmain.Global.playerHit = 0;
                                        EPmain.Global.kaboom = 0;
                                        entityHurtCheck.hurtGlobal.mobCount = 1;
                                        //e.getEntity().remove();
                                    }
                                }
                                else
                                {
                                    //----------------------------------------------------------------------------
                                    if (EPmain.Global.configToggleVerbose)
                                    {getServer().sendMessage(Component.text("B-Potion-3a Failed. Player does not have permProjectiles", NamedTextColor.RED));}
                                    //----------------------------------------------------------------------------
                                }
                            }
                        }
                        else
                        {
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.configToggleVerbose)
                            {getServer().sendMessage(Component.text("B-Potion-2 Failed. Item was not launched by player.", NamedTextColor.RED));}
                            //----------------------------------------------------------------------------
                        }
                    }
                }
                //Projectile Check - Snowball
                //------------------------------------
                else if (e.getEntity() instanceof Snowball)
                {
                    if (EPmain.Global.configToggleSnowball)
                    {
                        //----------------------------------------------------------------------------
                        if (EPmain.Global.configToggleVerbose)
                        {getServer().sendMessage(Component.text("B-Snowball-1 Complete. ToggleSnowball is Enabled.", NamedTextColor.GRAY));}
                        //----------------------------------------------------------------------------
                        if (launchCheck.launchGlobal.playerShotItem)
                        {
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.configToggleVerbose)
                            {getServer().sendMessage(Component.text("B-Snowball-2 Complete. playerShotItem flagged.", NamedTextColor.GRAY));}
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.playerHit == 1)
                            {
                                entityHurtCheck.hurtGlobal.mobCount = 1;
                            }
                            if (!EPmain.Global.configToggleRequirePermission)
                            {
                                Location locationBlock = e.getHitBlock().getLocation();
                                World worldBlock = locationBlock.getWorld();
                                if (EPmain.Global.configToggleImpactCustom)
                                {
                                    //----------------------------------------------------------------------------
                                    if (EPmain.Global.configToggleVerbose)
                                    {getServer().sendMessage(Component.text("B-Snowball-3c Complete. customImpact was enabled.", NamedTextColor.GRAY));}
                                    //----------------------------------------------------------------------------
                                    EPmain.Global.kaboom = 1;
                                    worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactSnowball, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                    EPmain.Global.playerHit = 0;
                                    EPmain.Global.kaboom = 0;
                                    entityHurtCheck.hurtGlobal.mobCount = 1;
                                    //e.getEntity().remove();
                                }
                                else
                                {
                                    //----------------------------------------------------------------------------
                                    if (EPmain.Global.configToggleVerbose)
                                    {getServer().sendMessage(Component.text("B-Snowball-3d Complete. customImpact was disabled however.", NamedTextColor.GRAY));}
                                    //----------------------------------------------------------------------------

                                    EPmain.Global.kaboom = 1;
                                    worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactAll, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                    EPmain.Global.playerHit = 0;
                                    EPmain.Global.kaboom = 0;
                                    entityHurtCheck.hurtGlobal.mobCount = 1;
                                    //e.getEntity().remove();
                                }
                            }
                            else
                            {
                                if (launchCheck.launchGlobal.permProjectiles)
                                {
                                    //----------------------------------------------------------------------------
                                    if (EPmain.Global.configToggleVerbose)
                                    {getServer().sendMessage(Component.text("B-Snowball-3a-2 Complete. Player had permProjectiles", NamedTextColor.GRAY));}
                                    //----------------------------------------------------------------------------
                                    Location locationBlock = e.getHitBlock().getLocation();
                                    World worldBlock = locationBlock.getWorld();

                                    if (launchCheck.launchGlobal.permBreakBlocks)
                                    {
                                        //----------------------------------------------------------------------------
                                        if (EPmain.Global.configToggleVerbose)
                                        {getServer().sendMessage(Component.text("B-Snowball-3b-2 Complete. Player had permBreakBlocks", NamedTextColor.GRAY));}
                                        //----------------------------------------------------------------------------
                                        if (EPmain.Global.configToggleImpactCustom)
                                        {
                                            //----------------------------------------------------------------------------
                                            if (EPmain.Global.configToggleVerbose)
                                            {getServer().sendMessage(Component.text("B-Snowball-3c-2 Complete. customImpact was enabled.", NamedTextColor.GRAY));}
                                            //----------------------------------------------------------------------------
                                            EPmain.Global.kaboom = 1;
                                            worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactSnowball, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                            EPmain.Global.playerHit = 0;
                                            EPmain.Global.kaboom = 0;
                                            entityHurtCheck.hurtGlobal.mobCount = 1;
                                            //e.getEntity().remove();
                                        }
                                        else
                                        {
                                            //----------------------------------------------------------------------------
                                            if (EPmain.Global.configToggleVerbose)
                                            {getServer().sendMessage(Component.text("B-Snowball-3d-2 Complete. customImpact was disabled however.", NamedTextColor.GRAY));}
                                            //----------------------------------------------------------------------------

                                            EPmain.Global.kaboom = 1;
                                            worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactAll, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                            EPmain.Global.playerHit = 0;
                                            EPmain.Global.kaboom = 0;
                                            entityHurtCheck.hurtGlobal.mobCount = 1;
                                            //e.getEntity().remove();
                                        }
                                    }
                                    else
                                    {
                                        //----------------------------------------------------------------------------
                                        if (EPmain.Global.configToggleVerbose)
                                        {getServer().sendMessage(Component.text("B-Snowball-3e Complete. permBreakBlocks was disabled however.", NamedTextColor.GRAY));}
                                        //----------------------------------------------------------------------------

                                        EPmain.Global.kaboom = 1;
                                        worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactAll, false, false);
                                        EPmain.Global.playerHit = 0;
                                        EPmain.Global.kaboom = 0;
                                        entityHurtCheck.hurtGlobal.mobCount = 1;
                                        //e.getEntity().remove();
                                    }
                                }
                                else
                                {
                                    //----------------------------------------------------------------------------
                                    if (EPmain.Global.configToggleVerbose)
                                    {getServer().sendMessage(Component.text("B-Snowball-3a Failed. Player does not have permProjectiles", NamedTextColor.RED));}
                                    //----------------------------------------------------------------------------
                                }
                            }
                        }
                        else
                        {
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.configToggleVerbose)
                            {getServer().sendMessage(Component.text("Consecutive explosion prevented. Item landed once already.", NamedTextColor.RED));}
                            //----------------------------------------------------------------------------
                        }
                    }
                }
                //Projectile Check - Trident
                //------------------------------------
                else if (e.getEntity() instanceof Trident)
                {
                    e.getEntity().setGravity(true);
                    if (EPmain.Global.configToggleTrident)
                    {
                        //----------------------------------------------------------------------------
                        if (EPmain.Global.configToggleVerbose)
                        {getServer().sendMessage(Component.text("B-Trident-1 Complete. ToggleTrident is Enabled.", NamedTextColor.GRAY));}
                        //----------------------------------------------------------------------------
                        if (launchCheck.launchGlobal.playerShotItem)
                        {
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.configToggleVerbose)
                            {getServer().sendMessage(Component.text("B-Trident-2 Complete. playerShotItem flagged.", NamedTextColor.GRAY));}
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.playerHit == 1)
                            {
                                entityHurtCheck.hurtGlobal.mobCount = 1;
                            }
                            if (!EPmain.Global.configToggleRequirePermission)
                            {
                                Location locationBlock = e.getHitBlock().getLocation();
                                World worldBlock = locationBlock.getWorld();
                                if (EPmain.Global.configToggleImpactCustom)
                                {
                                    //----------------------------------------------------------------------------
                                    if (EPmain.Global.configToggleVerbose)
                                    {getServer().sendMessage(Component.text("B-Trident-3c Complete. customImpact was enabled.", NamedTextColor.GRAY));}
                                    //----------------------------------------------------------------------------
                                    EPmain.Global.kaboom = 1;
                                    worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactTrident, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                    EPmain.Global.playerHit = 0;
                                    EPmain.Global.kaboom = 0;
                                    entityHurtCheck.hurtGlobal.mobCount = 1;

                                    Block glizzy = e.getHitBlock();
                                    glizzy.setBlockData(Material.DIRT.createBlockData());
                                }
                                else
                                {
                                    //----------------------------------------------------------------------------
                                    if (EPmain.Global.configToggleVerbose)
                                    {getServer().sendMessage(Component.text("B-Trident-3d Complete. customImpact was disabled however.", NamedTextColor.GRAY));}
                                    //----------------------------------------------------------------------------

                                    EPmain.Global.kaboom = 1;
                                    worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactAll, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                    EPmain.Global.playerHit = 0;
                                    EPmain.Global.kaboom = 0;
                                    entityHurtCheck.hurtGlobal.mobCount = 1;

                                    Block glizzy = e.getHitBlock();
                                    glizzy.setBlockData(Material.DIRT.createBlockData());
                                }
                            }
                            else
                            {
                                if (launchCheck.launchGlobal.permProjectiles)
                                {
                                    //----------------------------------------------------------------------------
                                    if (EPmain.Global.configToggleVerbose)
                                    {getServer().sendMessage(Component.text("B-Trident-3a-2 Complete. Player had permProjectiles", NamedTextColor.GRAY));}
                                    //----------------------------------------------------------------------------
                                    Location locationBlock = e.getHitBlock().getLocation();
                                    World worldBlock = locationBlock.getWorld();

                                    if (launchCheck.launchGlobal.permBreakBlocks)
                                    {
                                        //----------------------------------------------------------------------------
                                        if (EPmain.Global.configToggleVerbose)
                                        {getServer().sendMessage(Component.text("B-Trident-3b-2 Complete. Player had permBreakBlocks", NamedTextColor.GRAY));}
                                        //----------------------------------------------------------------------------
                                        if (EPmain.Global.configToggleImpactCustom)
                                        {
                                            //----------------------------------------------------------------------------
                                            if (EPmain.Global.configToggleVerbose)
                                            {getServer().sendMessage(Component.text("B-Trident-3c-2 Complete. customImpact was enabled.", NamedTextColor.GRAY));}
                                            //----------------------------------------------------------------------------
                                            EPmain.Global.kaboom = 1;
                                            worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactTrident, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                            EPmain.Global.playerHit = 0;
                                            EPmain.Global.kaboom = 0;
                                            entityHurtCheck.hurtGlobal.mobCount = 1;

                                            Block glizzy = e.getHitBlock();
                                            glizzy.setBlockData(Material.DIRT.createBlockData());
                                        }
                                        else
                                        {
                                            //----------------------------------------------------------------------------
                                            if (EPmain.Global.configToggleVerbose)
                                            {getServer().sendMessage(Component.text("B-Trident-3d-2 Complete. customImpact was disabled however.", NamedTextColor.GRAY));}
                                            //----------------------------------------------------------------------------

                                            EPmain.Global.kaboom = 1;
                                            worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactAll, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                            EPmain.Global.playerHit = 0;
                                            EPmain.Global.kaboom = 0;
                                            entityHurtCheck.hurtGlobal.mobCount = 1;

                                            Block glizzy = e.getHitBlock();
                                            glizzy.setBlockData(Material.DIRT.createBlockData());
                                        }
                                    }
                                    else
                                    {
                                        //----------------------------------------------------------------------------
                                        if (EPmain.Global.configToggleVerbose)
                                        {getServer().sendMessage(Component.text("B-Trident-3e Complete. permBreakBlocks was disabled however.", NamedTextColor.GRAY));}
                                        //----------------------------------------------------------------------------

                                        EPmain.Global.kaboom = 1;
                                        worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactAll, false, false);
                                        EPmain.Global.playerHit = 0;
                                        EPmain.Global.kaboom = 0;
                                        entityHurtCheck.hurtGlobal.mobCount = 1;

                                        Block glizzy = e.getHitBlock();
                                        glizzy.setBlockData(Material.DIRT.createBlockData());
                                    }
                                }
                                else
                                {
                                    //----------------------------------------------------------------------------
                                    if (EPmain.Global.configToggleVerbose)
                                    {getServer().sendMessage(Component.text("B-Trident-3a Failed. Player does not have permProjectiles", NamedTextColor.RED));}
                                    //----------------------------------------------------------------------------
                                }
                            }
                        }
                        else
                        {
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.configToggleVerbose)
                            {getServer().sendMessage(Component.text("Consecutive explosion prevented. Item landed once already.", NamedTextColor.RED));}
                            //----------------------------------------------------------------------------
                        }
                    }
                }
            }
        }
        //IF A MOB WAS THE SHOOTER
        else
        {
            if (e.getHitBlock() != null)
            {
                if (EPmain.Global.configToggleMobsExplodeBlocks)
                {
                    if (EPmain.Global.configToggleMobImpact)
                    {
                        Location locationBlock = e.getHitBlock().getLocation();
                        World worldBlock = locationBlock.getWorld();

                        if (e.getEntity() instanceof Arrow)
                        {
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.configToggleVerbose)
                            {getServer().sendMessage(Component.text("B-Arrow-3e Complete. mobImpact was enabled however.", NamedTextColor.GRAY));}
                            //----------------------------------------------------------------------------
                            EPmain.Global.kaboom = 1;
                            worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactMobDamage, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                            EPmain.Global.playerHit = 0;
                            EPmain.Global.kaboom = 0;
                            entityHurtCheck.hurtGlobal.mobCount = 1;
                            e.getEntity().remove();
                        }
                        else if (e.getEntity() instanceof ThrownPotion)
                        {
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.configToggleVerbose)
                            {getServer().sendMessage(Component.text("B-Potion-3e Complete. mobImpact was enabled however.", NamedTextColor.GRAY));}
                            //----------------------------------------------------------------------------
                            EPmain.Global.kaboom = 1;
                            worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactMobDamage, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                            EPmain.Global.playerHit = 0;
                            EPmain.Global.kaboom = 0;
                            entityHurtCheck.hurtGlobal.mobCount = 1;
                            e.getEntity().remove();
                        }
                        else if (e.getEntity() instanceof Snowball)
                        {
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.configToggleVerbose)
                            {getServer().sendMessage(Component.text("B-Snowball-3e Complete. mobImpact was enabled however.", NamedTextColor.GRAY));}
                            //----------------------------------------------------------------------------
                            EPmain.Global.kaboom = 1;
                            worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactMobDamage, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                            EPmain.Global.playerHit = 0;
                            EPmain.Global.kaboom = 0;
                            entityHurtCheck.hurtGlobal.mobCount = 1;
                            e.getEntity().remove();
                        }
                        else if (e.getEntity() instanceof Trident)
                        {
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.configToggleVerbose)
                            {getServer().sendMessage(Component.text("B-Trident-3e Complete. mobImpact was enabled however.", NamedTextColor.GRAY));}
                            //----------------------------------------------------------------------------
                            EPmain.Global.kaboom = 1;
                            worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactMobDamage, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                            EPmain.Global.playerHit = 0;
                            EPmain.Global.kaboom = 0;
                            entityHurtCheck.hurtGlobal.mobCount = 1;
                            e.getEntity().remove();
                        }
                    }
                    else
                    {
                        Location locationBlock = e.getHitBlock().getLocation();
                        World worldBlock = locationBlock.getWorld();

                        if (e.getEntity() instanceof Arrow)
                        {
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.configToggleVerbose)
                            {getServer().sendMessage(Component.text("B-Arrow-3e Complete. mobImpact was disabled however.", NamedTextColor.GRAY));}
                            //----------------------------------------------------------------------------
                            EPmain.Global.kaboom = 1;
                            worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactArrow, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                            EPmain.Global.playerHit = 0;
                            EPmain.Global.kaboom = 0;
                            entityHurtCheck.hurtGlobal.mobCount = 1;
                            e.getEntity().remove();
                        }
                        else if (e.getEntity() instanceof PotionSplashEvent)
                        {
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.configToggleVerbose)
                            {getServer().sendMessage(Component.text("B-Potion-3e Complete. mobImpact was disabled however.", NamedTextColor.GRAY));}
                            //----------------------------------------------------------------------------
                            EPmain.Global.kaboom = 1;
                            worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactPotion, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                            EPmain.Global.playerHit = 0;
                            EPmain.Global.kaboom = 0;
                            entityHurtCheck.hurtGlobal.mobCount = 1;
                            e.getEntity().remove();
                        }
                        else if (e.getEntity() instanceof Snowball)
                        {
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.configToggleVerbose)
                            {getServer().sendMessage(Component.text("B-Snowball-3e Complete. mobImpact was disabled however.", NamedTextColor.GRAY));}
                            //----------------------------------------------------------------------------
                            EPmain.Global.kaboom = 1;
                            worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactSnowball, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                            EPmain.Global.playerHit = 0;
                            EPmain.Global.kaboom = 0;
                            entityHurtCheck.hurtGlobal.mobCount = 1;
                            e.getEntity().remove();
                        }
                        else if (e.getEntity() instanceof Trident)
                        {
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.configToggleVerbose)
                            {getServer().sendMessage(Component.text("B-Trident-3e Complete. mobImpact was disabled however.", NamedTextColor.GRAY));}
                            //----------------------------------------------------------------------------
                            EPmain.Global.kaboom = 1;
                            worldBlock.createExplosion(locationBlock, EPmain.Global.configImpactTrident, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                            EPmain.Global.playerHit = 0;
                            EPmain.Global.kaboom = 0;
                            entityHurtCheck.hurtGlobal.mobCount = 1;
                            e.getEntity().remove();
                        }
                    }
                }
            }
        }
    }
}