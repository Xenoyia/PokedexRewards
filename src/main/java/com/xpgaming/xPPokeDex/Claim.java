package com.xpgaming.xPPokeDex;

import com.google.common.reflect.TypeToken;
import com.pixelmonmod.pixelmon.enums.EnumPokemon;
import net.minecraft.entity.player.EntityPlayerMP;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.Text;

import java.util.List;
import java.util.UUID;

public class Claim implements CommandExecutor {
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if(src instanceof Player) {
            Player player = (Player) src;
            UUID uuid = player.getUniqueId();
            double percent = Utils.getInstance().calcPercent((EntityPlayerMP) player);
            int numClaimed = 0;
            if(percent >= 10) {
                // Eligible for 10% reward!
                if(!Utils.getInstance().hasClaimed(player, "10")) {
                    // And you haven't claimed it already, woo!
                    try {
                        numClaimed++;
                        player.sendMessage(Text.of("\u00A7f[\u00A7bPokeDex\u00A7f] \u00A7bYou have claimed the \u00A7f10% \u00A7breward!"));
                        Config.getInstance().getConfig().getNode("playerData", player.getUniqueId().toString(), "10").setValue(true);
                        Config.getInstance().saveAndLoadConfig();
                        int numRewards = Config.getInstance().getConfig().getNode("rewards", "reward10", "numberOfRewards").getInt();
                        for(int i = 1; i < numRewards+1; i++) {
                            ItemStack item = Config.getInstance().getConfig().getNode("rewards", "reward10", String.valueOf(i)).getValue(TypeToken.of(ItemStack.class));
                            Utils.getInstance().giveItemStack(item, player);
                        }

                    } catch (ObjectMappingException e) { e.printStackTrace(); }
                }
            }
            if(percent >= 20) {
                // Eligible for 20% reward!
                if(!Utils.getInstance().hasClaimed(player, "20")) {
                    // And you haven't claimed it already, woo!
                    try {
                        numClaimed++;
                        player.sendMessage(Text.of("\u00A7f[\u00A7bPokeDex\u00A7f] \u00A7bYou have claimed the \u00A7f20% \u00A7breward!"));
                        Config.getInstance().getConfig().getNode("playerData", player.getUniqueId().toString(), "20").setValue(true);
                        Config.getInstance().saveAndLoadConfig();
                        int numRewards = Config.getInstance().getConfig().getNode("rewards", "reward20", "numberOfRewards").getInt();
                        for(int i = 1; i < numRewards+1; i++) {
                            ItemStack item = Config.getInstance().getConfig().getNode("rewards", "reward20", i).getValue(TypeToken.of(ItemStack.class));
                            Utils.getInstance().giveItemStack(item, player);
                        }
                    } catch (ObjectMappingException e) { e.printStackTrace(); }
                }
            }
            if(percent >= 30) {
                // Eligible for 30% reward!
                if(!Utils.getInstance().hasClaimed(player, "30")) {
                    // And you haven't claimed it already, woo!
                    try {
                        numClaimed++;
                        player.sendMessage(Text.of("\u00A7f[\u00A7bPokeDex\u00A7f] \u00A7bYou have claimed the \u00A7f30% \u00A7breward!"));
                        Config.getInstance().getConfig().getNode("playerData", player.getUniqueId().toString(), "30").setValue(true);
                        Config.getInstance().saveAndLoadConfig();
                        int numRewards = Config.getInstance().getConfig().getNode("rewards", "reward30", "numberOfRewards").getInt();
                        for(int i = 1; i < numRewards+1; i++) {
                            ItemStack item = Config.getInstance().getConfig().getNode("rewards", "reward30", i).getValue(TypeToken.of(ItemStack.class));
                            Utils.getInstance().giveItemStack(item, player);
                        }
                    } catch (ObjectMappingException e) { e.printStackTrace(); }
                }
            }
            if(percent >= 40) {
                // Eligible for 40% reward!
                if(!Utils.getInstance().hasClaimed(player, "40")) {
                    // And you haven't claimed it already, woo!
                    try {
                        numClaimed++;
                        player.sendMessage(Text.of("\u00A7f[\u00A7bPokeDex\u00A7f] \u00A7bYou have claimed the \u00A7f40% \u00A7breward!"));
                        Config.getInstance().getConfig().getNode("playerData", player.getUniqueId().toString(), "40").setValue(true);
                        Config.getInstance().saveAndLoadConfig();
                        int numRewards = Config.getInstance().getConfig().getNode("rewards", "reward40", "numberOfRewards").getInt();
                        for(int i = 1; i < numRewards+1; i++) {
                            ItemStack item = Config.getInstance().getConfig().getNode("rewards", "reward40", i).getValue(TypeToken.of(ItemStack.class));
                            Utils.getInstance().giveItemStack(item, player);
                        }
                    } catch (ObjectMappingException e) { e.printStackTrace(); }
                }
            }
            if(percent >= 50) {
                // Eligible for 50% reward!
                if(!Utils.getInstance().hasClaimed(player, "50")) {
                    // And you haven't claimed it already, woo!
                    try {
                        numClaimed++;
                        player.sendMessage(Text.of("\u00A7f[\u00A7bPokeDex\u00A7f] \u00A7bYou have claimed the \u00A7f50% \u00A7breward!"));
                        Config.getInstance().getConfig().getNode("playerData", player.getUniqueId().toString(), "50").setValue(true);
                        Config.getInstance().saveAndLoadConfig();
                        int numRewards = Config.getInstance().getConfig().getNode("rewards", "reward50", "numberOfRewards").getInt();
                        for(int i = 1; i < numRewards+1; i++) {
                            ItemStack item = Config.getInstance().getConfig().getNode("rewards", "reward50", i).getValue(TypeToken.of(ItemStack.class));
                            Utils.getInstance().giveItemStack(item, player);
                        }
                    } catch (ObjectMappingException e) { e.printStackTrace(); }
                }
            }
            if(percent >= 60) {
                // Eligible for 60% reward!
                if(!Utils.getInstance().hasClaimed(player, "60")) {
                    // And you haven't claimed it already, woo!
                    try {
                        numClaimed++;
                        player.sendMessage(Text.of("\u00A7f[\u00A7bPokeDex\u00A7f] \u00A7bYou have claimed the \u00A7f60% \u00A7breward!"));
                        Config.getInstance().getConfig().getNode("playerData", player.getUniqueId().toString(), "60").setValue(true);
                        Config.getInstance().saveAndLoadConfig();
                        int numRewards = Config.getInstance().getConfig().getNode("rewards", "reward60", "numberOfRewards").getInt();
                        for(int i = 1; i < numRewards+1; i++) {
                            ItemStack item = Config.getInstance().getConfig().getNode("rewards", "reward60", i).getValue(TypeToken.of(ItemStack.class));
                            Utils.getInstance().giveItemStack(item, player);
                        }
                    } catch (ObjectMappingException e) { e.printStackTrace(); }
                }
            }
            if(percent >= 70) {
                // Eligible for 70% reward!
                if(!Utils.getInstance().hasClaimed(player, "70")) {
                    // And you haven't claimed it already, woo!
                    try {
                        numClaimed++;
                        player.sendMessage(Text.of("\u00A7f[\u00A7bPokeDex\u00A7f] \u00A7bYou have claimed the \u00A7f70% \u00A7breward!"));
                        Config.getInstance().getConfig().getNode("playerData", player.getUniqueId().toString(), "70").setValue(true);
                        Config.getInstance().saveAndLoadConfig();
                        int numRewards = Config.getInstance().getConfig().getNode("rewards", "reward70", "numberOfRewards").getInt();
                        for(int i = 1; i < numRewards+1; i++) {
                            ItemStack item = Config.getInstance().getConfig().getNode("rewards", "reward70", i).getValue(TypeToken.of(ItemStack.class));
                            Utils.getInstance().giveItemStack(item, player);
                        }
                    } catch (ObjectMappingException e) { e.printStackTrace(); }
                }
            }
            if(percent >= 80) {
                // Eligible for 80% reward!
                if(!Utils.getInstance().hasClaimed(player, "80")) {
                    // And you haven't claimed it already, woo!
                    try {
                        numClaimed++;
                        player.sendMessage(Text.of("\u00A7f[\u00A7bPokeDex\u00A7f] \u00A7bYou have claimed the \u00A7f80% \u00A7breward!"));
                        Config.getInstance().getConfig().getNode("playerData", player.getUniqueId().toString(), "80").setValue(true);
                        Config.getInstance().saveAndLoadConfig();
                        int numRewards = Config.getInstance().getConfig().getNode("rewards", "reward80", "numberOfRewards").getInt();
                        for(int i = 1; i < numRewards+1; i++) {
                            ItemStack item = Config.getInstance().getConfig().getNode("rewards", "reward80", i).getValue(TypeToken.of(ItemStack.class));
                            Utils.getInstance().giveItemStack(item, player);
                        }
                    } catch (ObjectMappingException e) { e.printStackTrace(); }
                }
            }
            if(percent >= 90) {
                // Eligible for 90% reward!
                if(!Utils.getInstance().hasClaimed(player, "90")) {
                    // And you haven't claimed it already, woo!
                    try {
                        numClaimed++;
                        player.sendMessage(Text.of("\u00A7f[\u00A7bPokeDex\u00A7f] \u00A7bYou have claimed the \u00A7f90% \u00A7breward!"));
                        Config.getInstance().getConfig().getNode("playerData", player.getUniqueId().toString(), "90").setValue(true);
                        Config.getInstance().saveAndLoadConfig();
                        int numRewards = Config.getInstance().getConfig().getNode("rewards", "reward90", "numberOfRewards").getInt();
                        for(int i = 1; i < numRewards+1; i++) {
                            ItemStack item = Config.getInstance().getConfig().getNode("rewards", "reward90", i).getValue(TypeToken.of(ItemStack.class));
                            Utils.getInstance().giveItemStack(item, player);
                        }
                    } catch (ObjectMappingException e) { e.printStackTrace(); }
                }
            }
            if(percent >= 100) {
                // Eligible for 100% reward!
                if(!Utils.getInstance().hasClaimed(player, "100")) {
                    // And you haven't claimed it already, woo!
                    try {
                        numClaimed++;
                        player.sendMessage(Text.of("\u00A7f[\u00A7bPokeDex\u00A7f] \u00A7bYou have claimed the \u00A7f100% \u00A7breward!"));
                        Config.getInstance().getConfig().getNode("playerData", player.getUniqueId().toString(), "100").setValue(true);
                        Config.getInstance().saveAndLoadConfig();
                        int numRewards = Config.getInstance().getConfig().getNode("rewards", "reward100", "numberOfRewards").getInt();
                        for(int i = 1; i < numRewards+1; i++) {
                            ItemStack item = Config.getInstance().getConfig().getNode("rewards", "reward100", i).getValue(TypeToken.of(ItemStack.class));
                            Utils.getInstance().giveItemStack(item, player);
                        }
                    } catch (ObjectMappingException e) { e.printStackTrace(); }
                } else {
                    player.sendMessage(Text.of("\u00A7f[\u00A7bPokeDex\u00A7f] \u00A7bYou have nothing left to claim, good job!"));
                }
            }

            if(numClaimed == 0) {
                player.sendMessage(Text.of("\u00A7f[\u00A7cPokeDex\u00A7f] \u00A7cYou have nothing to claim right now!"));
            }
        } else {
            src.sendMessage(Text.of("\u00A7f[\u00A7cPokeDex\u00A7f] \u00A7cYou need to be a player to run this command!"));
        }
        return CommandResult.success();
    }
}
