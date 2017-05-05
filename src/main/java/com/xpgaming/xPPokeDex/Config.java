package com.xpgaming.xPPokeDex;
import java.io.File;
import java.io.IOException;

import com.google.common.reflect.TypeToken;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.ItemStack;

public class Config {
    private static Config instance = new Config();

    public static Config getInstance() {
        return instance;
    }

    private ConfigurationLoader<CommentedConfigurationNode> configLoader;
    private CommentedConfigurationNode config;
    private File configFile;

    public void configCreate() throws ObjectMappingException {
        try {
            configFile.createNewFile();
            configLoad();
            CommentedConfigurationNode rewards = config.getNode("rewards").setComment("xP// PokeDex coded by Xenoyia! Check out mc.xpgaming.com!");
            CommentedConfigurationNode pd = config.getNode("playerData").setComment("Do not mess with this unless you know what you are doing!");
            ItemStack reward10 = ItemStack.builder()
                    .itemType(ItemTypes.DIAMOND)
                    .quantity(1)
                    .build();
            ItemStack reward10b = ItemStack.builder()
                    .itemType(ItemTypes.APPLE)
                    .quantity(1)
                    .build();
            ItemStack reward20 = ItemStack.builder()
                    .itemType(ItemTypes.DIAMOND)
                    .quantity(2)
                    .build();
            ItemStack reward30 = ItemStack.builder()
                    .itemType(ItemTypes.DIAMOND)
                    .quantity(4)
                    .build();
            ItemStack reward40 = ItemStack.builder()
                    .itemType(ItemTypes.DIAMOND)
                    .quantity(8)
                    .build();
            ItemStack reward50 = ItemStack.builder()
                    .itemType(ItemTypes.DIAMOND)
                    .quantity(16)
                    .build();
            ItemStack reward60 = ItemStack.builder()
                    .itemType(ItemTypes.DIAMOND)
                    .quantity(32)
                    .build();
            ItemStack reward70 = ItemStack.builder()
                    .itemType(ItemTypes.DIAMOND)
                    .quantity(64)
                    .build();
            ItemStack reward80 = ItemStack.builder()
                    .itemType(ItemTypes.DIAMOND)
                    .quantity(64)
                    .build();
            ItemStack reward90 = ItemStack.builder()
                    .itemType(ItemTypes.DIAMOND)
                    .quantity(64)
                    .build();
            ItemStack reward100 = ItemStack.builder()
                    .itemType(ItemTypes.DIAMOND)
                    .quantity(64)
                    .build();
            rewards.getNode("reward10", "numberOfRewards").setValue(2);
            rewards.getNode("reward10", 1).setValue(TypeToken.of(ItemStack.class), reward10);
            rewards.getNode("reward10", 2).setValue(TypeToken.of(ItemStack.class), reward10b);
            rewards.getNode("reward20", "numberOfRewards").setValue(1);
            rewards.getNode("reward20", 1).setValue(TypeToken.of(ItemStack.class), reward20);
            rewards.getNode("reward30", "numberOfRewards").setValue(1);
            rewards.getNode("reward30", 1).setValue(TypeToken.of(ItemStack.class), reward30);
            rewards.getNode("reward40", "numberOfRewards").setValue(1);
            rewards.getNode("reward40", 1).setValue(TypeToken.of(ItemStack.class), reward40);
            rewards.getNode("reward50", "numberOfRewards").setValue(1);
            rewards.getNode("reward50", 1).setValue(TypeToken.of(ItemStack.class), reward50);
            rewards.getNode("reward60", "numberOfRewards").setValue(1);
            rewards.getNode("reward60", 1).setValue(TypeToken.of(ItemStack.class), reward60);
            rewards.getNode("reward70", "numberOfRewards").setValue(1);
            rewards.getNode("reward70", 1).setValue(TypeToken.of(ItemStack.class), reward70);
            rewards.getNode("reward80", "numberOfRewards").setValue(1);
            rewards.getNode("reward80", 1).setValue(TypeToken.of(ItemStack.class), reward80);
            rewards.getNode("reward90", "numberOfRewards").setValue(1);
            rewards.getNode("reward90", 1).setValue(TypeToken.of(ItemStack.class), reward90);
            rewards.getNode("reward100", "numberOfRewards").setValue(1);
            rewards.getNode("reward100", 1).setValue(TypeToken.of(ItemStack.class), reward100);
            configSave();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setup(File configFile, ConfigurationLoader<CommentedConfigurationNode> configLoader) {
        this.configLoader = configLoader;
        this.configFile = configFile;
        if (!configFile.exists()) {
            try {
                configCreate();
            } catch (ObjectMappingException e) {
                e.printStackTrace();
            }
        } else
            configLoad();
    }

    public CommentedConfigurationNode getConfig() {
        return config;
    }

    public void configLoad() {
        if (!configFile.exists()) {
            try {
                configCreate();
            } catch (ObjectMappingException e) {
                e.printStackTrace();
            }
        } else
            try {
                config = configLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public void configSave() {
        try {
            configLoader.save(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveAndLoadConfig() {
        configSave();
        configLoad();
    }
}
