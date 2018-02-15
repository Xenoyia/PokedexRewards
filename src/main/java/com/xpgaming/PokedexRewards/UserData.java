package com.xpgaming.PokedexRewards;

import com.google.inject.Inject;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;
import org.spongepowered.api.config.ConfigDir;

import java.io.File;
import java.io.IOException;

public class UserData {
    private static UserData instance = new UserData();

    public static UserData getInstance() {
        return instance;
    }

    private CommentedConfigurationNode data;
    @Inject @ConfigDir(sharedRoot = false) private File configDir;
    String path = "config"+File.separator+"PokedexRewards";
    private File dataFile = new File(path, "data.conf");
    private ConfigurationLoader<CommentedConfigurationNode> dataLoader = HoconConfigurationLoader.builder().setFile(dataFile).build();

    public void dataCreate() throws ObjectMappingException {
        try {
            if(!dataFile.getParentFile().exists()) dataFile.getParentFile().mkdirs();
            dataFile.createNewFile();
            dataLoad();
            CommentedConfigurationNode pd = data.getNode("playerData").setComment("Do not mess with this unless you know what you are doing!");
            dataSave();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setup(File dataFile, ConfigurationLoader<CommentedConfigurationNode> dataLoader) {
        this.dataLoader = dataLoader;
        this.dataFile = dataFile;
        if (!dataFile.exists()) {
            try {
                dataCreate();
            } catch (ObjectMappingException e) {
                e.printStackTrace();
            }
        } else
            dataLoad();
    }

    public CommentedConfigurationNode getConfig() {
        return data;
    }

    public void dataLoad() {
        if (!dataFile.exists()) {
            try {
                dataCreate();
            } catch (ObjectMappingException e) {
                e.printStackTrace();
            }
        } else
            try {
                data = dataLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public void dataSave() {
        try {
            dataLoader.save(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveAndLoadConfig() {
        dataSave();
        dataLoad();
    }
}
