package com.tuliofusco.fuscadabot.listeners;

import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Listeners extends ListenerAdapter {

//    private Dotenv dotenv = Dotenv.load();
//    private String myGuildId = dotenv.get("TEST_GUILD_ID");

//    @Override
//    public void onReady(ReadyEvent event) { // evento de inicio do bot
////        Guild guild = event.getJDA().getGuildById(myGuildId); // para comandos de barra de guilds especificas
//        event.getJDA().upsertCommand("sum", "Gives the sum of two numbers").addOptions( // para comandos de barra globais
//                    new OptionData(OptionType.INTEGER, "number1", "The first number", true),
//                    new OptionData(OptionType.INTEGER, "number2", "The second number", true)
//        ).queue();
//
//        for (Guild guild : jda.getGuilds()) { // pega o server que o bot esta conectado
//            for(TextChannel channel : guild.getTextChannels()){ // para cada canal de texto no server, mandar "Hello"
//                channel.sendMessage("Hello").queue();
//            }
//        }
//    }

//    @Override
//    public void onMessageReceived(MessageReceivedEvent event) { // evento de mensagem recebida
//        if(event.getAuthor().isBot()) return; // se o autor do evento é o bot, retorne
//        MessageChannel channel = event.getChannel(); // pega o canal da mensagem
//        channel.sendMessage(event.getMessage().getContentRaw()).queue(); // envia a mesma mensagem que foi recebida
//    }
}
