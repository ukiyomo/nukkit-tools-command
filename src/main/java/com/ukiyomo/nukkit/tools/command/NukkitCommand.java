package com.ukiyomo.nukkit.tools.command;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import com.ukiyomo.nukkit.tools.command.context.NukkitCommandContext;
import com.ukiyomo.tools.simpleCommand.executor.CommandExecutor;

import java.util.ArrayList;
import java.util.List;

public abstract class NukkitCommand extends Command {

    private List<CommandExecutor> commandExecutors = new ArrayList<CommandExecutor>();

    public NukkitCommand(String name) {
        super(name);
        this.action();
    }

    public NukkitCommand(String name, String description) {
        super(name, description);
        this.action();
    }

    public NukkitCommand(String name, String description, String usageMessage) {
        super(name, description, usageMessage);
        this.action();
    }

    public NukkitCommand(String name, String description, String usageMessage, String[] aliases) {
        super(name, description, usageMessage, aliases);
        this.action();
    }

    abstract public void action();

    public void addCommandExecutor(CommandExecutor commandExecutor, boolean force) {
        if(null == commandExecutor) return;
        if(!this.commandExecutors.contains(commandExecutor) || force) {
            this.commandExecutors.add(commandExecutor);
        }
    }

    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        commandExecutors.forEach(commandExecutor -> {
            commandExecutor.execute(s, strings, new NukkitCommandContext(s, commandSender));
        });
        return true;
    }
}
