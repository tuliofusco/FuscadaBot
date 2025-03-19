package com.tuliofusco;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Listeners extends ListenerAdapter {

    @Override
    public void onReady(ReadyEvent event) { // Bot start event
        JDA jda = event.getJDA();
        for (Guild guild : jda.getGuilds()) { // Shows the servers that the bot is connected to
            for(TextChannel channel : guild.getTextChannels()){ // For each text channel on the server, send "hello"
                channel.sendMessage("Hello").queue();
            }
        }
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) { // Message received event
        if(event.getAuthor().isBot()) return; // If event author is the bot, return
        MessageChannel channel = event.getChannel(); // Gets the channel of the message
        channel.sendMessage(event.getMessage().getContentRaw()).queue(); // Sends the same message that was recieved
    }
}
