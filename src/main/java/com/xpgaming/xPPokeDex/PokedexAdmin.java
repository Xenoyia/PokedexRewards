package com.xpgaming.xPPokeDex;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;

public class PokedexAdmin implements CommandExecutor {
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if(src instanceof Player) {
            Player player = (Player) src;
            player.sendMessage(Text.of("\u00A7f[\u00A7bPokeDex Admin\u00A7f] \u00A7b\u00A7l-- COMMANDS --"));
            if(player.hasPermission("xpgaming.pokedex.admin")) {
                player.sendMessage(Text.of("  \u00A77> \u00A7b/pokedex reload\u00A7f|\u00A7brl \u00A77- Reload config!"));
                player.sendMessage(Text.of("  \u00A77> \u00A7b/pokedex getshinytoken\u00A7f|\u00A7bgst"));
            }
        } else {
            src.sendMessage(Text.of("\u00A7f[\u00A7bPokeDex Admin\u00A7f] \u00A7b\u00A7l-- COMMANDS --"));
            src.sendMessage(Text.of("  \u00A77> \u00A7b/pokedex reload\u00A7f|\u00A7brl \u00A77- Reload config!"));
            src.sendMessage(Text.of("  \u00A77> \u00A7b/pokedex getshinytoken\u00A7f|\u00A7bgst"));
        }
        return CommandResult.success();
    }

}
