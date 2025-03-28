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

public class WarnCommand implements ICommand {

    @Override
    public String getName() {
        return "warn";
    }

    @Override
    public String getDescription() {
        return "Dê um aviso a uma conta. Timeout opcional.";
    }

    @Override
    public List<OptionData> getOptions() {
        List<OptionData> options = new ArrayList<OptionData>();
        options.add(new OptionData(OptionType.USER, "usuario", "Usuário para avisar.", true));
        options.add(new OptionData(OptionType.STRING, "motivo", "Motivo do aviso.", true));
        options.add(new OptionData(OptionType.BOOLEAN, "timeout", "Dar timeout?", true));
        options.add(new OptionData(OptionType.INTEGER, "tempo", "Tempo de timeout em minutos (opcional).", false));
        return options;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        Member member = event.getMember();
        if (member.hasPermission(Permission.KICK_MEMBERS)){
            Member target = event.getOption("usuario").getAsMember();
            String reason = event.getOption("motivo").getAsString();
            boolean timeout = event.getOption("timeout").getAsBoolean();

            EmbedBuilder embed = new EmbedBuilder();

            if (timeout){
                Integer timeoutDuration = event.getOption("tempo") != null ? event.getOption("tempo").getAsInt() : 1;

                target.timeoutFor(timeoutDuration, TimeUnit.MINUTES).queue();

                embed.setTitle("AVISO")
                        .addField("Usuário", target.getAsMention(), false)
                        .addField("Motivo", reason, false)
                        .addField("Timeout", timeoutDuration + " minutos", false)
                        .addField("Avisado por", member.getAsMention(), false)
                        .setColor(Color.RED);
            }else {
                embed.setTitle("AVISO")
                        .addField("Usuário", target.getAsMention(), false)
                        .addField("Motivo", reason, false)
                        .addField("Avisado por", member.getAsMention(), false)
                        .setColor(Color.RED);
            }

            event.replyEmbeds(embed.build()).queue();

        }else {
            event.reply("Você não tem permissão para utilizar esse comando.").queue();
        }
    }
}
