package com.tuliofusco.fuscadabot.commands.admin;

import com.tuliofusco.fuscadabot.commands.core.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class KickCommand implements ICommand {

    @Override
    public String getName() {
        return "kick";
    }

    @Override
    public String getDescription() {
        return "Kicka uma conta do servidor";
    }

    @Override
    public List<OptionData> getOptions() {
        List<OptionData> options = new ArrayList<>();

        options.add(new OptionData(OptionType.USER, "usuario", "Usuário para dar kick", true));
        options.add(new OptionData(OptionType.STRING, "motivo", "Motivo do kick", false));

        return options;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        Member member = event.getMember();
        if (member.hasPermission(Permission.KICK_MEMBERS)){
            Member kicked = event.getOption("usuario").getAsMember();
            String reason = event.getOption("motivo") != null ? event.getOption("motivo").getAsString() : null;
            if (kicked != null){
                EmbedBuilder embed = new EmbedBuilder();
                if (reason != null){
                    kicked.kick()
                            .reason(reason)
                            .queue();

                    embed.setTitle("KICK")
                            .addField("Kickado", kicked.getAsMention(), false)
                            .addField("Kickado por", member.getAsMention(), false)
                            .addField("Motivo", reason, false)
                            .setColor(Color.DARK_GRAY);
                }else{
                    kicked.ban(0, TimeUnit.SECONDS)
                            .queue();

                    embed.setTitle("KICK")
                            .addField("Kickado", kicked.getAsMention(), false)
                            .addField("Kickado por", member.getAsMention(), false)
                            .setColor(Color.DARK_GRAY);
                }
                event.replyEmbeds(embed.build()).queue();
            }else {
                event.reply("Usuário não encontrado").queue();
            }
        }else {
            event.reply("Você não tem permissão para utilizar esse comando.");
        }
    }
}
