package com.xpgaming.xPPokeDex;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;

public class Reload implements CommandExecutor {
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        Config.getInstance().configLoad();
        src.sendMessage(Text.of("\u00A7f[\u00A7bPokeDex\u00A7f] \u00A7b\u00A7lSuccessfully reloaded the config!"));
        return CommandResult.success();
    }

}
