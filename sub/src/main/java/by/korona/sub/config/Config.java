package by.korona.sub.config;

import by.korona.sub.service.ChannelType;
import by.korona.sub.service.channels.ChannelService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
public class Config {
    @Bean
    public Map<ChannelType, ChannelService> channelServices(List<ChannelService> channelServices) {
        return channelServices.stream()
                .collect(Collectors.toMap(ChannelService::getChannelType, channelService -> channelService ));
    }
}
