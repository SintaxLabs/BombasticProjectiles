# Permissions

With BombasticProjectiles, we want users to have silly fun while providing excellent reassurance for server-safety.

Permissions DO NOT override Feature-Toggles.
> - Ex: Permission and Feature to break blocks must both be enabled to destroy blocks via explosive projectile.

Please read carefully.


# Most to Least Impactful.

bombasticProjectiles.all
> - Gives access to all enabled features.

bombasticProjectiles.projectiles
> - **This must be enabled for anything else to continue.**
> - Gives access to projectiles causing the explosive effect but won't harm.

bombasticProjectiles.breakBlocks
> - Gives access to breaking blocks if that's enabled.

bombasticProjectiles.harmPlayers
> - Gives access to harming players if that's enabled.

bombasticProjectiles.harmMobs
> - Gives access to harming mobs if that's enabled.

bombasticProjectiles.reload
> - Allows user to reload the configuration.
