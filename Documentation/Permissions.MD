# Permissions

With BombasticProjectiles, we want users to have silly fun while providing excellent reassurance for server-safety.

Permissions DO NOT override Feature-Toggles.
> - Features will work if Require-Permissions is set to False.
> - If set to True then Permissions and Features for said feature must both be granted/enabled.

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
