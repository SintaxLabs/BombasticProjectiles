package me.sintaxlabs.bombasticprojectiles1122.listeners;

import me.sintaxlabs.bombasticprojectiles1122.EPmain;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import static org.bukkit.Bukkit.getServer;



public final class entityHurtCheck implements Listener
{
    public static class hurtGlobal
    {
        public static int mobCount = 1;
    }

    @EventHandler
    public void damageCheck (EntityDamageEvent e)
    {
        if (EPmain.Global.kaboom == 1)
        {
            if (e.getEntityType() == EntityType.PLAYER)
            {
                if (!EPmain.Global.configToggleRequirePermission)
                {
                    //Check 00a
                    if (!EPmain.Global.configToggleHurtPlayer)
                    {
                        //Check 01a
                        if (EPmain.Global.configToggleVerbose)
                        {getServer().broadcastMessage("entityHurtCheck - Player Damage is toggled off.");}
                        e.setCancelled(true);
                        //e.setDamage(0);
                    }
                    else if (EPmain.Global.configToggleVerbose)
                    {
                        if(e.getEntityType() != EntityType.DROPPED_ITEM)
                        {
                            getServer().broadcastMessage("entityHurtCheck Success - Player received explosive damage.");
                            hurtGlobal.mobCount ++;
                        }

                    }
                }
                else
                {
                    if (launchCheck.launchGlobal.permHarmPlayers)
                    {
                        //Check 00a
                        if (!EPmain.Global.configToggleHurtPlayer)
                        {
                            if (EPmain.Global.configToggleVerbose)
                            {getServer().broadcastMessage("entityHurtCheck Error - You do not have permission & feature to harm players.");}
                            e.setCancelled(true);
                            //e.setDamage(0);
                        }
                        else if (EPmain.Global.configToggleVerbose)
                        {
                            if(e.getEntityType() != EntityType.DROPPED_ITEM)
                            {
                                getServer().broadcastMessage("entityHurtCheck Success - Player received explosive damage.");
                                hurtGlobal.mobCount ++;
                            }

                        }
                    }
                    else
                    {
                        e.setCancelled(true);
                        //e.setDamage(0);
                        if (EPmain.Global.configToggleVerbose)
                        {getServer().broadcastMessage("entityHurtCheck Error - You do not have permission & feature to harm players.");}
                        if (EPmain.Global.configToggleVerbose)
                        {
                            if(e.getEntityType() != EntityType.DROPPED_ITEM)
                            {
                                hurtGlobal.mobCount ++;
                            }

                        }
                    }
                }

            }
            //-----------------------------------------------------------------------------------------------------
            else if (e.getEntityType() != EntityType.PLAYER)
            {
                if (!EPmain.Global.configToggleRequirePermission)
                {
                    if (!EPmain.Global.configToggleHurtMobs)
                    {
                        e.setCancelled(true);
                        if (EPmain.Global.configToggleVerbose)
                        {
                            if(e.getEntityType() != EntityType.PLAYER)
                            {
                                getServer().broadcastMessage("entityHurtCheck - Mob Damage is toggled off.");
                                hurtGlobal.mobCount ++;
                            }

                        }
                    }
                    else if (EPmain.Global.configToggleVerbose)
                    {
                        if(e.getEntityType() != EntityType.PLAYER)
                        {
                            if (e.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION)
                            {
                                getServer().broadcastMessage("Injured: " + e.getEntityType() + " (" + hurtGlobal.mobCount + ")");
                                hurtGlobal.mobCount ++;
                            }

                        }

                    }
                }
                else
                {
                    if (launchCheck.launchGlobal.permHarmMobs)
                    {
                        if (!EPmain.Global.configToggleHurtMobs)
                        {
                            e.setCancelled(true);
                            //e.setDamage(0);
                            if (EPmain.Global.configToggleVerbose)
                            {
                                if(e.getEntityType() != EntityType.DROPPED_ITEM)
                                {
                                    getServer().broadcastMessage("entityHurtCheck Error - You do not have permission & feature to harm mobs.");
                                    hurtGlobal.mobCount ++;
                                }

                            }
                        }
                        else if (EPmain.Global.configToggleVerbose)
                        {
                            if(e.getEntityType() != EntityType.DROPPED_ITEM)
                            {
                                if (e.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION)
                                {
                                    getServer().broadcastMessage("Injured: " + e.getEntityType() + " (" + hurtGlobal.mobCount + ")");
                                    hurtGlobal.mobCount ++;
                                }

                            }

                        }
                    }
                    else
                    {
                        e.setCancelled(true);
                        //e.setDamage(0);
                        if (EPmain.Global.configToggleVerbose)
                        {
                            getServer().broadcastMessage("entityHurtCheck Error - You do not have permission & feature to harm mobs.");
                        }
                        if (EPmain.Global.configToggleVerbose)
                        {
                            if(e.getEntityType() != EntityType.DROPPED_ITEM)
                            {
                                hurtGlobal.mobCount ++;
                            }

                        }
                    }
                }
            }
        }
    }
}
