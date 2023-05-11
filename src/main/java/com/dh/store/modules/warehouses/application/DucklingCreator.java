package com.dh.store.modules.warehouses.application;

import com.dh.store.modules.warehouses.domain.Duckling;
import com.dh.store.modules.warehouses.infrastructure.IDucklingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ducklingCreator")
public class DucklingCreator {
    @Autowired
    private IDucklingRepository ducklingRepository;

    public Duckling createOrUpdate(Duckling duckling) {
        return ducklingRepository.save(duckling);
    }
}
