package by.korona.sub.controller;

import by.korona.sub.service.channels.SubscriptionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping
public class Controller {
    private final SubscriptionService subscriptionService;

    public Controller(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping("/subscribe/{channelType}")
    public void subscribeUser(
            @PathVariable("channelType") String channelType,
            @RequestParam("channelId") Long channelId,
            @RequestParam("userId") Long userId
    ) {
        subscriptionService.processSubscription(channelType, channelId, userId);
        log.info("subscribeUser {} {} {}", channelType, channelId, userId);
    }

    @PostMapping("/unsubscribe/{channelType}")
    public void unsubscribe(
            @PathVariable("channelType") String channelType,
            @RequestParam("channelId") Long channelId,
            @RequestParam("userId") Long userId
    ) {
        subscriptionService.processUnSubscription(channelType, channelId, userId);
        log.info("unsubscribeUser {} {} {}", channelType, channelId, userId);
    }

    @GetMapping
    public String index() {
        return "Hello World";
    }

    @PostMapping
    public String subscribe() {
        return "Hello World";
    }
}
