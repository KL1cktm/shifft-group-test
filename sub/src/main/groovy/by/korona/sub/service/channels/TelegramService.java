package by.korona.sub.service.channels;

import by.korona.sub.model.User;
import by.korona.sub.model.channel.Channel;
import by.korona.sub.repo.ChannelRepo;
import by.korona.sub.repo.UserRepo;
import by.korona.sub.service.ChannelType;
import org.springframework.stereotype.Service;

@Service
public class TelegramService implements ChannelService {
    private final ChannelRepo channelRepo;
    private final UserRepo userRepo;

    public TelegramService(ChannelRepo channelRepo, UserRepo userRepo) {
        this.channelRepo = channelRepo;
        this.userRepo = userRepo;
    }

    @Override
    public void subscribe(Long channelId, Long userId) {
        Channel channel = channelRepo.findById(channelId);
        User user = userRepo.findById(userId);
        channel.subscribeUser(user);
    }

    @Override
    public void unSubscribe(Long channelId, Long userId) {
        Channel channel = channelRepo.findById(channelId);
        User user = userRepo.findById(userId);
        channel.unsubscribeUser(user);
    }

    @Override
    public ChannelType getChannelType() {
        return ChannelType.TELEGRAM;
    }
}
