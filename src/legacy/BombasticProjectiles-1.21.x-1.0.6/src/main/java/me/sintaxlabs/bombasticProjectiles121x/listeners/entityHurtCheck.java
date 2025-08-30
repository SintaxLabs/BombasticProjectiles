package me.sintaxlabs.bombasticProjectiles121x.listeners;

import me.sintaxlabs.bombasticProjectiles121x.EPmain;
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
        if (EPmain.Global.kaboom)
        {
            //First Check: If a mob shot, lets check player and mob damage toggles.
            if (launchCheck.launchGlobal.mobShotItem)
            {
                if (e.getEntityType() == EntityType.PLAYER)
                {
                    if (!EPmain.Global.configToggleHurtPlayer)
                    {
                        //Check 01a
                        if (EPmain.Global.configToggleVerbose)
                        {getServer().sendMessage(Component.text("entityHurtCheck Notice - Player Damage is toggled off.", NamedTextColor.YELLOW));}
                        e.setCancelled(true);
                        //e.setDamage(0);
                    }
                    else if (EPmain.Global.configToggleVerbose)
                    {
                        if(e.getEntityType() != EntityType.ITEM)
                        {
                            getServer().sendMessage(Component.text("entityHurtCheck Success - Player received explosive damage.", NamedTextColor.GREEN));
                            hurtGlobal.mobCount ++;
                        }

                    }
                }
                else if (e.getEntityType() != EntityType.PLAYER)
                {
                    if (!EPmain.Global.configToggleHurtMobs)
                    {
                        e.setCancelled(true);
                        //e.setDamage(0);
                        if (EPmain.Global.configToggleVerbose)
                        {
                            if(e.getEntityType() != EntityType.PLAYER)
                            {
                                getServer().sendMessage(Component.text("entityHurtCheck Notice - Mob Damage is toggled off.", NamedTextColor.YELLOW));
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
                                getServer().sendMessage(Component.text("Injured: " + e.getEntityType() + " (" + hurtGlobal.mobCount + ")", NamedTextColor.GREEN));
                                hurtGlobal.mobCount ++;
                            }
                        }
                    }
                }
            }

            //Second Check, okay so a player shot, lets run perm and toggle checks.
            else if (e.getEntityType() == EntityType.PLAYER)
            {
                if (!EPmain.Global.configToggleRequirePermission)
                {
                    //Check 00a
                    if (!EPmain.Global.configToggleHurtPlayer)
                    {
                        //Check 01a
                        if (EPmain.Global.configToggleVerbose)
                        {getServer().sendMessage(Component.text("entityHurtCheck Notice - Player Damage is toggled off.", NamedTextColor.YELLOW));}
                        e.setCancelled(true);
                        //e.setDamage(0);
                    }
                    else if (EPmain.Global.configToggleVerbose)
                    {
                        if(e.getEntityType() != EntityType.ITEM)
                        {
                            getServer().sendMessage(Component.text("entityHurtCheck Success - Player received explosive damage.", NamedTextColor.GREEN));
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
                            {getServer().sendMessage(Component.text("entityHurtCheck Error - You have permission to harm players but do not have the feature to.", NamedTextColor.RED));}
                            e.setCancelled(true);
                            //e.setDamage(0);
                        }
                        else if (EPmain.Global.configToggleVerbose)
                        {
                            if(e.getEntityType() != EntityType.ITEM)
                            {
                                getServer().sendMessage(Component.text("entityHurtCheck Success - Player received explosive damage.", NamedTextColor.GREEN));
                                hurtGlobal.mobCount ++;
                            }

                        }
                    }
                    else
                    {
                        e.setCancelled(true);
                        //e.setDamage(0);
                        if (EPmain.Global.configToggleVerbose)
                        {getServer().sendMessage(Component.text("entityHurtCheck Error - You do not have permission to hurt players despite asking for it.", NamedTextColor.RED));}
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
                                getServer().sendMessage(Component.text("entityHurtCheck Notice - Mob Damage is toggled off.", NamedTextColor.YELLOW));
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
                                getServer().sendMessage(Component.text("Injured: " + e.getEntityType() + " (" + hurtGlobal.mobCount + ")", NamedTextColor.GREEN));
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
                                    getServer().sendMessage(Component.text("entityHurtCheck Error - You have permission to harm mobs but do not have the feature to.", NamedTextColor.RED));
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
                                    getServer().sendMessage(Component.text("Injured: " + e.getEntityType() + " (" + hurtGlobal.mobCount + ")", NamedTextColor.GREEN));
                                    hurtGlobal.mobCount ++;
                                }

                            }

                        }
                    }
                    else
                    {
                        e.setCancelled(true);
                        if (EPmain.Global.configToggleVerbose)
                        {
                            getServer().sendMessage(Component.text("entityHurtCheck Error - You do not have permission to hurt mobs despite asking for it.", NamedTextColor.RED));
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
