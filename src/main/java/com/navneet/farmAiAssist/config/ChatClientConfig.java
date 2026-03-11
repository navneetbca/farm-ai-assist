package com.navneet.farmAiAssist.config;

import com.navneet.farmAiAssist.advisors.TokenUsageAuditAdvisor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ChatClientConfig {

    @Bean
    public ChatClient chatClient(ChatClient.Builder chatClientBuilder){

        ChatOptions chatOptions = ChatOptions.builder().model("gpt-4o-mini")
//                .maxTokens(500)
//                .temperature(0.8)
                .build();

        return chatClientBuilder
            .defaultOptions(chatOptions)
            .defaultAdvisors(List.of(new SimpleLoggerAdvisor(), new TokenUsageAuditAdvisor()))
            .defaultSystem("""
                You are an AI Farm Assistant.
                Your job is to help farmers with agricultural questions such as:
                - crops
                - fertilizers
                - irrigation
                - farm equipment
                - farming practices
                If a question is not related to farming or agriculture,
                politely respond that you can only help with farm-related queries.
            """)
            .build();
    }

}
