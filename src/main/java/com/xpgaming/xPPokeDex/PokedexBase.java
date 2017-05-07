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
                player.sendMessage(Text.of("  \u00A77> \u00A7b/pokedex count\u00A7f|\u00A7bc \u00A77- Count remaining Pokemon to catch!"));
            }
            if(player.hasPermission("xpgaming.pokedex.remaining")) {
                player.sendMessage(Text.of("  \u00A77> \u00A7b/pokedex remaining\u00A7f|\u00A7br \u00A77- List remaining Pokemon to catch!"));
            }
            if(player.hasPermission("xpgaming.pokedex.claim")) {
                player.sendMessage(Text.of("  \u00A77> \u00A7b/pokedex claim\u00A7f|\u00A7bcl \u00A77- Claim rewards every 10%!"));
            }
            if(player.hasPermission("xpgaming.pokedex.convert")) {
                player.sendMessage(Text.of("  \u00A77> \u00A7b/pokedex convert <slot> \u00A77- Use a shiny token!"));
            }
            if(player.hasPermission("xpgaming.pokedex.admin")) {
                player.sendMessage(Text.of("  \u00A77> \u00A7b/pokedex reload\u00A7f|\u00A7brl \u00A77- Reload config!"));
                player.sendMessage(Text.of("  \u00A77> \u00A7b/pokedex getshinytoken\u00A7f|\u00A7bgst"));
            }
        } else {
            src.sendMessage(Text.of("\u00A7f[\u00A7bPokeDex\u00A7f] \u00A7b\u00A7l-- COMMANDS --"));
            src.sendMessage(Text.of("  \u00A77> \u00A7b/pokedex count\u00A7f|\u00A7bc \u00A77- Count remaining Pokemon to catch!"));
            src.sendMessage(Text.of("  \u00A77> \u00A7b/pokedex remaining\u00A7f|\u00A7br \u00A77- List remaining Pokemon to catch!"));
            src.sendMessage(Text.of("  \u00A77> \u00A7b/pokedex claim\u00A7f|\u00A7bcl \u00A77- Claim rewards every 10%!"));
            src.sendMessage(Text.of("  \u00A77> \u00A7b/pokedex convert <slot> \u00A77- Use a shiny token!"));
            src.sendMessage(Text.of("  \u00A77> \u00A7b/pokedex reload\u00A7f|\u00A7brl \u00A77- Reload config!"));
            src.sendMessage(Text.of("  \u00A77> \u00A7b/pokedex getshinytoken\u00A7f|\u00A7bgst"));
        }
        return CommandResult.success();
    }

}
