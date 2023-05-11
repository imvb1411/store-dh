package com.dh.store.endpoints.warehouses;

import com.dh.store.modules.warehouses.application.DucklingCreator;
import com.dh.store.modules.warehouses.application.DucklingFinder;
import com.dh.store.modules.warehouses.domain.Duckling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;

@RestController
public class DeleteDucklingController {
    @Autowired
    private DucklingFinder ducklingFinder;
    @Autowired
    private DucklingCreator ducklingCreator;

    @DeleteMapping("warehouses/{id}")
    public ResponseEntity<Object> handle(@PathVariable int id) {
        Iterable<Duckling> ducklingList = ducklingFinder.findByCriteria(id, false, null, null, null);
        Iterator<Duckling> iterator = ducklingList.iterator();
        if (iterator.hasNext()) {
            Duckling toRemove = iterator.next();
            toRemove.setDeleted(true);
            ducklingCreator.createOrUpdate(toRemove);
        }
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }
}
