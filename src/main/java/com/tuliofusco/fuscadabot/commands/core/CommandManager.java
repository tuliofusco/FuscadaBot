package com.tuliofusco.fuscadabot.commands.core;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.List;

public class CommandManager extends ListenerAdapter {

    private List<ICommand> commands = new ArrayList<>();

    // ao iniciar (onReady), percorre por todas as guilds e registra cada comando usando o upsertCommand.
    // isso garante que os comandos estejam disponiveis em todas as guilds.
    @Override
    public void onReady(ReadyEvent event) {
        for (Guild guild : event.getJDA().getGuilds()) {
            for (ICommand command : commands){
                if (command.getOptions() == null){
                    guild.upsertCommand(command.getName(), command.getDescription()).queue();
                } else{
                    guild.upsertCommand(command.getName(), command.getDescription()).addOptions(command.getOptions()).queue();
                }
            }
        }
    }

    // ativa quando um usuario usa um comando de barra, ele percorre todos os comandos da lista,
    // checa se o comando usado bate com algum comando registrado e se bater, executa.
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        for (ICommand command : commands){
            if(command.getName().equals(event.getName())){
                command.execute(event);
                return;
            }
        }
    }

    public void addCommand(ICommand command) {
        commands.add(command);
    }

    public List<ICommand> getCommands() {
        return commands;
    }

}
