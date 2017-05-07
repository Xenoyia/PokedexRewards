package com.xpgaming.xPPokeDex;
import com.google.inject.Inject;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.config.DefaultConfig;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.entity.InteractEntityEvent;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.service.ChangeServiceProviderEvent;
import org.spongepowered.api.plugin.Dependency;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.service.economy.EconomyService;
import org.spongepowered.api.service.economy.account.UniqueAccount;
import org.spongepowered.api.service.economy.transaction.ResultType;
import org.spongepowered.api.service.economy.transaction.TransactionResult;
import org.spongepowered.api.text.Text;

import java.io.File;
import java.math.BigDecimal;
import java.util.Optional;

@Plugin(id = Main.id, name = Main.name, version = "0.3", dependencies = {@Dependency(id = "pixelmon")})
public class Main {
    private static Main instance = new Main();
    public static Main getInstance() {
        return instance;
    }
    public static final String id = "xppokedex";
    public static final String name = "xP// PokeDex";
    private static final Logger log = LoggerFactory.getLogger(name);

    private static EconomyService economyService;

    @Listener
    public void onChangeServiceProvider(ChangeServiceProviderEvent event) {
        if (event.getService().equals(EconomyService.class)) {
            economyService = (EconomyService) event.getNewProviderRegistration().getProvider();
        }
    }

    public void addMoney(Player p, int amount) {
        Optional<UniqueAccount> uOpt = economyService.getOrCreateAccount(p.getUniqueId());
        if(uOpt.isPresent()) {
            UniqueAccount account = uOpt.get();
            BigDecimal requiredAmount = BigDecimal.valueOf(amount);
            TransactionResult result = account.deposit(economyService.getDefaultCurrency(), requiredAmount, Cause.source(this).build());
            if (!(result.getResult() == ResultType.SUCCESS)) {
                p.sendMessage(Text.of("\u00A7f[\u00A7cPokeDex\u00A7f] \u00A7cUnable to give money, something broke!"));
            }
        }
    }

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
            .permission("xpgaming.pokedex.admin")
            .executor(new Reload())
            .build();

    CommandSpec getshinytoken = CommandSpec.builder()
            .description(Text.of("Get a shiny token!"))
            .permission("xpgaming.pokedex.admin")
            .executor(new GetShinyToken())
            .build();

    CommandSpec convert = CommandSpec.builder()
            .description(Text.of("Convert <slot> into a shiny!"))
            .arguments(GenericArguments.onlyOne(GenericArguments.integer(Text.of("slot"))))
            .permission("xpgaming.pokedex.convert")
            .executor(new Convert())
            .build();

    CommandSpec pokedex = CommandSpec.builder()
            .description(Text.of("PokéDex things!"))
            .permission("xpgaming.pokedex")
            .child(claim, "cl", "claim")
            .child(reload, "rl", "reload")
            .child(count, "c", "count", "co")
            .child(getshinytoken, "gst", "gettoken", "getshinytoken")
            .child(convert, "con", "convert", "conv")
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
        log.info("Loaded v0.3!");
        Sponge.getCommandManager().register(this, pokedex, "pokedex", "pd", "dex");
        Sponge.getServiceManager().provide(EconomyService.class);
    }
}
