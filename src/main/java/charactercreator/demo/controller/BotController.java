package charactercreator.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import charactercreator.demo.dto.ChatGPTRequest;
import charactercreator.demo.dto.ChatGPTResponse;

@RestController
@RequestMapping(value="/bot")
public class BotController {
    
    @Autowired
    private RestTemplate template;

    @Value(("${openai.api.url}"))
    private String apiUrl;

    @Value("${openai.model}")
    private String model;
    
    @GetMapping(value="/chat/{prompt}")
    public String chat(@PathVariable String prompt){
        ChatGPTRequest request = new ChatGPTRequest(model, "Create a backstory for a Dungeon and Dragons character with this specificaton:" + prompt);
        ChatGPTResponse chatGPTResponse = template.postForObject(apiUrl, request, ChatGPTResponse.class);

        return chatGPTResponse.getChoices().get(0).getMessage().getContent();
    }
}
