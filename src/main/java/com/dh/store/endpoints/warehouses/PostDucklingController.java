package com.dh.store.endpoints.warehouses;

import com.dh.store.modules.warehouses.application.dto.DucklingCreateCommand;
import com.dh.store.modules.warehouses.application.DucklingCreator;
import com.dh.store.modules.warehouses.application.DucklingFinder;
import com.dh.store.modules.warehouses.domain.Duckling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.net.URI;

@RestController
public class PostDucklingController {
    @Autowired
    private DucklingFinder ducklingFinder;
    @Autowired
    private DucklingCreator ducklingCreator;

    @PostMapping("/warehouses")
    public ResponseEntity<Object> Handle(@RequestBody DucklingCreateCommand request) {
        Duckling newDuckling = new Duckling(request.color(), request.size(), request.price(), request.quantity());
        ducklingFinder
                .findByCriteria(null,
                        null,
                        request.price(),
                        request.color(),
                        request.size())
                .stream()
                .findFirst()
                .ifPresent(ducklingFound -> {
                    newDuckling.setId(ducklingFound.getId());
                    newDuckling.AddQuantity(ducklingFound.getQuantity());
                });

        Duckling ducklingCreated = ducklingCreator.createOrUpdate(newDuckling);
        return ResponseEntity.created(URI.create("/warehouses/" + ducklingCreated.getId())).build();
    }
}
