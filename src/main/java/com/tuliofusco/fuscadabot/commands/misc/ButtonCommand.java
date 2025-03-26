package com.tuliofusco.fuscadabot.commands.misc;

import com.tuliofusco.fuscadabot.commands.core.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyCallbackAction;

import java.util.List;

public class ButtonCommand implements ICommand {

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
        embed.setTitle("Pergunta");
        embed.setDescription("Você gosta de pizza?");

        Button yesButton = Button.danger("yes-button", "Sim");
        Button noButton = Button.danger("no-button", "Não");

        ReplyCallbackAction reply = event.replyEmbeds(embed.build()).addActionRow(yesButton, noButton);

        reply.queue();
    }
}
