package com.dh.store.endpoints.store;

import com.dh.store.modules.store.application.dto.OrderCommand;
import com.dh.store.modules.store.application.dto.OrderResponse;
import com.dh.store.modules.store.application.OrderCreator;
import com.dh.store.modules.warehouses.application.DucklingFinder;
import com.dh.store.modules.warehouses.domain.Duckling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Iterator;

@RestController
public class PostOrderController {
    @Autowired
    private OrderCreator orderCreator;
    @Autowired
    private DucklingFinder ducklingFinder;

    @PostMapping("orders")
    public ResponseEntity<OrderResponse> Handle(@RequestBody OrderCommand command) {
        Iterable<Duckling> ducklingList = ducklingFinder.findByCriteria(null, false, null, command.color(), command.size());
        Iterator<Duckling> iterator = ducklingList.iterator();
        if (!iterator.hasNext())
            return new ResponseEntity<OrderResponse>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<OrderResponse>(orderCreator.create(command, iterator.next().getPrice()), HttpStatus.OK);
    }
}
