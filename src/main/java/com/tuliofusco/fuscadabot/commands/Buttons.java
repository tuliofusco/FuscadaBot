package com.tuliofusco.fuscadabot.commands;

import com.tuliofusco.fuscadabot.commands.core.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyCallbackAction;

import java.awt.*;
import java.util.List;

public class Buttons implements ICommand {

    @Override
    public String getName() {
        return "button";
    }

    @Override
    public String getDescription() {
        return "Buttons";
    }

    @Override
    public List<OptionData> getOptions() {
        return null;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("Question");
        embed.setDescription("Do you like pizza?");

        Button yesButton = Button.danger("yes-button", "Yes");
        Button noButton = Button.danger("no-button", "No");

        ReplyCallbackAction reply = event.replyEmbeds(embed.build()).addActionRow(yesButton, noButton);

        reply.queue();
    }
}
