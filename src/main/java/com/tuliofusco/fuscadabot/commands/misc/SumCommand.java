package com.tuliofusco.fuscadabot.commands.misc;

import com.tuliofusco.fuscadabot.commands.core.ICommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.ArrayList;
import java.util.List;

public class SumCommand implements ICommand {

    @Override
    public String getName() {
        return "sum";
    }

    @Override
    public String getDescription() {
        return "Dá a soma de dois números";
    }

    @Override
    public List<OptionData> getOptions() {
        List<OptionData> options = new ArrayList<>();

        options.add(new OptionData(OptionType.INTEGER, "number1", "Primeiro número", true));
        options.add(new OptionData(OptionType.INTEGER, "number2", "Segundo número", true));

        return options;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("sum")) return; // se não é o "/sum", retorne

        OptionMapping number1 = event.getOption("number1"); // pega o numero da OptionData nas command options
        OptionMapping number2 = event.getOption("number2"); // pega o numero da OptionData nas command options
        int n1 = number1.getAsInt();
        int n2 = number2.getAsInt();
        int sum = n1 + n2;

        event.reply(n1 + " + " + n2 + " = " + sum).queue(); // como é uma interacao, usar reply
    }
}
