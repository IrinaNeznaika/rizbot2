/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.telbot.rizbot.appconfig;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import ru.telbot.rizbot.MyWizardTelegramBot;

/**
 *
 * @author user
 */
@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "telegrambot")
public class BotConfig {
    private String webHookPath;
    private String botUserName;
    private String botToken;
    
    private DefaultBotOptions.ProxyType proxyType;
    private String proxyHost;
    private int proxyPort;
    
    @Bean
    public MyWizardTelegramBot MyTelBot(){
        
        DefaultBotOptions options = new DefaultBotOptions();
        
        /*options.setProxyHost(proxyHost);
        options.setProxyPort(proxyPort);
        options.setProxyType(proxyType);
        */
        
        MyWizardTelegramBot myTelBot = new MyWizardTelegramBot(options);
        
        myTelBot.setBotUserName(botUserName);
        myTelBot.setBotToken(botToken);
        myTelBot.setWebHookPath(webHookPath);
        
        return myTelBot;
    }
}
