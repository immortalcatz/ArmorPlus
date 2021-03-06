package sokratis12GR.ArmorPlus.commands.subcommands;

/**
 * sokratis12GR.ArmorPlus.commands.subcommands
 * ArmorPlus created by sokratis12GR on 6/25/2016 9:59 AM.
 */

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import sokratis12GR.ArmorPlus.commands.CommandArmorPlus;
import sokratis12GR.ArmorPlus.commands.ISubCommand;
import sokratis12GR.ArmorPlus.commands.SubCommandBase;
import sokratis12GR.ArmorPlus.util.TextHelper;

public class SubCommandHelp extends SubCommandBase {

    public SubCommandHelp(ICommand parent) {
        super(parent, "help");
    }

    @Override
    public String getArgUsage(ICommandSender commandSender) {
        return TextHelper.localize("commands.help.usage");
    }

    @Override
    public String getHelpText() {
        return TextHelper.localizeEffect("commands.help.help");
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public void processSubCommand(MinecraftServer server, ICommandSender commandSender, String[] args) {
        super.processSubCommand(server, commandSender, args);

        if (args.length > 0)
            return;

        for (ISubCommand subCommand : ((CommandArmorPlus) getParentCommand()).getSubCommands().values())
            commandSender.addChatMessage(new TextComponentString(TextHelper.localizeEffect("commands.format.help", capitalizeFirstLetter(subCommand.getSubCommandName()), subCommand.getArgUsage(commandSender))));
    }
}