package com.navneet.farmAiAssist.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.ai.chat.memory.ChatMemory.CONVERSATION_ID;

@RestController
@RequestMapping("/api")
public class ChatMemoryController {

    private final ChatClient chatClient;

    public ChatMemoryController(@Qualifier("chatMemoryChatClient") ChatClient chatClient){
        this.chatClient = chatClient;
    }

    //    I am using in-memory chatMemory because here I am just want to have demo of chatMemory,
    //    restarting the app will be lost the chat memory.
    //    To overcome this we can take a further step to save user info and chat in Database using JDBC
    @GetMapping("/chat-memory")
    public ResponseEntity<String> chatMemory(@RequestHeader("username") String username,
            @RequestParam("message") String message){
        return ResponseEntity.ok(chatClient.prompt().user(message).advisors(
                    advisorSpec -> advisorSpec.param(CONVERSATION_ID, username)
                )
                .call().content());
    }

}
