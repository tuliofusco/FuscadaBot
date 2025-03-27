package com.tuliofusco.fuscadabot.commands.fun;

import com.tuliofusco.fuscadabot.commands.core.ICommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.List;

public class PingPongCommand implements ICommand {

    @Override
    public String getName() {
        return "ping";
    }

    @Override
    public String getDescription() {
        return "O Bot responde com 'Pong!'.";
    }

    @Override
    public List<OptionData> getOptions() {
        return null;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        event.reply("Pong!").queue();
    }
}
