package com.xpgaming.xPPokeDex;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;

public class PokedexBase implements CommandExecutor {
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if(src instanceof Player) {
            Player player = (Player) src;
            player.sendMessage(Text.of("\u00A7f[\u00A7bPokeDex\u00A7f] \u00A7b\u00A7l-- COMMANDS --"));
            if(player.hasPermission("xpgaming.pokedex.count")) {
                player.sendMessage(Text.of("  \u00A77> \u00A7b/pokedex count \u00A77- Count remaining Pokemon to catch!"));
            }
            if(player.hasPermission("xpgaming.pokedex.remaining")) {
                player.sendMessage(Text.of("  \u00A77> \u00A7b/pokedex remaining \u00A77- List remaining Pokemon to catch!"));
            }
        } else {
            src.sendMessage(Text.of("\u00A7f[\u00A7bPokeDex\u00A7f] \u00A7b\u00A7l-- COMMANDS --"));
            src.sendMessage(Text.of("  \u00A77> \u00A7b/pokedex count \u00A77- Count remaining Pokemon to catch!"));
            src.sendMessage(Text.of("  \u00A77> \u00A7b/pokedex remaining \u00A77- List remaining Pokemon to catch!"));
        }
        return CommandResult.success();
    }

}
