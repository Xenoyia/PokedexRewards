package com.xpgaming.xPPokeDex;

import com.pixelmonmod.pixelmon.enums.EnumPokemon;
import com.pixelmonmod.pixelmon.storage.NbtKeys;
import com.pixelmonmod.pixelmon.storage.PixelmonStorage;
import com.pixelmonmod.pixelmon.storage.PlayerStorage;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.data.type.HandTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.Text;

import java.text.DecimalFormat;
import java.util.Optional;

public class Convert implements CommandExecutor {
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if(src instanceof Player) {
            int slot = args.<Integer>getOne("slot").get();
            if(slot <= 6 && slot >= 1) {
                Player player = (Player) src;
                if(player.getItemInHand(HandTypes.MAIN_HAND).equals(Utils.getInstance().shinyToken())) {
                    EntityPlayerMP entity = (EntityPlayerMP) src;
                    Optional<PlayerStorage> optstorage = PixelmonStorage.pokeBallManager.getPlayerStorage(entity);
                    if (optstorage.isPresent()) {
                        PlayerStorage storage = (PlayerStorage) optstorage.get();
                        NBTTagCompound nbt = storage.partyPokemon[slot - 1];
                        if(nbt == null || nbt.getBoolean("isEgg")) {
                            src.sendMessage(Text.of("\u00A7f[\u00A7cPokeDex\u00A7f] \u00A7cThere's not a valid Pokemon in slot "+slot+"!"));
                        } else {
                            int isShiny = nbt.getInteger(NbtKeys.IS_SHINY);
                            if(isShiny == 1) {
                                src.sendMessage(Text.of("\u00A7f[\u00A7cPokeDex\u00A7f] \u00A7cThat Pokemon is already shiny!"));
                            } else {
                                nbt.setInteger(NbtKeys.IS_SHINY, 1);
                                src.sendMessage(Text.of("\u00A7f[\u00A7bPokeDex\u00A7f] \u00A7bSuccessfully converted that Pokemon to shiny!"));
                                Optional<ItemStack> itemInHand = player.getItemInHand(HandTypes.MAIN_HAND);
                                if(itemInHand.isPresent()) {
                                    int amount = itemInHand.get().getQuantity();
                                    if(amount == 1) {
                                        player.setItemInHand(HandTypes.MAIN_HAND, null);
                                    } else {
                                        itemInHand.get().setQuantity(amount-1);
                                    }
                                }
                            }
                            }
                    }
                } else {
                    src.sendMessage(Text.of("\u00A7f[\u00A7cPokeDex\u00A7f] \u00A7cYou need to be holding a shiny token!"));
                }
            } else {
                src.sendMessage(Text.of("\u00A7f[\u00A7cPokeDex\u00A7f] \u00A7cThat's not a valid slot! Try 1 - 6!"));
            }

        } else {
            src.sendMessage(Text.of("\u00A7f[\u00A7cPokeDex\u00A7f] \u00A7cYou need to be a player to run this command!"));
        }
        return CommandResult.success();
    }
}
