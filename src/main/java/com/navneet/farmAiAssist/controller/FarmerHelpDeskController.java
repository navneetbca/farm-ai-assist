package com.navneet.farmAiAssist.controller;

import com.navneet.farmAiAssist.tools.HelpDeskTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.ai.chat.memory.ChatMemory.CONVERSATION_ID;

@RestController
@RequestMapping("/api")
public class FarmerHelpDeskController {

    private final ChatClient chatClient;
    private final HelpDeskTools helpDeskTools;

    public FarmerHelpDeskController(@Qualifier("helpDeskChatClient") ChatClient chatClient,
                              HelpDeskTools helpDeskTools) {
        this.chatClient = chatClient;
        this.helpDeskTools = helpDeskTools;
    }

    @GetMapping("/farmer-help")
    public ResponseEntity<String> helpDesk(@RequestHeader("username") String username,
                                           @RequestParam("message") String message) {
        String answer = chatClient.prompt()
                .advisors(a -> a.param(CONVERSATION_ID, username))
                .user(message)
                .tools(helpDeskTools)
                .toolContext(Map.of("username", username))
                .call().content();
        return ResponseEntity.ok(answer);
    }
}
