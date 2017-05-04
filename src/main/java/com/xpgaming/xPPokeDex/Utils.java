package com.xpgaming.xPPokeDex;

import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.entity.spawn.SpawnCause;
import org.spongepowered.api.event.cause.entity.spawn.SpawnTypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.entity.Hotbar;
import org.spongepowered.api.item.inventory.type.GridInventory;
import org.spongepowered.api.world.World;

public class Utils {

    public void giveItemStack(ItemStack i, Player player) {
        if(player.getInventory().query(Hotbar.class, GridInventory.class).size() < 36)
        {
            player.getInventory().offer(i);
        }
        else
        {
            World world = player.getLocation().getExtent();
            Entity it = world
                    .createEntity(EntityTypes.ITEM, player.getLocation().getPosition());
                    it.offer(Keys.REPRESENTED_ITEM, i.createSnapshot());
            SpawnCause spawnCause = SpawnCause.builder().type(SpawnTypes.PLUGIN).build();
            world.spawnEntity(it, Cause.source(spawnCause).build());
        }

    }
}
