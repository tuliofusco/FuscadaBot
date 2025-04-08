package com.tuliofusco.fuscadabot.commands.admin;

import com.tuliofusco.fuscadabot.commands.core.ICommand;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.ArrayList;
import java.util.List;

public class SetWelcomeChannelCommand implements ICommand {

    @Override
    public String getName() {
        return "setwelcome";
    }

    @Override
    public String getDescription() {
        return "Define o canal de boas vindas.";
    }

    @Override
    public List<OptionData> getOptions() {
        List<OptionData> options = new ArrayList<>();

        options.add(new OptionData(OptionType.CHANNEL, "canal", "Canal de boas vindas", false));

        return options;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        if(event.getMember().hasPermission(Permission.MANAGE_CHANNEL)){

        }
    }
}
