package com.tuliofusco.fuscadabot.commands.misc;

import com.tuliofusco.fuscadabot.commands.core.ICommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import net.dv8tion.jda.api.interactions.modals.Modal;

import java.util.List;

public class ModalCommand implements ICommand {

    @Override
    public String getName() {
        return "modal";
    }

    @Override
    public String getDescription() {
        return "Opens a modal";
    }

    @Override
    public List<OptionData> getOptions() {
        return List.of();
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        TextInput name = TextInput.create("name-field", "Nome", TextInputStyle.SHORT)
                .setRequired(true)
                .build();

        TextInput age = TextInput.create("age-field", "Idade", TextInputStyle.SHORT)
                .setRequired(false)
                .build();

        TextInput description = TextInput.create("description-field", "Descrição", TextInputStyle.PARAGRAPH)
                .setRequired(true)
                .setPlaceholder("Descreva você mesmo")
                .build();

        Modal modal = Modal.create("person-modal", "Descreva você mesmo")
                .addActionRow(name)
                .addActionRow(age)
                .addActionRow(description)
                .build();

        event.replyModal(modal).queue();
    }
}
