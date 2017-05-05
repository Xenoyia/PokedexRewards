package com.xpgaming.xPPokeDex;
import com.google.inject.Inject;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.config.ConfigDir;
import org.spongepowered.api.config.DefaultConfig;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.plugin.Dependency;
import org.spongepowered.api.plugin.Plugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.api.text.Text;

import java.io.File;

@Plugin(id = Main.id, name = Main.name, version = "0.2", dependencies = {@Dependency(id = "pixelmon")})
public class Main {
    public static final String id = "xppokedex";
    public static final String name = "xP// PokeDex";
    private static final Logger log = LoggerFactory.getLogger(name);

    CommandSpec claim = CommandSpec.builder()
            .description(Text.of("Claim PokeDex rewards!"))
            .permission("xpgaming.pokedex.claim")
            .executor(new Claim())
            .build();

    CommandSpec remaining = CommandSpec.builder()
            .description(Text.of("List Pokémon left to catch!"))
            .permission("xpgaming.pokedex.remaining")
            .executor(new Remaining())
            .build();

    CommandSpec count = CommandSpec.builder()
            .description(Text.of("Count number of Pokemon caught!"))
            .permission("xpgaming.pokedex.count")
            .executor(new Count())
            .build();

    CommandSpec reload = CommandSpec.builder()
            .description(Text.of("Reload the config!"))
            .permission("xpgaming.pokedex.reload")
            .executor(new Reload())
            .build();

    CommandSpec pokedex = CommandSpec.builder()
            .description(Text.of("PokéDex things!"))
            .permission("xpgaming.pokedex")
            .child(claim, "cl", "claim")
            .child(reload, "rl", "reload")
            .child(count, "c", "count", "co")
            .child(remaining, "r", "remaining", "remain", "rem")
            .executor(new PokedexBase())
            .build();

    @Inject
    @DefaultConfig(sharedRoot = true)
    private File configFile;

    @Inject
    @DefaultConfig(sharedRoot = true)
    ConfigurationLoader<CommentedConfigurationNode> configLoader;

    @Listener
    public void onGameInitialization(GameInitializationEvent event) {
        Config.getInstance().setup(configFile, configLoader);
        log.info("Loaded v0.2!");
        Sponge.getCommandManager().register(this, pokedex, "pokedex", "pd", "dex");
    }
}
