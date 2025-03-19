package com.tuliofusco;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class Main {

    private static Dotenv dotenv = Dotenv.load();
    private static String token = dotenv.get("DISCORD_BOT_TOKEN");
    
    public static void main(String[] args) throws LoginException {
        JDA jda = JDABuilder.createDefault(token).enableIntents(GatewayIntent.MESSAGE_CONTENT).build(); // Starts the bot
        jda.addEventListener(new Listeners()); // Allows JDA to call events
    }

}
