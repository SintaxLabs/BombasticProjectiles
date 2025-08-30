# Introduction
Common issues and FAQ

# FAQ

### Is it safe for Worldguard?
- Sort of. In your regions, set **other-explosions** to false. This will block any BP Explosion.

### Server Performance?
- I haven't got to test it past two players but it never raised any issue with Spark.
- You can set the explosive size smaller and disable Item Drops in the Config file.
- 1.0.7 was a complete rewrite that codensed all logic and checks.

### Can players hit themselves?
- No, this is prevented by default regardless of any condition.

# Common issues and how to resolve them.

### I have tried everything but explosions are not working.
- You missed a permission. *bombasticProjectile.projectiles*
- This permission exists so players dont get the explosive effect despite not being allowed to do anything.
- This permission is mandatory for any feature to work.

### Mobs are destroying everything
- Disable **mobs-Explode-Entities** & **mobs-Explode-Blocks**.
- This prevents them from triggering explosions if they hit a block or player/mob.
- **This is disabled by DEFAULT.**

### XYZ Projectile is not exploding.
- Make sure the projectile is set to true. Only Arrows are enabled by default.

### Blocks not breaking. / Mobs not getting hurt
- You likely enabled permissions. 
- When permissions are enabled, the permission must be added to the player rank AND the feature must be enabled in your config.
