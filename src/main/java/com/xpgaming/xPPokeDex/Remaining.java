package com.xpgaming.xPPokeDex;

import com.pixelmonmod.pixelmon.enums.EnumPokemon;
import com.pixelmonmod.pixelmon.pokedex.Pokedex;
import com.pixelmonmod.pixelmon.storage.PixelmonStorage;
import com.pixelmonmod.pixelmon.storage.PlayerStorage;
import net.minecraft.entity.player.EntityPlayerMP;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.service.pagination.PaginationList;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Remaining implements CommandExecutor {
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if(src instanceof Player) {
            Player player = (Player) src;
            EntityPlayerMP entity = (EntityPlayerMP) src;
            Optional<PlayerStorage> optstorage = PixelmonStorage.pokeBallManager.getPlayerStorage(entity);
            if(optstorage.isPresent()) {
                List<Text> contents = new ArrayList<>();
                for(EnumPokemon e : EnumPokemon.values()) {
                    int id = Pokedex.nameToID(e.toString());
                    if(!optstorage.get().pokedex.hasCaught(id)) {
                        if(EnumPokemon.legendaries.contains(e.toString())) {
                            contents.add(Text.of("\u00A76"+e.toString()));
                        } else contents.add(Text.of("\u00A7e"+e.toString()));
                    }
                }
                PaginationList.builder()
                        .title(Text.builder("Pokemon Remaining").color(TextColors.GOLD).build())
                        .contents(contents)
                        .padding(Text.builder("-").color(TextColors.YELLOW).build())
                        .sendTo(player);
               }

        } else {
            src.sendMessage(Text.of("\u00A7f[\u00A7cPokeDex\u00A7f] \u00A7cYou need to be a player to run this command!"));
        }
        return CommandResult.success();
    }
}
