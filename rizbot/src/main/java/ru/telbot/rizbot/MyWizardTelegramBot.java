/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.telbot.rizbot;

import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 *
 * @author user
 */
public class MyWizardTelegramBot extends TelegramWebhookBot{
    private String webHookPath;
    private String botUserName;
    private String botToken;

    public MyWizardTelegramBot(DefaultBotOptions options) {
        super(options);
    }
    
    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        if(update.getMessage() != null && update.getMessage().hasText()){
            long chat_id = update.getMessage().getChatId();

            try {
                execute(new SendMessage(String.valueOf(chat_id), "Hi, " + update.getMessage().getText() + "!!!"));
            } catch (TelegramApiException e) {
                System.out.println("exception: " + e);
            }
        }
        return null;
    }

    @Override
    public String getBotPath() {
        return webHookPath;
    }

    @Override
    public String getBotUsername() {
        return botUserName;
    }

    @Override
    public void onRegister() {
        super.onRegister(); 
    }

    public void setWebHookPath(String webHookPath) {
        this.webHookPath = webHookPath;
    }

    public void setBotUserName(String botUserName) {
        this.botUserName = botUserName;
    }

    public void setBotToken(String botToken) {
        this.botToken = botToken;
    }

    
} 
   
