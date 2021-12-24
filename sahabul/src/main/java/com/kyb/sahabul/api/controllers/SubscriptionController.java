package com.kyb.sahabul.api.controllers;

import com.kyb.sahabul.business.abstracts.SubscriptionServices;
import com.kyb.sahabul.entities.concretes.Subscription;
import com.kyb.sahabul.entities.dto.SubscriptionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "api/subscription")
public class SubscriptionController {
    private final SubscriptionServices subscriptionServices;

    public SubscriptionController(SubscriptionServices subscriptionServices) {
        this.subscriptionServices = subscriptionServices;
    }

    @GetMapping(value = "getAll")
    public ResponseEntity<List<SubscriptionDto>> getAll() {
        return ResponseEntity.ok(subscriptionServices.getAll());
    }

    @GetMapping(value = "getById")
    public ResponseEntity<SubscriptionDto> getById(@RequestParam int id) {
        return ResponseEntity.ok(subscriptionServices.getById(id));
    }

    @PostMapping(value = "add")
    public ResponseEntity<SubscriptionDto> add(@RequestBody Subscription subscription) {
        return ResponseEntity.ok(subscriptionServices.add(subscription));
    }
}
