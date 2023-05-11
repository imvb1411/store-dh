package com.dh.store.modules.warehouses.infrastructure;

import com.dh.store.modules.warehouses.domain.Duckling;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface IDucklingRepository extends CrudRepository<Duckling, Integer>, JpaSpecificationExecutor<Duckling> {

}
