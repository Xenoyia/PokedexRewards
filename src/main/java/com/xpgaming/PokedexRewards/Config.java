package com.xpgaming.PokedexRewards;
import com.google.common.reflect.TypeToken;
import com.google.inject.Inject;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.config.ConfigDir;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;

import java.io.File;
import java.io.IOException;

public class Config {
    private static Config instance = new Config();

    public static Config getInstance() {
        return instance;
    }
    private CommentedConfigurationNode config;
    @Inject @ConfigDir(sharedRoot = false) private File configDir;
    String path = "config"+File.separator+"PokedexRewards";
    private File configFile = new File(path, "config.conf");
    private ConfigurationLoader<CommentedConfigurationNode> configLoader = HoconConfigurationLoader.builder().setFile(configFile).build();

    public ItemType Type(String item) {
        ItemType i = Sponge.getGame().getRegistry().getType(ItemType.class,item).get();
        return i;
    }

    public void configCreate() throws ObjectMappingException {
        try {
            if(!configFile.getParentFile().exists()) configFile.getParentFile().mkdir();
            configFile.createNewFile();
            configLoad();
            CommentedConfigurationNode rewards = config.getNode("rewards").setComment("PokeDex Rewards by Xenoyia!");
            ItemStack reward10 = ItemStack.builder()
                    .itemType(Type("pixelmon:tm114"))
                    .quantity(1)
                    .build();
            ItemStack reward10b = ItemStack.builder()
                    .itemType(Type("pixelmon:poke_ball"))
                    .quantity(16)
                    .build();
            ItemStack reward20 = ItemStack.builder()
                    .itemType(Type("pixelmon:tm28"))
                    .quantity(1)
                    .build();
            ItemStack reward20b = ItemStack.builder()
                    .itemType(Type("pixelmon:great_ball"))
                    .quantity(8)
                    .build();
            ItemStack reward30 = ItemStack.builder()
                    .itemType(Type("pixelmon:park_ball"))
                    .quantity(1)
                    .build();
            ItemStack reward30b = ItemStack.builder()
                    .itemType(Type("pixelmon:tm59"))
                    .quantity(1)
                    .build();
            ItemStack reward40 = ItemStack.builder()
                    .itemType(Type("pixelmon:tm38"))
                    .quantity(1)
                    .build();
            ItemStack reward40b = ItemStack.builder()
                    .itemType(Type("pixelmon:ultra_ball"))
                    .quantity(16)
                    .build();
            ItemStack reward50 = ItemStack.builder()
                    .itemType(Type("pixelmon:tm122"))
                    .quantity(1)
                    .build();
            ItemStack reward50b = ItemStack.builder()
                    .itemType(Type("pixelmon:repeat_ball"))
                    .quantity(8)
                    .build();
            ItemStack reward60 = ItemStack.builder()
                    .itemType(Type("pixelmon:tm24"))
                    .quantity(1)
                    .build();
            ItemStack reward60b = ItemStack.builder()
                    .itemType(Type("pixelmon:quick_ball"))
                    .quantity(8)
                    .build();
            ItemStack reward70 = ItemStack.builder()
                    .itemType(Type("pixelmon:park_ball"))
                    .quantity(1)
                    .build();
            ItemStack reward70b = ItemStack.builder()
                    .itemType(Type("pixelmon:quick_ball"))
                    .quantity(16)
                    .build();
            ItemStack reward80 = ItemStack.builder()
                    .itemType(Type("pixelmon:park_ball"))
                    .quantity(2)
                    .build();
            ItemStack reward80b = ItemStack.builder()
                    .itemType(Type("pixelmon:ether"))
                    .quantity(2)
                    .build();
            ItemStack reward80c = ItemStack.builder()
                    .itemType(Type("pixelmon:max_revive"))
                    .quantity(2)
                    .build();
            ItemStack reward90 = ItemStack.builder()
                    .itemType(Type("pixelmon:park_ball"))
                    .quantity(2)
                    .build();
            ItemStack reward90b = ItemStack.builder()
                    .itemType(Type("pixelmon:ether"))
                    .quantity(4)
                    .build();
            ItemStack reward90c = ItemStack.builder()
                    .itemType(Type("pixelmon:max_revive"))
                    .quantity(4)
                    .build();
            ItemStack rewardfinal = ItemStack.builder()
                    .itemType(Type("pixelmon:dynamo_badge"))
                    .quantity(1)
                    .build();
            ItemStack rewardfinalb = ItemStack.builder()
                    .itemType(Type("pixelmon:ether"))
                    .quantity(8)
                    .build();
            ItemStack rewardfinalc = ItemStack.builder()
                    .itemType(Type("pixelmon:max_revive"))
                    .quantity(8)
                    .build();
            rewards.getNode("reward10", "shinyTokens").setValue("0");
            rewards.getNode("reward10", "numberOfRewards").setValue(2);
            rewards.getNode("reward10", "moneyReward").setValue("100");
            rewards.getNode("reward10", 1, "item").setValue(TypeToken.of(ItemStack.class), reward10);
            rewards.getNode("reward10", 2, "item").setValue(TypeToken.of(ItemStack.class), reward10b);
            rewards.getNode("reward20", "shinyTokens").setValue("0");
            rewards.getNode("reward20", "moneyReward").setValue("150");
            rewards.getNode("reward20", "numberOfRewards").setValue(2);
            rewards.getNode("reward20", 1, "item").setValue(TypeToken.of(ItemStack.class), reward20);
            rewards.getNode("reward20", 2, "item").setValue(TypeToken.of(ItemStack.class), reward20b);
            rewards.getNode("reward20", 2, "command").setValue("say This is an example command reward! %player% can be used as a placeholder!");
            rewards.getNode("reward30", "shinyTokens").setValue("0");
            rewards.getNode("reward30", "moneyReward").setValue("200");
            rewards.getNode("reward30", "numberOfRewards").setValue(2);
            rewards.getNode("reward30", 1, "item").setValue(TypeToken.of(ItemStack.class), reward30);
            rewards.getNode("reward30", 2, "item").setValue(TypeToken.of(ItemStack.class), reward30b);
            rewards.getNode("reward40", "shinyTokens").setValue("0");
            rewards.getNode("reward40", "moneyReward").setValue("250");
            rewards.getNode("reward40", "numberOfRewards").setValue(2);
            rewards.getNode("reward40", 1, "item").setValue(TypeToken.of(ItemStack.class), reward40);
            rewards.getNode("reward40", 2, "item").setValue(TypeToken.of(ItemStack.class), reward40b);
            rewards.getNode("reward50", "shinyTokens").setValue("1");
            rewards.getNode("reward50", "moneyReward").setValue("300");
            rewards.getNode("reward50", "numberOfRewards").setValue(2);
            rewards.getNode("reward50", 1, "item").setValue(TypeToken.of(ItemStack.class), reward50);
            rewards.getNode("reward50", 2, "item").setValue(TypeToken.of(ItemStack.class), reward50b);
            rewards.getNode("reward60", "shinyTokens").setValue("0");
            rewards.getNode("reward60", "moneyReward").setValue("500");
            rewards.getNode("reward60", "numberOfRewards").setValue(2);
            rewards.getNode("reward60", 1, "item").setValue(TypeToken.of(ItemStack.class), reward60);
            rewards.getNode("reward60", 2, "item").setValue(TypeToken.of(ItemStack.class), reward60b);
            rewards.getNode("reward70", "shinyTokens").setValue("0");
            rewards.getNode("reward70", "moneyReward").setValue("800");
            rewards.getNode("reward70", "numberOfRewards").setValue(2);
            rewards.getNode("reward70", 1, "item").setValue(TypeToken.of(ItemStack.class), reward70);
            rewards.getNode("reward70", 2, "item").setValue(TypeToken.of(ItemStack.class), reward70b);
            rewards.getNode("reward80", "shinyTokens").setValue("0");
            rewards.getNode("reward80", "moneyReward").setValue("1600");
            rewards.getNode("reward80", "numberOfRewards").setValue(3);
            rewards.getNode("reward80", 1, "item").setValue(TypeToken.of(ItemStack.class), reward80);
            rewards.getNode("reward80", 2, "item").setValue(TypeToken.of(ItemStack.class), reward80b);
            rewards.getNode("reward80", 3, "item").setValue(TypeToken.of(ItemStack.class), reward80c);
            rewards.getNode("reward90", "shinyTokens").setValue("0");
            rewards.getNode("reward90", "moneyReward").setValue("3500");
            rewards.getNode("reward90", "numberOfRewards").setValue(3);
            rewards.getNode("reward90", 1, "item").setValue(TypeToken.of(ItemStack.class), reward90);
            rewards.getNode("reward90", 2, "item").setValue(TypeToken.of(ItemStack.class), reward90b);
            rewards.getNode("reward90", 3, "item").setValue(TypeToken.of(ItemStack.class), reward90c);
            rewards.getNode("rewardfinal", "shinyTokens").setValue("3");
            rewards.getNode("rewardfinal", "moneyReward").setValue("8000");
            rewards.getNode("rewardfinal", "numberOfRewards").setValue(3);
            rewards.getNode("rewardfinal", 1, "item").setValue(TypeToken.of(ItemStack.class), rewardfinal);
            rewards.getNode("rewardfinal", 2, "item").setValue(TypeToken.of(ItemStack.class), rewardfinalb);
            rewards.getNode("rewardfinal", 3, "item").setValue(TypeToken.of(ItemStack.class), rewardfinalc);
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
