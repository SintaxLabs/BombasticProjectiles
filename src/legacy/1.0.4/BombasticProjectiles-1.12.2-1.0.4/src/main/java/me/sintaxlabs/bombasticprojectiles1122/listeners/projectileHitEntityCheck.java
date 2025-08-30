package me.sintaxlabs.bombasticprojectiles1122.listeners;

import me.sintaxlabs.bombasticprojectiles1122.EPmain;
import org.bukkit.Location;
import org.bukkit.World;
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
//----------------------

public final class projectileHitEntityCheck implements Listener
{
    @EventHandler
    public void projectileBlockCheck (ProjectileHitEvent e)
    {
        if (e.getEntity().getShooter() instanceof Player)
        {
            //Now the show starts
            //Check #1 - Entity Hit Check
            if (e.getHitBlock() == null)
            {
                //Projectile Check - Arrow
                //------------------------------------
                if (e.getEntity() instanceof Arrow)
                {
                    if (EPmain.Global.configToggleArrow)
                    {
                        //----------------------------------------------------------------------------
                        if (EPmain.Global.configToggleVerbose)
                        {getServer().broadcastMessage("E-Arrow-1 Complete. ToggleArrow is Enabled.");}
                        //----------------------------------------------------------------------------
                        if (launchCheck.launchGlobal.playerShotItem)
                        {
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.configToggleVerbose)
                            {getServer().broadcastMessage("E-Arrow-2 Complete. playerShotItem flagged.");}
                            //----------------------------------------------------------------------------
                            Location locationEntity = e.getHitEntity().getLocation();
                            World worldEntity = e.getHitEntity().getWorld();
                            Projectile projectile = e.getEntity();
                            Object shooter = projectile.getShooter();

                            //Check #2 - Player Check
                            if (e.getHitEntity() == shooter)
                            {
                                EPmain.Global.playerHit = 1;
                                entityHurtCheck.hurtGlobal.mobCount = 1;
                                e.getEntity().remove();
                                //----------------------------------------------------------------------------
                                if (EPmain.Global.configToggleVerbose)
                                {getServer().broadcastMessage("Shooting yourself is disabled.");}
                                //----------------------------------------------------------------------------
                            }
                            else
                            {
                                if (!EPmain.Global.configToggleRequirePermission)
                                {
                                    if (EPmain.Global.configToggleImpactCustom)
                                    {
                                        //----------------------------------------------------------------------------
                                        if (EPmain.Global.configToggleVerbose)
                                        {getServer().broadcastMessage("E-Arrow-3c Complete. customImpact was enabled.");}
                                        //----------------------------------------------------------------------------
                                        EPmain.Global.kaboom = 1;
                                        worldEntity.createExplosion(locationEntity, EPmain.Global.configImpactArrow, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                        EPmain.Global.playerHit = 0;
                                        EPmain.Global.kaboom = 0;
                                        entityHurtCheck.hurtGlobal.mobCount = 1;
                                        e.getEntity().remove();
                                    }
                                    else
                                    {
                                        //----------------------------------------------------------------------------
                                        if (EPmain.Global.configToggleVerbose)
                                        {getServer().broadcastMessage("E-Arrow-3d Complete. customImpact was disabled however.");}
                                        //----------------------------------------------------------------------------
                                        EPmain.Global.kaboom = 1;
                                        worldEntity.createExplosion(locationEntity, EPmain.Global.configImpactAll, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
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
                                        {getServer().broadcastMessage("E-Arrow-3a-2 Complete. Player had permProjectiles");}
                                        //----------------------------------------------------------------------------
                                        if (launchCheck.launchGlobal.permHarmPlayers)
                                        {
                                            //----------------------------------------------------------------------------
                                            if (EPmain.Global.configToggleVerbose)
                                            {getServer().broadcastMessage("E-Arrow-3E-2 Complete. Player had permHarmPlayers");}
                                            //----------------------------------------------------------------------------
                                            if (EPmain.Global.configToggleImpactCustom)
                                            {
                                                //----------------------------------------------------------------------------
                                                if (EPmain.Global.configToggleVerbose)
                                                {getServer().broadcastMessage("E-Arrow-3c-2 Complete. customImpact was enabled.");}
                                                //----------------------------------------------------------------------------
                                                EPmain.Global.kaboom = 1;
                                                worldEntity.createExplosion(locationEntity, EPmain.Global.configImpactArrow, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                                EPmain.Global.playerHit = 0;
                                                EPmain.Global.kaboom = 0;
                                                entityHurtCheck.hurtGlobal.mobCount = 1;
                                                e.getEntity().remove();
                                            }
                                            else
                                            {
                                                //----------------------------------------------------------------------------
                                                if (EPmain.Global.configToggleVerbose)
                                                {getServer().broadcastMessage("E-Arrow-3d-2 Complete. customImpact was disabled however.");}
                                                //----------------------------------------------------------------------------
                                                EPmain.Global.kaboom = 1;
                                                worldEntity.createExplosion(locationEntity, EPmain.Global.configImpactAll, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
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
                                            {getServer().broadcastMessage("E-Arrow-3e Complete. permHarmPlayers was disabled however.");}
                                            //----------------------------------------------------------------------------
                                            EPmain.Global.kaboom = 1;
                                            worldEntity.createExplosion(locationEntity, EPmain.Global.configImpactAll, false, false);
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
                                        {getServer().broadcastMessage("E-Arrow-3a Failed. Player does not have permProjectiles");}
                                        //----------------------------------------------------------------------------
                                    }
                                }
                            }
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
                        {getServer().broadcastMessage("E-Egg-1 Complete. ToggleEgg is Enabled.");}
                        //----------------------------------------------------------------------------
                        if (launchCheck.launchGlobal.playerShotItem)
                        {
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.configToggleVerbose)
                            {getServer().broadcastMessage("E-Egg-2 Complete. playerShotItem flagged.");}
                            //----------------------------------------------------------------------------
                            Location locationEntity = e.getHitEntity().getLocation();
                            World worldEntity = e.getHitEntity().getWorld();
                            Projectile projectile = e.getEntity();
                            Object shooter = projectile.getShooter();

                            //Check #2 - Player Check
                            if (e.getHitEntity() == shooter)
                            {
                                EPmain.Global.playerHit = 1;
                                entityHurtCheck.hurtGlobal.mobCount = 1;
                                //e.getEntity().remove();
                                //----------------------------------------------------------------------------
                                if (EPmain.Global.configToggleVerbose)
                                {getServer().broadcastMessage("Shooting yourself is disabled.");}
                                //----------------------------------------------------------------------------
                            }
                            else
                            {
                                if (!EPmain.Global.configToggleRequirePermission)
                                {
                                    if (EPmain.Global.configToggleImpactCustom)
                                    {
                                        //----------------------------------------------------------------------------
                                        if (EPmain.Global.configToggleVerbose)
                                        {getServer().broadcastMessage("E-Egg-3c Complete. customImpact was enabled.");}
                                        //----------------------------------------------------------------------------
                                        EPmain.Global.kaboom = 1;
                                        worldEntity.createExplosion(locationEntity, EPmain.Global.configImpactEgg, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                        EPmain.Global.playerHit = 0;
                                        EPmain.Global.kaboom = 0;
                                        entityHurtCheck.hurtGlobal.mobCount = 1;
                                        //e.getEntity().remove();
                                    }
                                    else
                                    {
                                        //----------------------------------------------------------------------------
                                        if (EPmain.Global.configToggleVerbose)
                                        {getServer().broadcastMessage("E-Egg-3d Complete. customImpact was disabled however.");}
                                        //----------------------------------------------------------------------------
                                        EPmain.Global.kaboom = 1;
                                        worldEntity.createExplosion(locationEntity, EPmain.Global.configImpactAll, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
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
                                        {getServer().broadcastMessage("E-Egg-3a-2 Complete. Player had permProjectiles");}
                                        //----------------------------------------------------------------------------
                                        if (launchCheck.launchGlobal.permHarmPlayers)
                                        {
                                            //----------------------------------------------------------------------------
                                            if (EPmain.Global.configToggleVerbose)
                                            {getServer().broadcastMessage("E-Egg-3E-2 Complete. Player had permHarmPlayers");}
                                            //----------------------------------------------------------------------------
                                            if (EPmain.Global.configToggleImpactCustom)
                                            {
                                                //----------------------------------------------------------------------------
                                                if (EPmain.Global.configToggleVerbose)
                                                {getServer().broadcastMessage("E-Egg-3c-2 Complete. customImpact was enabled.");}
                                                //----------------------------------------------------------------------------
                                                EPmain.Global.kaboom = 1;
                                                worldEntity.createExplosion(locationEntity, EPmain.Global.configImpactEgg, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                                EPmain.Global.playerHit = 0;
                                                EPmain.Global.kaboom = 0;
                                                entityHurtCheck.hurtGlobal.mobCount = 1;
                                                //e.getEntity().remove();
                                            }
                                            else
                                            {
                                                //----------------------------------------------------------------------------
                                                if (EPmain.Global.configToggleVerbose)
                                                {getServer().broadcastMessage("E-Egg-3d-2 Complete. customImpact was disabled however.");}
                                                //----------------------------------------------------------------------------
                                                EPmain.Global.kaboom = 1;
                                                worldEntity.createExplosion(locationEntity, EPmain.Global.configImpactAll, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
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
                                            {getServer().broadcastMessage("E-Egg-3e Complete. permHarmPlayers was disabled however.");}
                                            //----------------------------------------------------------------------------
                                            EPmain.Global.kaboom = 1;
                                            worldEntity.createExplosion(locationEntity, EPmain.Global.configImpactAll, false, false);
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
                                        {getServer().broadcastMessage("E-Egg-3a Failed. Player does not have permProjectiles");}
                                        //----------------------------------------------------------------------------
                                    }
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
                        {getServer().broadcastMessage("E-EnderPearl-1 Complete. ToggleEnderPearl is Enabled.");}
                        //----------------------------------------------------------------------------
                        if (launchCheck.launchGlobal.playerShotItem)
                        {
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.configToggleVerbose)
                            {getServer().broadcastMessage("E-EnderPearl-2 Complete. playerShotItem flagged.");}
                            //----------------------------------------------------------------------------
                            Location locationEntity = e.getHitEntity().getLocation();
                            World worldEntity = e.getHitEntity().getWorld();
                            Projectile projectile = e.getEntity();
                            Object shooter = projectile.getShooter();

                            //Check #2 - Player Check
                            if (e.getHitEntity() == shooter)
                            {
                                EPmain.Global.playerHit = 1;
                                entityHurtCheck.hurtGlobal.mobCount = 1;
                                //e.getEntity().remove();
                                //----------------------------------------------------------------------------
                                if (EPmain.Global.configToggleVerbose)
                                {getServer().broadcastMessage("Shooting yourself is disabled.");}
                                //----------------------------------------------------------------------------
                            }
                            else
                            {
                                if (!EPmain.Global.configToggleRequirePermission)
                                {
                                    if (EPmain.Global.configToggleImpactCustom)
                                    {
                                        //----------------------------------------------------------------------------
                                        if (EPmain.Global.configToggleVerbose)
                                        {getServer().broadcastMessage("E-EnderPearl-3c Complete. customImpact was enabled.");}
                                        //----------------------------------------------------------------------------
                                        EPmain.Global.kaboom = 1;
                                        worldEntity.createExplosion(locationEntity, EPmain.Global.configImpactEnderpearl, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                        EPmain.Global.playerHit = 0;
                                        EPmain.Global.kaboom = 0;
                                        entityHurtCheck.hurtGlobal.mobCount = 1;
                                        //e.getEntity().remove();
                                    }
                                    else
                                    {
                                        //----------------------------------------------------------------------------
                                        if (EPmain.Global.configToggleVerbose)
                                        {getServer().broadcastMessage("E-EnderPearl-3d Complete. customImpact was disabled however.");}
                                        //----------------------------------------------------------------------------
                                        EPmain.Global.kaboom = 1;
                                        worldEntity.createExplosion(locationEntity, EPmain.Global.configImpactAll, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
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
                                        {getServer().broadcastMessage("E-EnderPearl-3a-2 Complete. Player had permProjectiles");}
                                        //----------------------------------------------------------------------------
                                        if (launchCheck.launchGlobal.permHarmPlayers)
                                        {
                                            //----------------------------------------------------------------------------
                                            if (EPmain.Global.configToggleVerbose)
                                            {getServer().broadcastMessage("E-EnderPearl-3E-2 Complete. Player had permHarmPlayers");}
                                            //----------------------------------------------------------------------------
                                            if (EPmain.Global.configToggleImpactCustom)
                                            {
                                                //----------------------------------------------------------------------------
                                                if (EPmain.Global.configToggleVerbose)
                                                {getServer().broadcastMessage("E-EnderPearl-3c-2 Complete. customImpact was enabled.");}
                                                //----------------------------------------------------------------------------
                                                EPmain.Global.kaboom = 1;
                                                worldEntity.createExplosion(locationEntity, EPmain.Global.configImpactEnderpearl, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                                EPmain.Global.playerHit = 0;
                                                EPmain.Global.kaboom = 0;
                                                entityHurtCheck.hurtGlobal.mobCount = 1;
                                                //e.getEntity().remove();
                                            }
                                            else
                                            {
                                                //----------------------------------------------------------------------------
                                                if (EPmain.Global.configToggleVerbose)
                                                {getServer().broadcastMessage("E-EnderPearl-3d-2 Complete. customImpact was disabled however.");}
                                                //----------------------------------------------------------------------------
                                                EPmain.Global.kaboom = 1;
                                                worldEntity.createExplosion(locationEntity, EPmain.Global.configImpactAll, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
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
                                            {getServer().broadcastMessage("E-EnderPearl-3e Complete. permHarmPlayers was disabled however.");}
                                            //----------------------------------------------------------------------------
                                            EPmain.Global.kaboom = 1;
                                            worldEntity.createExplosion(locationEntity, EPmain.Global.configImpactAll, false, false);
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
                                        {getServer().broadcastMessage("E-EnderPearl-3a Failed. Player does not have permProjectiles");}
                                        //----------------------------------------------------------------------------
                                    }
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
                        {getServer().broadcastMessage("E-ExpBottle-1 Complete. ToggleExpBottle is Enabled.");}
                        //----------------------------------------------------------------------------
                        if (launchCheck.launchGlobal.playerShotItem)
                        {
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.configToggleVerbose)
                            {getServer().broadcastMessage("E-ExpBottle-2 Complete. playerShotItem flagged.");}
                            //----------------------------------------------------------------------------
                            Location locationEntity = e.getHitEntity().getLocation();
                            World worldEntity = e.getHitEntity().getWorld();
                            Projectile projectile = e.getEntity();
                            Object shooter = projectile.getShooter();

                            //Check #2 - Player Check
                            if (e.getHitEntity() == shooter)
                            {
                                EPmain.Global.playerHit = 1;
                                entityHurtCheck.hurtGlobal.mobCount = 1;
                                //e.getEntity().remove();
                                //----------------------------------------------------------------------------
                                if (EPmain.Global.configToggleVerbose)
                                {getServer().broadcastMessage("Shooting yourself is disabled.");}
                                //----------------------------------------------------------------------------
                            }
                            else
                            {
                                if (!EPmain.Global.configToggleRequirePermission)
                                {
                                    if (EPmain.Global.configToggleImpactCustom)
                                    {
                                        //----------------------------------------------------------------------------
                                        if (EPmain.Global.configToggleVerbose)
                                        {getServer().broadcastMessage("E-ExpBottle-3c Complete. customImpact was enabled.");}
                                        //----------------------------------------------------------------------------
                                        EPmain.Global.kaboom = 1;
                                        worldEntity.createExplosion(locationEntity, EPmain.Global.configImpactExpBottle, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                        EPmain.Global.playerHit = 0;
                                        EPmain.Global.kaboom = 0;
                                        entityHurtCheck.hurtGlobal.mobCount = 1;
                                        //e.getEntity().remove();
                                    }
                                    else
                                    {
                                        //----------------------------------------------------------------------------
                                        if (EPmain.Global.configToggleVerbose)
                                        {getServer().broadcastMessage("E-ExpBottle-3d Complete. customImpact was disabled however");}
                                        //----------------------------------------------------------------------------
                                        EPmain.Global.kaboom = 1;
                                        worldEntity.createExplosion(locationEntity, EPmain.Global.configImpactAll, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
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
                                        {getServer().broadcastMessage("E-ExpBottle-3a-2 Complete. Player had permProjectiles");}
                                        //----------------------------------------------------------------------------
                                        if (launchCheck.launchGlobal.permHarmPlayers)
                                        {
                                            //----------------------------------------------------------------------------
                                            if (EPmain.Global.configToggleVerbose)
                                            {getServer().broadcastMessage("E-ExpBottle-3E-2 Complete. Player had permHarmPlayers");}
                                            //----------------------------------------------------------------------------
                                            if (EPmain.Global.configToggleImpactCustom)
                                            {
                                                //----------------------------------------------------------------------------
                                                if (EPmain.Global.configToggleVerbose)
                                                {getServer().broadcastMessage("E-ExpBottle-3c-2 Complete. customImpact was enabled.");}
                                                //----------------------------------------------------------------------------
                                                EPmain.Global.kaboom = 1;
                                                worldEntity.createExplosion(locationEntity, EPmain.Global.configImpactExpBottle, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                                EPmain.Global.playerHit = 0;
                                                EPmain.Global.kaboom = 0;
                                                entityHurtCheck.hurtGlobal.mobCount = 1;
                                                //e.getEntity().remove();
                                            }
                                            else
                                            {
                                                //----------------------------------------------------------------------------
                                                if (EPmain.Global.configToggleVerbose)
                                                {getServer().broadcastMessage("E-ExpBottle-3d-2 Complete. customImpact was disabled however.");}
                                                //----------------------------------------------------------------------------
                                                EPmain.Global.kaboom = 1;
                                                worldEntity.createExplosion(locationEntity, EPmain.Global.configImpactAll, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
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
                                            {getServer().broadcastMessage("E-ExpBottle-3e Complete. permHarmPlayers was disabled however.");}
                                            //----------------------------------------------------------------------------
                                            EPmain.Global.kaboom = 1;
                                            worldEntity.createExplosion(locationEntity, EPmain.Global.configImpactAll, false, false);
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
                                        {getServer().broadcastMessage("E-ExpBottle-3a Failed. Player does not have permProjectiles");}
                                        //----------------------------------------------------------------------------
                                    }
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
                        {getServer().broadcastMessage("E-FishingBobber-1 Complete. ToggleFishingBobber is Enabled.");}
                        //----------------------------------------------------------------------------
                        if (launchCheck.launchGlobal.playerShotItem)
                        {
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.configToggleVerbose)
                            {getServer().broadcastMessage("E-FishingBobber-2 Complete. playerShotItem flagged.");}
                            //----------------------------------------------------------------------------
                            Location locationEntity = e.getHitEntity().getLocation();
                            World worldEntity = e.getHitEntity().getWorld();
                            Projectile projectile = e.getEntity();
                            Object shooter = projectile.getShooter();

                            //Check #2 - Player Check
                            if (e.getHitEntity() == shooter)
                            {
                                EPmain.Global.playerHit = 1;
                                entityHurtCheck.hurtGlobal.mobCount = 1;
                                //e.getEntity().remove();
                                //----------------------------------------------------------------------------
                                if (EPmain.Global.configToggleVerbose)
                                {getServer().broadcastMessage("Shooting yourself is disabled.");}
                                //----------------------------------------------------------------------------
                            }
                            else
                            {
                                if (!EPmain.Global.configToggleRequirePermission)
                                {
                                    if (EPmain.Global.configToggleImpactCustom)
                                    {
                                        //----------------------------------------------------------------------------
                                        if (EPmain.Global.configToggleVerbose)
                                        {getServer().broadcastMessage("E-FishingBobber-3c Complete. customImpact was enabled.");}
                                        //----------------------------------------------------------------------------
                                        EPmain.Global.kaboom = 1;
                                        worldEntity.createExplosion(locationEntity, EPmain.Global.configImpactFishingBobber, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                        EPmain.Global.playerHit = 0;
                                        EPmain.Global.kaboom = 0;
                                        entityHurtCheck.hurtGlobal.mobCount = 1;
                                        //e.getEntity().remove();
                                    }
                                    else
                                    {
                                        //----------------------------------------------------------------------------
                                        if (EPmain.Global.configToggleVerbose)
                                        {getServer().broadcastMessage("E-FishingBobber-3d Complete. customImpact was disabled however.");}
                                        //----------------------------------------------------------------------------
                                        EPmain.Global.kaboom = 1;
                                        worldEntity.createExplosion(locationEntity, EPmain.Global.configImpactAll, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
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
                                        {getServer().broadcastMessage("E-FishingBobber-3a-2 Complete. Player had permProjectiles");}
                                        //----------------------------------------------------------------------------
                                        if (launchCheck.launchGlobal.permHarmPlayers)
                                        {
                                            //----------------------------------------------------------------------------
                                            if (EPmain.Global.configToggleVerbose)
                                            {getServer().broadcastMessage("E-FishingBobber-3E-2 Complete. Player had permHarmPlayers");}
                                            //----------------------------------------------------------------------------
                                            if (EPmain.Global.configToggleImpactCustom)
                                            {
                                                //----------------------------------------------------------------------------
                                                if (EPmain.Global.configToggleVerbose)
                                                {getServer().broadcastMessage("E-FishingBobber-3c-2 Complete. customImpact was enabled.");}
                                                //----------------------------------------------------------------------------
                                                EPmain.Global.kaboom = 1;
                                                worldEntity.createExplosion(locationEntity, EPmain.Global.configImpactFishingBobber, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                                EPmain.Global.playerHit = 0;
                                                EPmain.Global.kaboom = 0;
                                                entityHurtCheck.hurtGlobal.mobCount = 1;
                                                //e.getEntity().remove();
                                            }
                                            else
                                            {
                                                //----------------------------------------------------------------------------
                                                if (EPmain.Global.configToggleVerbose)
                                                {getServer().broadcastMessage("E-FishingBobber-3d-2 Complete. customImpact was disabled however.");}
                                                //----------------------------------------------------------------------------
                                                EPmain.Global.kaboom = 1;
                                                worldEntity.createExplosion(locationEntity, EPmain.Global.configImpactAll, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
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
                                            {getServer().broadcastMessage("E-FishingBobber-3e Complete. permHarmPlayers was disabled however.");}
                                            //----------------------------------------------------------------------------
                                            EPmain.Global.kaboom = 1;
                                            worldEntity.createExplosion(locationEntity, EPmain.Global.configImpactAll, false, false);
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
                                        {getServer().broadcastMessage("E-FishingBobber-3a Failed. Player does not have permProjectiles");}
                                        //----------------------------------------------------------------------------
                                    }
                                }
                            }
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
                        {getServer().broadcastMessage("E-Potion-1 Complete. TogglePotion is Enabled.");}
                        //----------------------------------------------------------------------------
                        if (launchCheck.launchGlobal.playerShotItem)
                        {
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.configToggleVerbose)
                            {getServer().broadcastMessage("E-Potion-2 Complete. playerShotItem flagged.");}
                            //----------------------------------------------------------------------------
                            Location locationEntity = e.getHitEntity().getLocation();
                            World worldEntity = e.getHitEntity().getWorld();
                            Projectile projectile = e.getEntity();
                            Object shooter = projectile.getShooter();

                            //Check #2 - Player Check
                            if (e.getHitEntity() == shooter)
                            {
                                EPmain.Global.playerHit = 1;
                                entityHurtCheck.hurtGlobal.mobCount = 1;
                                //e.getEntity().remove();
                                //----------------------------------------------------------------------------
                                if (EPmain.Global.configToggleVerbose)
                                {getServer().broadcastMessage("Shooting yourself is disabled.");}
                                //----------------------------------------------------------------------------
                            }
                            else
                            {
                                if (!EPmain.Global.configToggleRequirePermission)
                                {
                                    if (EPmain.Global.configToggleImpactCustom)
                                    {
                                        //----------------------------------------------------------------------------
                                        if (EPmain.Global.configToggleVerbose)
                                        {getServer().broadcastMessage("E-Potion-3c Complete. customImpact was enabled.");}
                                        //----------------------------------------------------------------------------
                                        EPmain.Global.kaboom = 1;
                                        worldEntity.createExplosion(locationEntity, EPmain.Global.configImpactPotion, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                        EPmain.Global.playerHit = 0;
                                        EPmain.Global.kaboom = 0;
                                        entityHurtCheck.hurtGlobal.mobCount = 1;
                                        //e.getEntity().remove();
                                    }
                                    else
                                    {
                                        //----------------------------------------------------------------------------
                                        if (EPmain.Global.configToggleVerbose)
                                        {getServer().broadcastMessage("E-Potion-3d Complete. customImpact was disabled however.");}
                                        //----------------------------------------------------------------------------
                                        EPmain.Global.kaboom = 1;
                                        worldEntity.createExplosion(locationEntity, EPmain.Global.configImpactAll, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
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
                                        {getServer().broadcastMessage("E-Potion-3a-2 Complete. Player had permProjectiles");}
                                        //----------------------------------------------------------------------------
                                        if (launchCheck.launchGlobal.permHarmPlayers)
                                        {
                                            //----------------------------------------------------------------------------
                                            if (EPmain.Global.configToggleVerbose)
                                            {getServer().broadcastMessage("E-Potion-3E-2 Complete. Player had permHarmPlayers");}
                                            //----------------------------------------------------------------------------
                                            if (EPmain.Global.configToggleImpactCustom)
                                            {
                                                //----------------------------------------------------------------------------
                                                if (EPmain.Global.configToggleVerbose)
                                                {getServer().broadcastMessage("E-Potion-3c-2 Complete. customImpact was enabled.");}
                                                //----------------------------------------------------------------------------
                                                EPmain.Global.kaboom = 1;
                                                worldEntity.createExplosion(locationEntity, EPmain.Global.configImpactPotion, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                                EPmain.Global.playerHit = 0;
                                                EPmain.Global.kaboom = 0;
                                                entityHurtCheck.hurtGlobal.mobCount = 1;
                                                //e.getEntity().remove();
                                            }
                                            else
                                            {
                                                //----------------------------------------------------------------------------
                                                if (EPmain.Global.configToggleVerbose)
                                                {getServer().broadcastMessage("E-Potion-3d-2 Complete. customImpact was disabled however.");}
                                                //----------------------------------------------------------------------------
                                                EPmain.Global.kaboom = 1;
                                                worldEntity.createExplosion(locationEntity, EPmain.Global.configImpactAll, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
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
                                            {getServer().broadcastMessage("E-Potion-3e Complete. permHarmPlayers was disabled however.");}
                                            //----------------------------------------------------------------------------
                                            EPmain.Global.kaboom = 1;
                                            worldEntity.createExplosion(locationEntity, EPmain.Global.configImpactAll, false, false);
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
                                        {getServer().broadcastMessage("E-Potion-3a Failed. Player does not have permProjectiles");}
                                        //----------------------------------------------------------------------------
                                    }
                                }
                            }
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
                        {getServer().broadcastMessage("E-Snowball-1 Complete. ToggleSnowball is Enabled.");}
                        //----------------------------------------------------------------------------
                        if (launchCheck.launchGlobal.playerShotItem)
                        {
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.configToggleVerbose)
                            {getServer().broadcastMessage("E-Snowball-2 Complete. playerShotItem flagged.");}
                            //----------------------------------------------------------------------------
                            Location locationEntity = e.getHitEntity().getLocation();
                            World worldEntity = e.getHitEntity().getWorld();
                            Projectile projectile = e.getEntity();
                            Object shooter = projectile.getShooter();

                            //Check #2 - Player Check
                            if (e.getHitEntity() == shooter)
                            {
                                EPmain.Global.playerHit = 1;
                                entityHurtCheck.hurtGlobal.mobCount = 1;
                                //e.getEntity().remove();
                                //----------------------------------------------------------------------------
                                if (EPmain.Global.configToggleVerbose)
                                {getServer().broadcastMessage("Shooting yourself is disabled.");}
                                //----------------------------------------------------------------------------
                            }
                            else
                            {
                                if (!EPmain.Global.configToggleRequirePermission)
                                {
                                    if (EPmain.Global.configToggleImpactCustom)
                                    {
                                        //----------------------------------------------------------------------------
                                        if (EPmain.Global.configToggleVerbose)
                                        {getServer().broadcastMessage("E-Snowball-3c Complete. customImpact was enabled.");}
                                        //----------------------------------------------------------------------------
                                        EPmain.Global.kaboom = 1;
                                        worldEntity.createExplosion(locationEntity, EPmain.Global.configImpactSnowball, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                        EPmain.Global.playerHit = 0;
                                        EPmain.Global.kaboom = 0;
                                        entityHurtCheck.hurtGlobal.mobCount = 1;
                                        //e.getEntity().remove();
                                    }
                                    else
                                    {
                                        //----------------------------------------------------------------------------
                                        if (EPmain.Global.configToggleVerbose)
                                        {getServer().broadcastMessage("E-Snowball-3d Complete. customImpact was disabled however.");}
                                        //----------------------------------------------------------------------------
                                        EPmain.Global.kaboom = 1;
                                        worldEntity.createExplosion(locationEntity, EPmain.Global.configImpactAll, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
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
                                        {getServer().broadcastMessage("E-Snowball-3a-2 Complete. Player had permProjectiles");}
                                        //----------------------------------------------------------------------------
                                        if (launchCheck.launchGlobal.permHarmPlayers)
                                        {
                                            //----------------------------------------------------------------------------
                                            if (EPmain.Global.configToggleVerbose)
                                            {getServer().broadcastMessage("E-Snowball-3E-2 Complete. Player had permHarmPlayers");}
                                            //----------------------------------------------------------------------------
                                            if (EPmain.Global.configToggleImpactCustom)
                                            {
                                                //----------------------------------------------------------------------------
                                                if (EPmain.Global.configToggleVerbose)
                                                {getServer().broadcastMessage("E-Snowball-3c-2 Complete. customImpact was enabled.");}
                                                //----------------------------------------------------------------------------
                                                EPmain.Global.kaboom = 1;
                                                worldEntity.createExplosion(locationEntity, EPmain.Global.configImpactSnowball, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                                                EPmain.Global.playerHit = 0;
                                                EPmain.Global.kaboom = 0;
                                                entityHurtCheck.hurtGlobal.mobCount = 1;
                                                //e.getEntity().remove();
                                            }
                                            else
                                            {
                                                //----------------------------------------------------------------------------
                                                if (EPmain.Global.configToggleVerbose)
                                                {getServer().broadcastMessage("E-Snowball-3d-2 Complete. customImpact was disabled however.");}
                                                //----------------------------------------------------------------------------
                                                EPmain.Global.kaboom = 1;
                                                worldEntity.createExplosion(locationEntity, EPmain.Global.configImpactAll, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
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
                                            {getServer().broadcastMessage("E-Snowball-3e Complete. permHarmPlayers was disabled however.");}
                                            //----------------------------------------------------------------------------
                                            EPmain.Global.kaboom = 1;
                                            worldEntity.createExplosion(locationEntity, EPmain.Global.configImpactAll, false, false);
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
                                        {getServer().broadcastMessage("E-Snowball-3a Failed. Player does not have permProjectiles");}
                                        //----------------------------------------------------------------------------
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        else
        {
            if (e.getHitBlock() == null)
            {
                if (EPmain.Global.configToggleMobsExplodeEntities)
                {
                    if (EPmain.Global.configToggleMobImpact)
                    {
                        Location  locationEntity = e.getHitEntity().getLocation();
                        World worldBlock = locationEntity.getWorld();

                        if (e.getEntity() instanceof Arrow)
                        {
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.configToggleVerbose)
                            {getServer().broadcastMessage("E-Arrow-3e Complete. mobImpact was enabled however.");}
                            //----------------------------------------------------------------------------
                            EPmain.Global.kaboom = 1;
                            worldBlock.createExplosion(locationEntity, EPmain.Global.configImpactMobDamage, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                            EPmain.Global.playerHit = 0;
                            EPmain.Global.kaboom = 0;
                            entityHurtCheck.hurtGlobal.mobCount = 1;
                            //e.getEntity().remove();
                        }
                        else if (e.getEntity() instanceof ThrownPotion)
                        {
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.configToggleVerbose)
                            {getServer().broadcastMessage("E-Potion-3e Complete. mobImpact was enabled however.");}
                            //----------------------------------------------------------------------------
                            EPmain.Global.kaboom = 1;
                            worldBlock.createExplosion(locationEntity, EPmain.Global.configImpactMobDamage, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                            EPmain.Global.playerHit = 0;
                            EPmain.Global.kaboom = 0;
                            entityHurtCheck.hurtGlobal.mobCount = 1;
                            //e.getEntity().remove();
                        }
                        else if (e.getEntity() instanceof Snowball)
                        {
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.configToggleVerbose)
                            {getServer().broadcastMessage("E-Snowball-3e Complete. mobImpact was enabled however.");}
                            //----------------------------------------------------------------------------
                            EPmain.Global.kaboom = 1;
                            worldBlock.createExplosion(locationEntity, EPmain.Global.configImpactMobDamage, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                            EPmain.Global.playerHit = 0;
                            EPmain.Global.kaboom = 0;
                            entityHurtCheck.hurtGlobal.mobCount = 1;
                            //e.getEntity().remove();
                        }
                    }
                    else
                    {
                        Location  locationEntity = e.getHitEntity().getLocation();
                        World worldBlock = locationEntity.getWorld();

                        if (e.getEntity() instanceof Arrow)
                        {
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.configToggleVerbose)
                            {getServer().broadcastMessage("E-Arrow-3e Complete. mobImpact was disabled however.");}
                            //----------------------------------------------------------------------------
                            EPmain.Global.kaboom = 1;
                            worldBlock.createExplosion(locationEntity, EPmain.Global.configImpactArrow, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                            EPmain.Global.playerHit = 0;
                            EPmain.Global.kaboom = 0;
                            entityHurtCheck.hurtGlobal.mobCount = 1;
                            //e.getEntity().remove();
                        }
                        else if (e.getEntity() instanceof PotionSplashEvent)
                        {
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.configToggleVerbose)
                            {getServer().broadcastMessage("E-Potion-3e Complete. mobImpact was disabled however.");}
                            //----------------------------------------------------------------------------
                            EPmain.Global.kaboom = 1;
                            worldBlock.createExplosion(locationEntity, EPmain.Global.configImpactPotion, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                            EPmain.Global.playerHit = 0;
                            EPmain.Global.kaboom = 0;
                            entityHurtCheck.hurtGlobal.mobCount = 1;
                            //e.getEntity().remove();
                        }
                        else if (e.getEntity() instanceof Snowball)
                        {
                            //----------------------------------------------------------------------------
                            if (EPmain.Global.configToggleVerbose)
                            {getServer().broadcastMessage("E-Snowball-3e Complete. mobImpact was disabled however.");}
                            //----------------------------------------------------------------------------
                            EPmain.Global.kaboom = 1;
                            worldBlock.createExplosion(locationEntity, EPmain.Global.configImpactSnowball, EPmain.Global.configToggleFire, EPmain.Global.configToggleBreakBlocks);
                            EPmain.Global.playerHit = 0;
                            EPmain.Global.kaboom = 0;
                            entityHurtCheck.hurtGlobal.mobCount = 1;
                            //e.getEntity().remove();
                        }
                    }
                }
            }
        }
    }
}