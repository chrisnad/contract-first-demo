package com.decathlon.application;

import com.decathlon.bike.api.BikesApi;
import com.decathlon.bike.model.Bike;
import com.decathlon.store.api.ItemsApiDelegate;
import com.decathlon.store.model.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemsImpl implements ItemsApiDelegate {

    private final BikesApi bikesApi;

    @Override
    public ResponseEntity<Void> createItem(Item item) {
        return new ResponseEntity<>(HttpStatus.valueOf(201));
    }

    @Override
    public ResponseEntity<Void> deleteItem(String itemId) {
        return new ResponseEntity<>(HttpStatus.valueOf(204));
    }

    @Override
    public ResponseEntity<Item> getItem(String itemId) {
        try {
            Bike bike = bikesApi.showBikeById(itemId);
            Item todo = new Item()
                    .lastUpdated(OffsetDateTime.now().toString())
                    .description("it's a bike")
                    .available(true)
                    .name(bike.getName());
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(todo);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<List<Item>> getItems() {
        Item item = new Item()
                .lastUpdated(OffsetDateTime.now().toString())
                .description("it's shoes!")
                .available(true)
                .name("keeprun");
        return ResponseEntity.ok(List.of(item));
    }

    @Override
    public ResponseEntity<Void> updateItem(String itemId, Item item) {
        return new ResponseEntity<>(HttpStatus.valueOf(202));
    }
}
