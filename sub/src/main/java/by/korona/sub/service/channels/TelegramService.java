package by.korona.sub.service.channels;

import by.korona.sub.exception.ChannelNotFoundException;
import by.korona.sub.exception.SubscriptionDetailsNotFoundException;
import by.korona.sub.exception.UserNotFoundException;
import by.korona.sub.model.User;
import by.korona.sub.model.channel.TelegramChannel;
import by.korona.sub.model.subscripriondetails.TelegramSubscriptionDetails;
import by.korona.sub.repo.UserRepo;
import by.korona.sub.repo.channel.ChannelRepo;
import by.korona.sub.repo.subscriptiondetails.SubscriptionDetailRepository;
import by.korona.sub.service.ChannelType;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TelegramService implements ChannelService {
    private final ChannelRepo<TelegramChannel> channelRepo;
    private final UserRepo userRepo;
    private final SubscriptionDetailRepository<TelegramSubscriptionDetails> subscriptionDetailRepository;

    public TelegramService(ChannelRepo<TelegramChannel> channelRepo, UserRepo userRepo, SubscriptionDetailRepository<TelegramSubscriptionDetails> subscriptionDetailRepository) {
        this.channelRepo = channelRepo;
        this.userRepo = userRepo;
        this.subscriptionDetailRepository = subscriptionDetailRepository;
    }

    @Override
    public void subscribe(Long channelId, Long userId) {
        TelegramChannel channel = channelRepo.findById(channelId)
                .orElseThrow(() -> new ChannelNotFoundException("Канала с такими id: %d не существует".formatted(channelId)));
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Пользователя с такими id: %d не существует".formatted(userId)));
        TelegramSubscriptionDetails details = TelegramSubscriptionDetails.builder()
                .subscriptionAt(LocalDateTime.now())
                .channelId(channel.getId())
                .subscriptionStatus(true)
                .userId(user.getId()).build();
        subscriptionDetailRepository.save(details);
    }

    @Override
    public void unSubscribe(Long channelId, Long userId) {
        TelegramSubscriptionDetails details = subscriptionDetailRepository.findActiveSubscription(channelId, userId)
                .orElseThrow(() -> new SubscriptionDetailsNotFoundException("Такой подписки не найдено"));
        details.setSubscriptionStatus(false);
        details.setUnsubscriptionAt(LocalDateTime.now()); //todo Откуда берём время (сервер/клиент)
        subscriptionDetailRepository.save(details);
    }

    @Override
    public ChannelType getChannelType() {
        return ChannelType.TELEGRAM;
    }
}
