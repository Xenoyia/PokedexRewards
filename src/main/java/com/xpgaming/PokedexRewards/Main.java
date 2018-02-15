package com.xpgaming.PokedexRewards;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.source.ConsoleSource;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
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

@Plugin(id = Main.id, name = Main.name, version = "0.7", dependencies = {@Dependency(id = "pixelmon")})
public class Main {
    private static Main instance = new Main();
    public static Main getInstance() {
        return instance;
    }
    public static final String id = "pokedexrewards";
    public static final String name = "Pokedex Rewards";
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
            TransactionResult result = account.deposit(economyService.getDefaultCurrency(), requiredAmount, Sponge.getCauseStackManager().getCurrentCause());
            if (!(result.getResult() == ResultType.SUCCESS)) {
                p.sendMessage(Text.of("\u00A7f[\u00A7cPokeDex\u00A7f] \u00A7cUnable to give money, something broke!"));
            }
        }
    }

    CommandSpec claim = CommandSpec.builder()
            .description(Text.of("Claim PokeDex rewards!"))
            .permission("pdrewards.base.claim")
            .executor(new Claim())
            .build();

    CommandSpec remaining = CommandSpec.builder()
            .description(Text.of("List Pokémon left to catch!"))
            .permission("pdrewards.base.remaining")
            .executor(new Remaining())
            .build();

    CommandSpec count = CommandSpec.builder()
            .description(Text.of("Count number of Pokémon caught!"))
            .permission("pdrewards.base.count")
            .executor(new Count())
            .build();

    CommandSpec reload = CommandSpec.builder()
            .description(Text.of("Reload the config!"))
            .permission("pdrewards.admin.reload")
            .executor(new Reload())
            .build();

    CommandSpec getshinytoken = CommandSpec.builder()
            .description(Text.of("Get a shiny token!"))
            .permission("pdrewards.admin.gst")
            .executor(new GetShinyToken())
            .build();

    CommandSpec convert = CommandSpec.builder()
            .description(Text.of("Convert <slot> into a shiny!"))
            .arguments(GenericArguments.onlyOne(GenericArguments.integer(Text.of("slot"))))
            .permission("pdrewards.base.convert")
            .executor(new Convert())
            .build();

    CommandSpec pokedex = CommandSpec.builder()
            .description(Text.of("PokéDex things!"))
            .permission("pdrewards.base")
            .child(claim, "cl", "claim")
            .child(count, "c", "count", "co")
            .child(convert, "con", "convert", "conv")
            .child(remaining, "r", "remaining", "remain", "rem")
            .executor(new PokedexBase())
            .build();

    CommandSpec pokedexAdmin = CommandSpec.builder()
            .description(Text.of("PokéDex admin things!"))
            .permission("pdrewards.admin")
            .child(reload, "rl", "reload")
            .child(getshinytoken, "gst", "gettoken", "getshinytoken")
            .executor(new PokedexAdmin())
            .build();

    String path = "config"+File.separator+"PokedexRewards";

    File configFile  = new File(path,"config.conf");
    ConfigurationLoader<CommentedConfigurationNode> configLoader = HoconConfigurationLoader.builder().setFile(configFile).build();
    File dataFile = new File(path, "data.conf");
    ConfigurationLoader<CommentedConfigurationNode> dataLoader = HoconConfigurationLoader.builder().setFile(dataFile).build();

    @Listener
    public void onGameInitialization(GameInitializationEvent event) {
        Config.getInstance().setup(configFile, configLoader);
        UserData.getInstance().setup(dataFile, dataLoader);
        consoleMsg("§f[§6PokeDex§f] §ePokeDex Rewards - Loaded v0.7!");
        consoleMsg("§f[§6PokeDex§f] §eBy Xenoyia with help from MageFX and XpanD!");
        Sponge.getCommandManager().register(this, pokedex, "pokedex", "pd", "dex");
        Sponge.getCommandManager().register(this, pokedexAdmin, "pokedexadmin", "pda", "dexadmin");
        Sponge.getServiceManager().provide(EconomyService.class);
    }

    private static Optional<ConsoleSource> getConsole() {
        if (Sponge.isServerAvailable())
            return Optional.of(Sponge.getServer().getConsole());
        else
            return Optional.empty();
    }

    public void consoleMsg(String str) {
        getConsole().ifPresent(console ->
                console.sendMessage(Text.of(str)));
    }
}
