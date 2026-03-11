package com.navneet.farmAiAssist.controller;

import com.navneet.farmAiAssist.model.TractorsByBrand;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.converter.ListOutputConverter;
import org.springframework.ai.converter.MapOutputConverter;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class StructuredOutputController {

    private final ChatClient chatClient;

    public StructuredOutputController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.defaultAdvisors(new SimpleLoggerAdvisor())
                .build();
    }

    @GetMapping("/structured-bean")
    public ResponseEntity<TractorsByBrand> structuredChat(@RequestParam("message") String message){
        TractorsByBrand tractorsByBrand = chatClient
                .prompt()
                .user(message)
                .call().entity(TractorsByBrand.class);
        return ResponseEntity.ok(tractorsByBrand);
    }

    @GetMapping("/structured-list")
    public ResponseEntity<List<String>> structuredList(@RequestParam("message") String message){
        List<String> tractors = chatClient
                .prompt()
                .user(message)
                .call().entity(new ListOutputConverter());
        return ResponseEntity.ok(tractors);
    }

    @GetMapping("/structured-map")
    public ResponseEntity<Map<String, Object>> structuredMap(@RequestParam("message") String message){
        Map<String, Object> tractors = chatClient
                .prompt()
                .user(message)
                .call().entity(new MapOutputConverter());
        return ResponseEntity.ok(tractors);
    }

    @GetMapping("/structured-bean-list")
    public ResponseEntity<List<TractorsByBrand>> structuredBeanList(@RequestParam("message") String message){
        List<TractorsByBrand> tractors = chatClient
                .prompt()
                .user(message)
                .call().entity(new ParameterizedTypeReference<List<TractorsByBrand>>() {});
        return ResponseEntity.ok(tractors);
    }

}
