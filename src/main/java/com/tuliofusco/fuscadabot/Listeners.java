package com.tuliofusco.fuscadabot;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

public class Listeners extends ListenerAdapter {

    private Dotenv dotenv = Dotenv.load();
    private String myGuildId = dotenv.get("TEST_GUILD_ID");

    @Override
    public void onReady(ReadyEvent event) { // bot start event
//        Guild guild = event.getJDA().getGuildById(myGuildId); // for guild specific slash commands
        event.getJDA().upsertCommand("sum", "Gives the sum of two numbers").addOptions( // for global slash commands
                    new OptionData(OptionType.INTEGER, "number1", "The first number", true),
                    new OptionData(OptionType.INTEGER, "number2", "The second number", true)
        ).queue();

//        for (Guild guild : jda.getGuilds()) { // shows the servers that the bot is connected to
//            for(TextChannel channel : guild.getTextChannels()){ // for each text channel on the server, send "hello"
//                channel.sendMessage("Hello").queue();
//            }
//        }
    }

//    @Override
//    public void onMessageReceived(MessageReceivedEvent event) { // message received event
//        if(event.getAuthor().isBot()) return; // if event author is the bot, return
//        MessageChannel channel = event.getChannel(); // gets the channel of the message
//        channel.sendMessage(event.getMessage().getContentRaw()).queue(); // sends the same message that was recieved
//    }
}
