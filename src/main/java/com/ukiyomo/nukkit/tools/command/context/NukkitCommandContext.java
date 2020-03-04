package com.ukiyomo.nukkit.tools.command.context;

import cn.nukkit.command.CommandSender;
import com.ukiyomo.tools.simpleCommand.context.CommandContext;

public class NukkitCommandContext extends CommandContext {

    private CommandSender commandSender;

    public NukkitCommandContext(String label, CommandSender commandSender) {
        super(label);
        this.commandSender = commandSender;
    }

    public CommandSender getCommandSender() {
        return commandSender;
    }
}
