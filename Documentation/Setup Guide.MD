## Introduction
This plugin features a lot of measures to prevent accidental destruction of a server.

There are a handful of permissions and configurations that must work together to get the result you want.

## Things to know.
1. Permissions DO NOT override features. If you enable permissions, make sure the permission is added and the feature is toggled.

2. Mobs can be toggled to cause explosions. **Enable mobs-Explode-Entities** or **mobs-Explode-Blocks.**

This allows the explosion to occur if they hit a block or player/mob. **toggle-BreakBlocks** must be set to TRUE.


## Scenario 1
In this example, you are wanting Tridents and Eggs to harm players but not mobs nor breaking blocks.

You also only want VIP Players to access this.

1. In your config, disable Arrows, enable Tridents and Eggs.

2. toggle-HurtPlayer: **true**

3. require-Permission: **true**

4. toggle-BreakBlocks: **false**

5. Add the following permissions to your VIP rank:
- bombasticProjectiles.projectiles
- bombasticProjectiles.harmPlayers



## Scenario 2
In this example, you want Bows to have a gigantic impact but Eggs have a tiny impact.

You also want no player damage but mobs can be killed.

1. In your config, enable Eggs.

2. impact-Custom: **true**

2. toggle-HurtMobs: **true**

3. Egg-Impact: 1

4. Arrow-Impact: 25
