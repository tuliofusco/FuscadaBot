package com.tuliofusco.fuscadabot.commands.admin;

import com.tuliofusco.fuscadabot.commands.core.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BanCommand implements ICommand {

    @Override
    public String getName() {
        return "ban";
    }

    @Override
    public String getDescription() {
        return "Bane uma conta permanentemente.";
    }

    @Override
    public List<OptionData> getOptions() {
        List<OptionData> options = new ArrayList<OptionData>();
        options.add(new OptionData(OptionType.USER, "usuario", "O usuário para banir", true));
        options.add(new OptionData(OptionType.STRING, "motivo", "O Motivo do Banimento", false));
        return options;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        Member member = event.getMember();
        if (member.hasPermission(Permission.BAN_MEMBERS)){
            Member banned = event.getOption("usuario").getAsMember();
            String reason = event.getOption("motivo") != null ? event.getOption("motivo").getAsString() : null;
            if (banned != null){
                EmbedBuilder embed = new EmbedBuilder();
                if (reason != null){
                    banned.ban(0, TimeUnit.SECONDS)
                            .reason(reason)
                            .queue();

                            embed.setTitle("BANIMENTO")
                            .addField("Banido", banned.getAsMention(), false)
                            .addField("Banido por", member.getAsMention(), false)
                            .addField("Motivo", reason, false);
                }else{
                    banned.ban(0, TimeUnit.SECONDS)
                            .queue();

                            embed.setTitle("BANIMENTO")
                            .addField("Banido", banned.getAsMention(), false)
                            .addField("Banido por", member.getAsMention(), false);
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
