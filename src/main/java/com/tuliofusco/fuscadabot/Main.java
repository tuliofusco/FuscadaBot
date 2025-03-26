package com.tuliofusco.fuscadabot;

import com.tuliofusco.fuscadabot.commands.admin.BanCommand;
import com.tuliofusco.fuscadabot.commands.admin.KickCommand;
import com.tuliofusco.fuscadabot.commands.misc.ButtonCommand;
import com.tuliofusco.fuscadabot.commands.misc.EmbedCommand;
import com.tuliofusco.fuscadabot.commands.misc.ModalCommand;
import com.tuliofusco.fuscadabot.commands.misc.SumCommand;
import com.tuliofusco.fuscadabot.commands.core.CommandManager;
import com.tuliofusco.fuscadabot.listeners.Listeners;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class Main {

    private static final Dotenv dotenv = Dotenv.load();
    private static final String token = dotenv.get("DISCORD_BOT_TOKEN");
    
    public static void main(String[] args) throws LoginException {
        JDA jda = JDABuilder.createDefault(token)
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .setStatus(OnlineStatus.ONLINE)
                .setActivity(Activity.customStatus("FuscadaBot v1.0"))
                .build(); // inicia o bot

        jda.addEventListener(new Listeners()); // permite o JDA chamar eventos

        CommandManager manager = new CommandManager();

        // COMANDOS ADMIN
        manager.addCommand(new BanCommand()); // adiciona o comando BanCommand
        manager.addCommand(new KickCommand()); // adiciona o comando kickCommand

        // COMANDOS MISC
        manager.addCommand(new SumCommand()); // adiciona o comando SumCommand
        manager.addCommand(new EmbedCommand()); // adiciona o comando EmbedCommand
        manager.addCommand(new ButtonCommand()); // adiciona o comando ButtonCommand
        manager.addCommand(new ModalCommand()); // adiciona o comando ModalCommand

        jda.addEventListener(manager); // permite o JDA chamar comandos
    }

}
