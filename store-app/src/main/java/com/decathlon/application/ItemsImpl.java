package com.decathlon.application;

import com.decathlon.store.api.ItemsApiDelegate;
import com.decathlon.store.model.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class ItemsImpl implements ItemsApiDelegate {

    @Override
    public Mono<ResponseEntity<Item>> getItem(String itemId, ServerWebExchange exchange) {
        return Mono.delay(Duration.ofMillis(2000)).then(Mono.just(ResponseEntity.ok(Item.builder()
                        .color("red")
                        .date(OffsetDateTime.now())
                        .description("mono item")
                        .name("item")
                        .build()))
                );
    }
}
