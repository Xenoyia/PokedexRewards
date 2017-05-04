package com.xpgaming.xPPokeDex;
import java.io.File;
import java.io.IOException;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;

public class Config {
    private static Config instance = new Config();

    public static Config getInstance() {
        return instance;
    }

    private ConfigurationLoader<CommentedConfigurationNode> configLoader;
    private CommentedConfigurationNode config;
    private File configFile;

    public void configCreate() {
        try {
            configFile.createNewFile();
            configLoad();
            CommentedConfigurationNode rewards = config.getNode("rewards").setComment("xP// PokeDex coded by Xenoyia! Check out mc.xpgaming.com!");
            rewards.getNode("10").setValue("ultra_ball:1,diamond:1");
            rewards.getNode("20").setValue("ultra_ball:2,diamond:2");
            rewards.getNode("30").setValue("ultra_ball:4,diamond:4");
            rewards.getNode("40").setValue("ultra_ball:8,diamond:8");
            rewards.getNode("50").setValue("ultra_ball:16,diamond:16");
            rewards.getNode("60").setValue("ultra_ball:32,diamond:32");
            rewards.getNode("70").setValue("ultra_ball:64,diamond:64");
            rewards.getNode("80").setValue("master_ball:1");
            rewards.getNode("90").setValue("master_ball:2");
            rewards.getNode("100").setValue("master_ball:3");
            configSave();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setup(File configFile, ConfigurationLoader<CommentedConfigurationNode> configLoader) {
        this.configLoader = configLoader;
        this.configFile = configFile;
        if (!configFile.exists()) {
            configCreate();
        } else
            configLoad();
    }

    public CommentedConfigurationNode getConfig() {
        return config;
    }

    public void configLoad() {
        if (!configFile.exists()) {
            configCreate();
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
