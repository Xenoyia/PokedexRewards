package com.xpgaming.xPPokeDex;

import com.google.common.reflect.TypeToken;
import net.minecraft.entity.player.EntityPlayerMP;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.Text;

public class Claim implements CommandExecutor {
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if(src instanceof Player) {
            Player player = (Player) src;
            double percent = Utils.getInstance().calcPercent((EntityPlayerMP) player);
            int numClaimed = 0;
            int moneyClaimed = 0;
            if(percent >= 10) {
                // Eligible for 10% reward!
                if(!Utils.getInstance().hasClaimed(player, "10")) {
                    // And you haven't claimed it already, woo!
                    try {
                        numClaimed++;
                        EntityPlayerMP emp = (EntityPlayerMP) player;
                        UserData.getInstance().getConfig().getNode("playerData", player.getUniqueId().toString(), "10").setValue(true);
                        UserData.getInstance().saveAndLoadConfig();
                        int numRewards = Config.getInstance().getConfig().getNode("rewards", "reward10", "numberOfRewards").getInt();
                        if(numRewards > 0) {
                            for(int i = 1; i < numRewards+1; i++) {
                                //If an item reward exists..
                                if(!Config.getInstance().getConfig().getNode("rewards", "reward10", String.valueOf(i), "item").isVirtual()) {
                                    ItemStack item = Config.getInstance().getConfig().getNode("rewards", "reward10", String.valueOf(i), "item").getValue(TypeToken.of(ItemStack.class));
                                    Utils.getInstance().giveItemStack(item, player);
                                }
                                //If a command reward exists..
                                if(!Config.getInstance().getConfig().getNode("rewards", "reward10", String.valueOf(i), "command").isVirtual()) {
                                    Utils.getInstance().runConsoleCommand(Config.getInstance().getConfig().getNode("rewards", "reward10", String.valueOf(i), "command").getString().replaceAll("%player%", emp.getName()));
                                }
                            }
                        }

                    } catch (ObjectMappingException e) { e.printStackTrace(); }

                    if(Config.getInstance().getConfig().getNode("rewards", "reward10", "moneyReward").getInt() > 0) {
                        Main.getInstance().addMoney(player, Config.getInstance().getConfig().getNode("rewards", "reward10", "moneyReward").getInt());
                        moneyClaimed += Config.getInstance().getConfig().getNode("rewards", "reward10", "moneyReward").getInt();
                    }

                    if(Config.getInstance().getConfig().getNode("rewards", "reward10", "shinyTokens").getInt() > 0) {
                        for(int i = 0; i < Config.getInstance().getConfig().getNode("rewards", "reward10", "shinyTokens").getInt(); i++) {
                            Utils.getInstance().giveItemStack(Utils.getInstance().shinyToken(), player);
                        }
                    }
                }
            }
            if(percent >= 20) {
                // Eligible for 20% reward!
                if(!Utils.getInstance().hasClaimed(player, "20")) {
                    // And you haven't claimed it already, woo!
                    try {
                        numClaimed++;
                        EntityPlayerMP emp = (EntityPlayerMP) player;
                        UserData.getInstance().getConfig().getNode("playerData", player.getUniqueId().toString(), "20").setValue(true);
                        UserData.getInstance().saveAndLoadConfig();
                        int numRewards = Config.getInstance().getConfig().getNode("rewards", "reward20", "numberOfRewards").getInt();
                        if(numRewards > 0) {
                            for(int i = 1; i < numRewards+1; i++) {
                                //If an item reward exists..
                                if(!Config.getInstance().getConfig().getNode("rewards", "reward20", String.valueOf(i), "item").isVirtual()) {
                                    ItemStack item = Config.getInstance().getConfig().getNode("rewards", "reward20", String.valueOf(i), "item").getValue(TypeToken.of(ItemStack.class));
                                    Utils.getInstance().giveItemStack(item, player);
                                }
                                //If a command reward exists..
                                if(!Config.getInstance().getConfig().getNode("rewards", "reward20", String.valueOf(i), "command").isVirtual()) {
                                    Utils.getInstance().runConsoleCommand(Config.getInstance().getConfig().getNode("rewards", "reward20", String.valueOf(i), "command").getString().replaceAll("%player%", emp.getName()));
                                }
                            }
                        }
                    } catch (ObjectMappingException e) { e.printStackTrace(); }

                    if(Config.getInstance().getConfig().getNode("rewards", "reward20", "moneyReward").getInt() > 0) {
                        Main.getInstance().addMoney(player, Config.getInstance().getConfig().getNode("rewards", "reward20", "moneyReward").getInt());
                        moneyClaimed += Config.getInstance().getConfig().getNode("rewards", "reward20", "moneyReward").getInt();
                    }

                    if(Config.getInstance().getConfig().getNode("rewards", "reward20", "shinyTokens").getInt() > 0) {
                        for(int i = 0; i < Config.getInstance().getConfig().getNode("rewards", "reward20", "shinyTokens").getInt(); i++) {
                            Utils.getInstance().giveItemStack(Utils.getInstance().shinyToken(), player);
                        }
                    }
                }
            }
            if(percent >= 30) {
                // Eligible for 30% reward!
                if(!Utils.getInstance().hasClaimed(player, "30")) {
                    // And you haven't claimed it already, woo!
                    try {
                        numClaimed++;
                        EntityPlayerMP emp = (EntityPlayerMP) player;
                        UserData.getInstance().getConfig().getNode("playerData", player.getUniqueId().toString(), "30").setValue(true);
                        UserData.getInstance().saveAndLoadConfig();
                        int numRewards = Config.getInstance().getConfig().getNode("rewards", "reward30", "numberOfRewards").getInt();
                        if(numRewards > 0) {
                            for(int i = 1; i < numRewards+1; i++) {
                                //If an item reward exists..
                                if(!Config.getInstance().getConfig().getNode("rewards", "reward30", String.valueOf(i), "item").isVirtual()) {
                                    ItemStack item = Config.getInstance().getConfig().getNode("rewards", "reward30", String.valueOf(i), "item").getValue(TypeToken.of(ItemStack.class));
                                    Utils.getInstance().giveItemStack(item, player);
                                }
                                //If a command reward exists..
                                if(!Config.getInstance().getConfig().getNode("rewards", "reward30", String.valueOf(i), "command").isVirtual()) {
                                    Utils.getInstance().runConsoleCommand(Config.getInstance().getConfig().getNode("rewards", "reward30", String.valueOf(i), "command").getString().replaceAll("%player%", emp.getName()));
                                }
                            }
                        }
                    } catch (ObjectMappingException e) { e.printStackTrace(); }

                    if(Config.getInstance().getConfig().getNode("rewards", "reward30", "moneyReward").getInt() > 0) {
                        Main.getInstance().addMoney(player, Config.getInstance().getConfig().getNode("rewards", "reward30", "moneyReward").getInt());
                        moneyClaimed += Config.getInstance().getConfig().getNode("rewards", "reward30", "moneyReward").getInt();
                    }

                    if(Config.getInstance().getConfig().getNode("rewards", "reward30", "shinyTokens").getInt() > 0) {
                        for(int i = 0; i < Config.getInstance().getConfig().getNode("rewards", "reward30", "shinyTokens").getInt(); i++) {
                            Utils.getInstance().giveItemStack(Utils.getInstance().shinyToken(), player);
                        }
                    }
                }
            }
            if(percent >= 40) {
                // Eligible for 40% reward!
                if(!Utils.getInstance().hasClaimed(player, "40")) {
                    // And you haven't claimed it already, woo!
                    try {
                        numClaimed++;
                        EntityPlayerMP emp = (EntityPlayerMP) player;
                        UserData.getInstance().getConfig().getNode("playerData", player.getUniqueId().toString(), "40").setValue(true);
                        UserData.getInstance().saveAndLoadConfig();
                        int numRewards = Config.getInstance().getConfig().getNode("rewards", "reward40", "numberOfRewards").getInt();
                        if(numRewards > 0) {
                            for(int i = 1; i < numRewards+1; i++) {
                                //If an item reward exists..
                                if(!Config.getInstance().getConfig().getNode("rewards", "reward40", String.valueOf(i), "item").isVirtual()) {
                                    ItemStack item = Config.getInstance().getConfig().getNode("rewards", "reward40", String.valueOf(i), "item").getValue(TypeToken.of(ItemStack.class));
                                    Utils.getInstance().giveItemStack(item, player);
                                }
                                //If a command reward exists..
                                if(!Config.getInstance().getConfig().getNode("rewards", "reward40", String.valueOf(i), "command").isVirtual()) {
                                    Utils.getInstance().runConsoleCommand(Config.getInstance().getConfig().getNode("rewards", "reward40", String.valueOf(i), "command").getString().replaceAll("%player%", emp.getName()));
                                }
                            }
                        }
                    } catch (ObjectMappingException e) { e.printStackTrace(); }

                    if(Config.getInstance().getConfig().getNode("rewards", "reward40", "moneyReward").getInt() > 0) {
                        Main.getInstance().addMoney(player, Config.getInstance().getConfig().getNode("rewards", "reward40", "moneyReward").getInt());
                        moneyClaimed += Config.getInstance().getConfig().getNode("rewards", "reward40", "moneyReward").getInt();
                    }

                    if(Config.getInstance().getConfig().getNode("rewards", "reward40", "shinyTokens").getInt() > 0) {
                        for(int i = 0; i < Config.getInstance().getConfig().getNode("rewards", "reward40", "shinyTokens").getInt(); i++) {
                            Utils.getInstance().giveItemStack(Utils.getInstance().shinyToken(), player);
                        }
                    }
                }
            }
            if(percent >= 50) {
                // Eligible for 50% reward!
                if(!Utils.getInstance().hasClaimed(player, "50")) {
                    // And you haven't claimed it already, woo!
                    try {
                        numClaimed++;
                        EntityPlayerMP emp = (EntityPlayerMP) player;
                        UserData.getInstance().getConfig().getNode("playerData", player.getUniqueId().toString(), "50").setValue(true);
                        UserData.getInstance().saveAndLoadConfig();
                        int numRewards = Config.getInstance().getConfig().getNode("rewards", "reward50", "numberOfRewards").getInt();
                        if(numRewards > 0) {
                            for(int i = 1; i < numRewards+1; i++) {
                                //If an item reward exists..
                                if(!Config.getInstance().getConfig().getNode("rewards", "reward50", String.valueOf(i), "item").isVirtual()) {
                                    ItemStack item = Config.getInstance().getConfig().getNode("rewards", "reward50", String.valueOf(i), "item").getValue(TypeToken.of(ItemStack.class));
                                    Utils.getInstance().giveItemStack(item, player);
                                }
                                //If a command reward exists..
                                if(!Config.getInstance().getConfig().getNode("rewards", "reward50", String.valueOf(i), "command").isVirtual()) {
                                    Utils.getInstance().runConsoleCommand(Config.getInstance().getConfig().getNode("rewards", "reward50", String.valueOf(i), "command").getString().replaceAll("%player%", emp.getName()));
                                }
                            }
                        }
                    } catch (ObjectMappingException e) { e.printStackTrace(); }

                    if(Config.getInstance().getConfig().getNode("rewards", "reward50", "moneyReward").getInt() > 0) {
                        Main.getInstance().addMoney(player, Config.getInstance().getConfig().getNode("rewards", "reward50", "moneyReward").getInt());
                        moneyClaimed += Config.getInstance().getConfig().getNode("rewards", "reward50", "moneyReward").getInt();
                    }

                    if(Config.getInstance().getConfig().getNode("rewards", "reward50", "shinyTokens").getInt() > 0) {
                        for(int i = 0; i < Config.getInstance().getConfig().getNode("rewards", "reward50", "shinyTokens").getInt(); i++) {
                            Utils.getInstance().giveItemStack(Utils.getInstance().shinyToken(), player);
                        }
                    }
                }
            }
            if(percent >= 60) {
                // Eligible for 60% reward!
                if(!Utils.getInstance().hasClaimed(player, "60")) {
                    // And you haven't claimed it already, woo!
                    try {
                        numClaimed++;
                        EntityPlayerMP emp = (EntityPlayerMP) player;
                        UserData.getInstance().getConfig().getNode("playerData", player.getUniqueId().toString(), "60").setValue(true);
                        UserData.getInstance().saveAndLoadConfig();
                        int numRewards = Config.getInstance().getConfig().getNode("rewards", "reward60", "numberOfRewards").getInt();
                        if(numRewards > 0) {
                            for(int i = 1; i < numRewards+1; i++) {
                                //If an item reward exists..
                                if(!Config.getInstance().getConfig().getNode("rewards", "reward60", String.valueOf(i), "item").isVirtual()) {
                                    ItemStack item = Config.getInstance().getConfig().getNode("rewards", "reward60", String.valueOf(i), "item").getValue(TypeToken.of(ItemStack.class));
                                    Utils.getInstance().giveItemStack(item, player);
                                }
                                //If a command reward exists..
                                if(!Config.getInstance().getConfig().getNode("rewards", "reward60", String.valueOf(i), "command").isVirtual()) {
                                    Utils.getInstance().runConsoleCommand(Config.getInstance().getConfig().getNode("rewards", "reward60", String.valueOf(i), "command").getString().replaceAll("%player%", emp.getName()));
                                }
                            }
                        }
                    } catch (ObjectMappingException e) { e.printStackTrace(); }

                    if(Config.getInstance().getConfig().getNode("rewards", "reward60", "moneyReward").getInt() > 0) {
                        Main.getInstance().addMoney(player, Config.getInstance().getConfig().getNode("rewards", "reward60", "moneyReward").getInt());
                        moneyClaimed += Config.getInstance().getConfig().getNode("rewards", "reward60", "moneyReward").getInt();
                    }

                    if(Config.getInstance().getConfig().getNode("rewards", "reward60", "shinyTokens").getInt() > 0) {
                        for(int i = 0; i < Config.getInstance().getConfig().getNode("rewards", "reward60", "shinyTokens").getInt(); i++) {
                            Utils.getInstance().giveItemStack(Utils.getInstance().shinyToken(), player);
                        }
                    }
                }
            }
            if(percent >= 70) {
                // Eligible for 70% reward!
                if(!Utils.getInstance().hasClaimed(player, "70")) {
                    // And you haven't claimed it already, woo!
                    try {
                        numClaimed++;
                        EntityPlayerMP emp = (EntityPlayerMP) player;
                        UserData.getInstance().getConfig().getNode("playerData", player.getUniqueId().toString(), "70").setValue(true);
                        UserData.getInstance().saveAndLoadConfig();
                        int numRewards = Config.getInstance().getConfig().getNode("rewards", "reward70", "numberOfRewards").getInt();
                        if(numRewards > 0) {
                            for(int i = 1; i < numRewards+1; i++) {
                                //If an item reward exists..
                                if(!Config.getInstance().getConfig().getNode("rewards", "reward70", String.valueOf(i), "item").isVirtual()) {
                                    ItemStack item = Config.getInstance().getConfig().getNode("rewards", "reward70", String.valueOf(i), "item").getValue(TypeToken.of(ItemStack.class));
                                    Utils.getInstance().giveItemStack(item, player);
                                }
                                //If a command reward exists..
                                if(!Config.getInstance().getConfig().getNode("rewards", "reward70", String.valueOf(i), "command").isVirtual()) {
                                    Utils.getInstance().runConsoleCommand(Config.getInstance().getConfig().getNode("rewards", "reward70", String.valueOf(i), "command").getString().replaceAll("%player%", emp.getName()));
                                }
                            }
                        }
                    } catch (ObjectMappingException e) { e.printStackTrace(); }

                    if(Config.getInstance().getConfig().getNode("rewards", "reward70", "moneyReward").getInt() > 0) {
                        Main.getInstance().addMoney(player, Config.getInstance().getConfig().getNode("rewards", "reward70", "moneyReward").getInt());
                        moneyClaimed += Config.getInstance().getConfig().getNode("rewards", "reward70", "moneyReward").getInt();
                    }

                    if(Config.getInstance().getConfig().getNode("rewards", "reward70", "shinyTokens").getInt() > 0) {
                        for(int i = 0; i < Config.getInstance().getConfig().getNode("rewards", "reward70", "shinyTokens").getInt(); i++) {
                            Utils.getInstance().giveItemStack(Utils.getInstance().shinyToken(), player);
                        }
                    }
                }
            }
            if(percent >= 80) {
                // Eligible for 80% reward!
                if(!Utils.getInstance().hasClaimed(player, "80")) {
                    // And you haven't claimed it already, woo!
                    try {
                        numClaimed++;
                        EntityPlayerMP emp = (EntityPlayerMP) player;
                        UserData.getInstance().getConfig().getNode("playerData", player.getUniqueId().toString(), "80").setValue(true);
                        UserData.getInstance().saveAndLoadConfig();
                        int numRewards = Config.getInstance().getConfig().getNode("rewards", "reward80", "numberOfRewards").getInt();
                        if(numRewards > 0) {
                            for(int i = 1; i < numRewards+1; i++) {
                                //If an item reward exists..
                                if(!Config.getInstance().getConfig().getNode("rewards", "reward80", String.valueOf(i), "item").isVirtual()) {
                                    ItemStack item = Config.getInstance().getConfig().getNode("rewards", "reward80", String.valueOf(i), "item").getValue(TypeToken.of(ItemStack.class));
                                    Utils.getInstance().giveItemStack(item, player);
                                }
                                //If a command reward exists..
                                if(!Config.getInstance().getConfig().getNode("rewards", "reward80", String.valueOf(i), "command").isVirtual()) {
                                    Utils.getInstance().runConsoleCommand(Config.getInstance().getConfig().getNode("rewards", "reward80", String.valueOf(i), "command").getString().replaceAll("%player%", emp.getName()));
                                }
                            }
                        }
                    } catch (ObjectMappingException e) { e.printStackTrace(); }

                    if(Config.getInstance().getConfig().getNode("rewards", "reward80", "moneyReward").getInt() > 0) {
                        Main.getInstance().addMoney(player, Config.getInstance().getConfig().getNode("rewards", "reward80", "moneyReward").getInt());
                        moneyClaimed += Config.getInstance().getConfig().getNode("rewards", "reward80", "moneyReward").getInt();
                    }

                    if(Config.getInstance().getConfig().getNode("rewards", "reward80", "shinyTokens").getInt() > 0) {
                        for(int i = 0; i < Config.getInstance().getConfig().getNode("rewards", "reward80", "shinyTokens").getInt(); i++) {
                            Utils.getInstance().giveItemStack(Utils.getInstance().shinyToken(), player);
                        }
                    }
                }
            }
            if(percent >= 90) {
                // Eligible for 90% reward!
                if(!Utils.getInstance().hasClaimed(player, "90")) {
                    // And you haven't claimed it already, woo!
                    try {
                        numClaimed++;
                        EntityPlayerMP emp = (EntityPlayerMP) player;
                        UserData.getInstance().getConfig().getNode("playerData", player.getUniqueId().toString(), "90").setValue(true);
                        UserData.getInstance().saveAndLoadConfig();
                        int numRewards = Config.getInstance().getConfig().getNode("rewards", "reward90", "numberOfRewards").getInt();
                        if(numRewards > 0) {
                            for(int i = 1; i < numRewards+1; i++) {
                                //If an item reward exists..
                                if(!Config.getInstance().getConfig().getNode("rewards", "reward90", String.valueOf(i), "item").isVirtual()) {
                                    ItemStack item = Config.getInstance().getConfig().getNode("rewards", "reward90", String.valueOf(i), "item").getValue(TypeToken.of(ItemStack.class));
                                    Utils.getInstance().giveItemStack(item, player);
                                }
                                //If a command reward exists..
                                if(!Config.getInstance().getConfig().getNode("rewards", "reward90", String.valueOf(i), "command").isVirtual()) {
                                    Utils.getInstance().runConsoleCommand(Config.getInstance().getConfig().getNode("rewards", "reward90", String.valueOf(i), "command").getString().replaceAll("%player%", emp.getName()));
                                }
                            }
                        }
                    } catch (ObjectMappingException e) { e.printStackTrace(); }

                    if(Config.getInstance().getConfig().getNode("rewards", "reward90", "moneyReward").getInt() > 0) {
                        Main.getInstance().addMoney(player, Config.getInstance().getConfig().getNode("rewards", "reward90", "moneyReward").getInt());
                        moneyClaimed += Config.getInstance().getConfig().getNode("rewards", "reward90", "moneyReward").getInt();
                    }

                    if(Config.getInstance().getConfig().getNode("rewards", "reward90", "shinyTokens").getInt() > 0) {
                        for(int i = 0; i < Config.getInstance().getConfig().getNode("rewards", "reward90", "shinyTokens").getInt(); i++) {
                            Utils.getInstance().giveItemStack(Utils.getInstance().shinyToken(), player);
                        }
                    }
                }
            }
            if(percent >= 100) {
                // Eligible for 100% reward!
                if(!Utils.getInstance().hasClaimed(player, "100")) {
                    // And you haven't claimed it already, woo!
                    try {
                        numClaimed++;
                        EntityPlayerMP emp = (EntityPlayerMP) player;
                        Sponge.getServer().getBroadcastChannel().send(Text.of("\u00A7f[\u00A7bPokeDex\u00A7f] \u00A7f"+player.getName()+" \u00A7bhas completed their Pokedex!"));
                        UserData.getInstance().getConfig().getNode("playerData", player.getUniqueId().toString(), "100").setValue(true);
                        UserData.getInstance().saveAndLoadConfig();
                        int numRewards = Config.getInstance().getConfig().getNode("rewards", "rewardfinal", "numberOfRewards").getInt();
                        if(numRewards > 0) {
                            for(int i = 1; i < numRewards+1; i++) {
                                //If an item reward exists..
                                if(!Config.getInstance().getConfig().getNode("rewards", "rewardfinal", String.valueOf(i), "item").isVirtual()) {
                                    ItemStack item = Config.getInstance().getConfig().getNode("rewards", "rewardfinal", String.valueOf(i), "item").getValue(TypeToken.of(ItemStack.class));
                                    Utils.getInstance().giveItemStack(item, player);
                                }
                                //If a command reward exists..
                                if(!Config.getInstance().getConfig().getNode("rewards", "rewardfinal", String.valueOf(i), "command").isVirtual()) {
                                    Utils.getInstance().runConsoleCommand(Config.getInstance().getConfig().getNode("rewards", "rewardfinal", String.valueOf(i), "command").getString().replaceAll("%player%", emp.getName()));
                                }
                            }
                        }
                    } catch (ObjectMappingException e) { e.printStackTrace(); }

                    if(Config.getInstance().getConfig().getNode("rewards", "rewardfinal", "moneyReward").getInt() > 0) {
                        Main.getInstance().addMoney(player, Config.getInstance().getConfig().getNode("rewards", "rewardfinal", "moneyReward").getInt());
                        moneyClaimed += Config.getInstance().getConfig().getNode("rewards", "rewardfinal", "moneyReward").getInt();
                    }

                    if(Config.getInstance().getConfig().getNode("rewards", "rewardfinal", "shinyTokens").getInt() > 0) {
                        for(int i = 0; i < Config.getInstance().getConfig().getNode("rewards", "rewardfinal", "shinyTokens").getInt(); i++) {
                            Utils.getInstance().giveItemStack(Utils.getInstance().shinyToken(), player);
                        }
                    }
                } else {
                    player.sendMessage(Text.of("\u00A7f[\u00A7bPokeDex\u00A7f] \u00A7bYou have nothing left to claim, good job!"));
                }
            }

            if(moneyClaimed > 0) {
                player.sendMessage(Text.of("\u00A7f[\u00A76PokeDex\u00A7f] \u00A7e"+moneyClaimed+" \u00A76has been added to your account!"));
            }

            if(numClaimed == 0) {
                player.sendMessage(Text.of("\u00A7f[\u00A7cPokeDex\u00A7f] \u00A7cYou have nothing to claim right now!"));
            } else {
                player.sendMessage(Text.of("\u00A7f[\u00A7bPokeDex\u00A7f] \u00A7bYou have claimed \u00A7f"+numClaimed+" \u00A7breward tiers!"));
            }
        } else {
            src.sendMessage(Text.of("\u00A7f[\u00A7cPokeDex\u00A7f] \u00A7cYou need to be a player to run this command!"));
        }
        return CommandResult.success();
    }
}
