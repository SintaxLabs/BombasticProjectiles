# Introduction
Common issues and FAQ

# FAQ

### What is "mob-Explode-Blocks" & "mob-Explode-Entities?"
- This enables explosions from mobs such as Skeletons if it hits a player/mob or any block.
- This prevents unnecessary explosions and does not mean it will break blocks.

### Can players hit themselves?
- No, this is prevented by default regardless of any condition.
- This does not effect players that dont have the permission: bombasticProjectiles.projectiles

# Common issues and how to resolve them.

### I have tried everything but explosions are not working.
- You missed a permission. *bombasticProjectile.projectiles*
- This permission exists so players dont get the explosive effect despite not being allowed to do anything.
- This permission is mandatory for any feature to work.

### Mobs are destroying everything
- Disable **mobs-Explode-Entities** & **mobs-Explode-Blocks**.
- This prevents them from triggering explosions if they hit a block or player/mob.

**This is disabled by DEFAULT.**

### XYZ Projectile is not exploding.
- Make sure the projectile is set to true. Only Arrows are enabled by default.

### Blocks not breaking. / Mobs not getting hurt
- You likely enabled permissions. 
- When permissions are enabled, the permission must be added to the player rank AND the feature must be enabled in your config.
