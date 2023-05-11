package com.dh.store.endpoints.warehouses;

import com.dh.store.modules.warehouses.application.dto.DucklingUpdateCommand;
import com.dh.store.modules.warehouses.application.DucklingCreator;
import com.dh.store.modules.warehouses.application.DucklingFinder;
import com.dh.store.modules.warehouses.domain.Duckling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Iterator;

@RestController
public class PutDucklingController {
    @Autowired
    private DucklingFinder ducklingFinder;
    @Autowired
    private DucklingCreator ducklingCreator;

    @PutMapping("warehouses/{id}")
    public ResponseEntity<Duckling> Handle(@PathVariable int id, @RequestBody DucklingUpdateCommand request) {
        Iterable<Duckling> ducklingList = ducklingFinder.findByCriteria(id, false, null, null, null);
        Iterator<Duckling> iterator = ducklingList.iterator();
        if (!iterator.hasNext())
            return new ResponseEntity<Duckling>(HttpStatus.OK);
        Duckling ducklingToUpdate = iterator.next();
        ducklingToUpdate.setQuantity(request.quantity());
        ducklingToUpdate.setPrice(request.price());
        ducklingCreator.createOrUpdate(ducklingToUpdate);
        return new ResponseEntity<Duckling>(HttpStatus.OK);
    }
}
