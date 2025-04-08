package com.tuliofusco.fuscadabot.listeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.modals.ModalMapping;

import java.awt.*;

public class Listeners extends ListenerAdapter {

//    private Dotenv dotenv = Dotenv.load();
//    private String myGuildId = dotenv.get("TEST_GUILD_ID");

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {

    }

    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        if(event.getButton().getId().equals("yes-button")){
            event.reply("Boa!").queue();
        }else if(event.getButton().getId().equals("no-button")){
            event.reply("Ahh, que isso?!").queue();
        }
        event.getMessage().delete().queue();
    }

    @Override
    public void onModalInteraction(ModalInteractionEvent event) {
        if(event.getModalId().equals("person-modal")){
            ModalMapping nameValue = event.getValue("name-field");
            ModalMapping ageValue = event.getValue("age-field");
            ModalMapping descriptionValue = event.getValue("description-field");

            String name = nameValue.getAsString();
            String description = descriptionValue.getAsString();

            String age;
            if(ageValue.getAsString().isBlank()){
                age = "N/A";
            }else{
                age = ageValue.getAsString();
            }

            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("Descrição de " + name);
            embed.addField("Nome", name, false);
            embed.addField("Idade", age, false);
            embed.addField("Descrição", description, false);

            embed.setColor(Color.BLUE);

            event.replyEmbeds(embed.build()).queue();
        }
    }

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
