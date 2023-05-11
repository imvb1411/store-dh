package com.dh.store.endpoints.warehouses;

import com.dh.store.modules.warehouses.application.DucklingFinder;
import com.dh.store.modules.warehouses.application.dto.DucklingResult;
import com.dh.store.modules.warehouses.domain.Duckling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class GetDucklingController {
    @Autowired
    private DucklingFinder ducklingFinder;

    @GetMapping("warehouses")
    public ResponseEntity<List<DucklingResult>> Handle() {
        List<DucklingResult> ducklingList = ducklingFinder
                .findByCriteria(null, false, null, null, null)
                .stream()
                .map(d -> new DucklingResult(
                    d.getId(),
                    d.getColor().ordinal(),
                    d.getSize().ordinal(),
                    d.getPrice(),
                    d.getQuantity()))
                .collect(Collectors.toList());
        ducklingList.sort((d1,d2) -> d2.quantity() - d1.quantity());
        return new ResponseEntity<List<DucklingResult>>(ducklingList, HttpStatus.OK);
    }

    @GetMapping("warehouses/{id}")
    public ResponseEntity<DucklingResult> Handle(@PathVariable int id) {
        Iterable<Duckling> ducklingList = ducklingFinder.findByCriteria(id, false, null, null, null);
        Iterator<Duckling> iterator = ducklingList.iterator();
        if (!iterator.hasNext())
            return new ResponseEntity<DucklingResult>(HttpStatus.NOT_FOUND);

        Duckling duckling = iterator.next();
        return new ResponseEntity<DucklingResult>(
                new DucklingResult(
                        duckling.getId(),
                        duckling.getColor().ordinal(),
                        duckling.getSize().ordinal(),
                        duckling.getPrice(),
                        duckling.getQuantity()), HttpStatus.OK);
    }
}
