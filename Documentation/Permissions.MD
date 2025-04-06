# Permissions

With ExplosiveProjectiles, we want users to have silly fun while providing excellent reassurance for server-safety.

Permissions DO NOT override Feature-Toggles each other. 
> - Ex: Permission and Feature to break blocks must both be enabled to break blocks.

Please read carefully.


# Most to Least Impactful.

explosiveProjectiles.all
> - Gives access to all enabled features.

explosiveProjectiles.projectiles
> - **This must be enabled for anything else to continue.**
> - Gives access to projectiles causing the explosive effect but won't harm.

explosiveProjectiles.breakBlocks
> - Gives access to breaking blocks if that's enabled.

explosiveProjectiles.harmPlayers
> - Gives access to harming players if that's enabled.

explosiveProjectiles.harmMobs
> - Gives access to harming mobs if that's enabled.
