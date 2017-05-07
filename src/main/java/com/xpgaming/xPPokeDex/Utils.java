package com.xpgaming.xPPokeDex;

import com.google.common.collect.Lists;
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
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.entity.Hotbar;
import org.spongepowered.api.item.inventory.type.GridInventory;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.world.World;

import java.util.List;
import java.util.Optional;

public class Utils {
    private static Utils instance = new Utils();
    public static Utils getInstance() {
        return instance;
    }

    public void runConsoleCommand(String cmd) {
        Sponge.getCommandManager().process(Sponge.getServer().getConsole(), cmd);
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

    public ItemStack shinyToken() {
        ItemStack token = ItemStack.builder()
                .itemType(ItemTypes.PAPER)
                .quantity(1)
                .build();
        token.offer(Keys.DISPLAY_NAME, Text.of(TextColors.GOLD, "Shiny Token"));
        List<Text> lore = Lists.newArrayList(Text.of(TextColors.YELLOW, "Use /pd convert <slot> to\ntransform your currently\nselected Pokemon\ninto a shiny!\n", TextColors.GOLD, "||Shiny Token||"));
        token.offer(Keys.ITEM_LORE, lore);
        return token;
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
