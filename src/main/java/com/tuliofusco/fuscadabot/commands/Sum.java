package com.tuliofusco.fuscadabot.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class Sum extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("sum")) return; // if it's not "/sum", return

        OptionMapping number1 = event.getOption("number1"); // gets the number of the OptionData from command options
        OptionMapping number2 = event.getOption("number2"); // gets the number of the OptionData from command options
        int n1 = number1.getAsInt();
        int n2 = number2.getAsInt();
        int sum = n1 + n2;

        event.reply(n1 + " + " + n2 + " = " + sum).queue(); // because this is an interaction, we have to reply it (slash commands)
    }
}
