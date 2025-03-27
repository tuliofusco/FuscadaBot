package com.tuliofusco.fuscadabot.commands.misc;

import com.tuliofusco.fuscadabot.Main;
import com.tuliofusco.fuscadabot.commands.core.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.List;

public class HelpCommand implements ICommand {

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Dá a lista de comandos do servidor.";
    }

    @Override
    public List<OptionData> getOptions() {
        return null;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        EmbedBuilder embed = new EmbedBuilder().setTitle("Comandos");
        for (ICommand command : Main.getCommandManager().getCommands()){
            embed.addField("/" + command.getName(), command.getDescription(), false);
        }

        event.replyEmbeds(embed.build()).queue();
    }
}
