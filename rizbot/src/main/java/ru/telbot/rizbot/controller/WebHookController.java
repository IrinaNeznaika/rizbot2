/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.telbot.rizbot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.telbot.rizbot.MyWizardTelegramBot;

/**
 *
 * @author user
 */
@Slf4j
@RestController
public class WebHookController {
    private final MyWizardTelegramBot telegramBot;
    
    public WebHookController(MyWizardTelegramBot telegramBot){
        this.telegramBot = telegramBot;
    }
    
    @RequestMapping(value="/", method = RequestMethod.POST)
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update){
        return telegramBot.onWebhookUpdateReceived(update);
    }
}
