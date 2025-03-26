package com.tuliofusco.fuscadabot.commands.misc;

import com.tuliofusco.fuscadabot.commands.core.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.awt.*;
import java.util.List;

public class EmbedCommand implements ICommand {

    @Override
    public String getName() {
        return "embed";
    }

    @Override
    public String getDescription() {
        return "Envia uma embed teste";
    }

    @Override
    public List<OptionData> getOptions() {
        return null;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("Embed teste");
        embed.setDescription("Description");
        embed.addField("Field 1", "Value", false);
        embed.addField("Field 2", "Value", false);
        embed.addField("Field 3", "Value", false);
        embed.setFooter("Footer");
        embed.setColor(Color.BLUE);

        event.replyEmbeds(embed.build()).queue();
    }
}
