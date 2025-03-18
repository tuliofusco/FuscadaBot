package com.tuliofusco;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import io.github.cdimascio.dotenv.Dotenv;

import javax.security.auth.login.LoginException;

public class Main {

    static Dotenv dotenv = Dotenv.load();
    static String token = dotenv.get("DISCORD_BOT_TOKEN");

    public static void main(String[] args) throws LoginException {
        JDA jda = JDABuilder.createDefault(token).build();
    }

}
