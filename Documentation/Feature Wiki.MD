## Introduction
This plugin features a lot of measures to prevent accidental destruction of a server.

There are a handful of permissions and configurations that must work together to get the result you want.

## Things to know.
1. Permissions DO NOT override features. If you enable permissions, make sure the permission is added and the feature is toggled.

2. Mobs can be toggled to cause explosions. **Enable mobs-Explode-Entities** or **mobs-Explode-Blocks.**
- This allows the explosion to occur if they hit a block or player/mob. **toggle-BreakBlocks** must be set to TRUE.


## Permissions
- If you enable permissions, make sure the permission is added and the feature is toggled.
- Permissions are a great measure for limiting access.

## Protect Certain Blocks / Items / Mobs
- Config: ProtectedBlocks & ProtectedEntities
- The protection lists cannot be disabled. Simply leave NULL if you want no protections.
- If you want to protect item entities, place them in ProtectedEntities.

## Disable Certain Worlds
- If you have a certain dimension or world on your server, you can protect it by entering the name of its folder!
- It even blocks players from sending projectiles through portals!

## Togglable Named Mob Damage
- Have pets with names? Spawn Villagers?
- Protect them by toggling **HurtNamedMobs** in the Config.
- All named mobs are protected, I see no need in making it into another list.

## Togglable Player/Mob Damage.
- Prevent damage to Players and Mobs!
- Great for PVE servers.

## Togglable Player/Mob Block Breaking
- Prevent blocks getting exploded from Players and or Mobs.
- Maybe you want tougher Skeletons and Drowned without the mess.

## Togglable Item Dropping
- Reduce unnecessary mess and potential lag by setting this to True.

## Togglable Mob Impact
- This can set Mobs to have their projectiles tougher or weaker than players.
- You can also customize their damage in the Config.

## Configure explosive power and fire aspect
- Set the global power damage or if explosions should have the firy aspect of Ghasts.

## Configure individual projectile explosives
- Maybe you want snowballs to be weak while Tridents are devastating.
- Tweak every projectile by toggling CustomImpact.
