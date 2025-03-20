package com.tuliofusco.fuscadabot;

import com.tuliofusco.fuscadabot.commands.Sum;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class Main {

    private static Dotenv dotenv = Dotenv.load();
    private static String token = dotenv.get("DISCORD_BOT_TOKEN");
    
    public static void main(String[] args) throws LoginException {
        JDA jda = JDABuilder.createDefault(token).enableIntents(GatewayIntent.MESSAGE_CONTENT).build(); // inicia o bot

        jda.addEventListener(new Listeners()); // permite o JDA chamar eventos

        CommandManager manager = new CommandManager();
        manager.addCommand(new Sum()); // adiciona o comando Sum
        jda.addEventListener(manager); // permite o JDA chamar comandos
    }

}
