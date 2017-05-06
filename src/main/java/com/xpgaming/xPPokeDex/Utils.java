package com.xpgaming.xPPokeDex;

import com.pixelmonmod.pixelmon.enums.EnumPokemon;
import com.pixelmonmod.pixelmon.storage.PixelmonStorage;
import com.pixelmonmod.pixelmon.storage.PlayerStorage;
import net.minecraft.entity.player.EntityPlayerMP;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.entity.spawn.SpawnCause;
import org.spongepowered.api.event.cause.entity.spawn.SpawnTypes;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.entity.Hotbar;
import org.spongepowered.api.item.inventory.type.GridInventory;
import org.spongepowered.api.world.World;

import java.util.Optional;

public class Utils {
    private static Utils instance = new Utils();
    public static Utils getInstance() {
        return instance;
    }

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

    public double calcPercent(EntityPlayerMP entity) {
        Optional<PlayerStorage> optstorage = PixelmonStorage.pokeBallManager.getPlayerStorage(entity);
        if(optstorage.isPresent()) {
            int caught = ((PlayerStorage) optstorage.get()).pokedex.countCaught();
            double percent = (double) caught / (double) EnumPokemon.values().length * 100.00;
            return percent;
        }
        return 0.0;
    }

    public boolean hasClaimed(Player p, String pct) {
        return Config.getInstance().getConfig().getNode("playerData", p.getUniqueId().toString(), pct).getBoolean();
    }
}
