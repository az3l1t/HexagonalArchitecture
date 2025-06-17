package net.az3l1t.Hex.infrastructure.adapter.persistence.proccessor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.az3l1t.Hex.domain.model.OrderOutbox;
import net.az3l1t.Hex.domain.port.out.OrderOutboxRepository;
import net.az3l1t.Hex.infrastructure.adapter.persistence.entity.OrderType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class OutboxEventProcessor {
    private final RestTemplate restTemplate;
    private final OrderOutboxRepository orderOutboxRepository;

    @Value("${url.random-photo}")
    private String urlPhotos;

    @Value("${url.id}")
    private Long urlPhotosId;

    @Value("${url.duration-seconds}")
    private Long durationSeconds;

    @Transactional
    @Scheduled(fixedDelay = 5000)
    public void processSchedulingOrder() throws IOException, InterruptedException {
        List<OrderOutbox> outboxResult = orderOutboxRepository.findAll();

        for (OrderOutbox orderOutbox : outboxResult) {
            if (orderOutbox.getOrderTypeRealTime().equals(OrderType.NEEDS_TO_SCHEDULE.toString())) {
                orderOutbox.setOrderTypeRealTime(OrderType.SCHEDULING.toString());

                String apiUrl = urlPhotos + urlPhotosId;
                ResponseEntity<byte[]> response = restTemplate.getForEntity(apiUrl, byte[].class);

                if (response.getStatusCode().is2xxSuccessful()) {
                    orderOutbox.setOrderTypeRealTime(OrderType.SCHEDULED.toString());
                } else {
                    orderOutbox.setOrderTypeRealTime(OrderType.NEEDS_TO_SCHEDULE.toString());
                }
            }
        }
    }
}
