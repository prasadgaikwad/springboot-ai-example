package dev.prasadgaikwad.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder builder) {
        this.chatClient = builder
                .defaultSystem("You are a helpful AI Assistant")
                .build();
    }

    @GetMapping("/chat")
    public String chat(@RequestParam(value = "message", defaultValue = "Tell me a dad joke") String message) {
        System.out.println("received message: " + message);
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }
}
