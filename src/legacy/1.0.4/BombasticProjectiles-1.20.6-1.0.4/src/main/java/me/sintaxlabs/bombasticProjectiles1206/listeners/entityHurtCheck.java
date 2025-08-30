package me.sintaxlabs.bombasticProjectiles1206.listeners;

import me.sintaxlabs.bombasticProjectiles1206.EPmain;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
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
                        {getServer().sendMessage(Component.text("entityHurtCheck - Player Damage is toggled off.", NamedTextColor.RED));}
                        e.setCancelled(true);
                        //e.setDamage(0);
                    }
                    else if (EPmain.Global.configToggleVerbose)
                    {
                        if(e.getEntityType() != EntityType.ITEM)
                        {
                            getServer().sendMessage(Component.text("entityHurtCheck Success - Player received explosive damage.", NamedTextColor.GRAY));
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
                            {getServer().sendMessage(Component.text("entityHurtCheck Error - You do not have permission & feature to harm players.", NamedTextColor.RED));}
                            e.setCancelled(true);
                            //e.setDamage(0);
                        }
                        else if (EPmain.Global.configToggleVerbose)
                        {
                            if(e.getEntityType() != EntityType.ITEM)
                            {
                                getServer().sendMessage(Component.text("entityHurtCheck Success - Player received explosive damage.", NamedTextColor.GRAY));
                                hurtGlobal.mobCount ++;
                            }

                        }
                    }
                    else
                    {
                        e.setCancelled(true);
                        //e.setDamage(0);
                        if (EPmain.Global.configToggleVerbose)
                        {getServer().sendMessage(Component.text("entityHurtCheck Error - You do not have permission & feature to harm players.", NamedTextColor.RED));}
                        if (EPmain.Global.configToggleVerbose)
                        {
                            if(e.getEntityType() != EntityType.ITEM)
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
                        //e.setDamage(0);
                        if (EPmain.Global.configToggleVerbose)
                        {
                            if(e.getEntityType() != EntityType.PLAYER)
                            {
                                getServer().sendMessage(Component.text("entityHurtCheck - Mob Damage is toggled off.", NamedTextColor.RED));
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
                                getServer().sendMessage(Component.text("Injured: " + e.getEntityType() + " (" + hurtGlobal.mobCount + ")", NamedTextColor.YELLOW));
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
                                if(e.getEntityType() != EntityType.ITEM)
                                {
                                    getServer().sendMessage(Component.text("entityHurtCheck Error - You do not have permission & feature to harm mobs.", NamedTextColor.RED));
                                    hurtGlobal.mobCount ++;
                                }

                            }
                        }
                        else if (EPmain.Global.configToggleVerbose)
                        {
                            if(e.getEntityType() != EntityType.ITEM)
                            {
                                if (e.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION)
                                {
                                    getServer().sendMessage(Component.text("Injured: " + e.getEntityType() + " (" + hurtGlobal.mobCount + ")", NamedTextColor.YELLOW));
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
                            getServer().sendMessage(Component.text("entityHurtCheck Error - You do not have permission & feature to harm mobs.", NamedTextColor.RED));
                        }
                        if (EPmain.Global.configToggleVerbose)
                        {
                            if(e.getEntityType() != EntityType.ITEM)
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
