package com.tuliofusco.fuscadabot.commands;

import com.tuliofusco.fuscadabot.ICommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.ArrayList;
import java.util.List;

public class Sum implements ICommand {

    @Override
    public String getName() {
        return "sum";
    }

    @Override
    public String getDescription() {
        return "Gives the sum of two numbers";
    }

    @Override
    public List<OptionData> getOptions() {
        List<OptionData> options = new ArrayList<>();

        options.add(new OptionData(OptionType.INTEGER, "number1", "The first number", true));
        options.add(new OptionData(OptionType.INTEGER, "number2", "The second number", true));

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
