package com.tuliofusco.fuscadabot.commands.admin;

import com.tuliofusco.fuscadabot.commands.core.ICommand;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.ArrayList;
import java.util.List;

public class ClearCommand implements ICommand {

    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getDescription() {
        return "Limpa uma quantidade de mensagens.";
    }

    @Override
    public List<OptionData> getOptions() {
        List<OptionData> options = new ArrayList<>();

        options.add(new OptionData(OptionType.INTEGER, "quantidade", "Quantidade de mensagens", true).setMinValue(1).setMaxValue(100));

        return options;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {

        if (event.getMember().hasPermission(Permission.MESSAGE_MANAGE)){
            int amount = event.getOption("quantidade").getAsInt();

            List<Message> messages = event.getChannel().getHistory().retrievePast(amount).complete();
            event.getChannel().purgeMessages(messages);

            event.reply("Foram excluídas " + amount + " mensagens.").queue();
        }

    }
}
