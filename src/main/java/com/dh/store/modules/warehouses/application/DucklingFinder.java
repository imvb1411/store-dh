package com.dh.store.modules.warehouses.application;

import com.dh.store.modules.warehouses.domain.Duckling;
import com.dh.store.modules.warehouses.infrastructure.IDucklingRepository;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component("ducklingFinder")
public class DucklingFinder {
    @Autowired
    private IDucklingRepository ducklingRepository;

    public List<Duckling> findByCriteria(Integer id, Boolean deleted, Double price, Duckling.Color color, Duckling.Size size) {
        return ducklingRepository.findAll((Specification<Duckling>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (id != null) {
                predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("id"), id)));
            }
            if (deleted != null) {
                predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("deleted"), deleted)));
            }
            if (price != null) {
                predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("price"), price)));
            }
            if (color != null) {
                predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("color"), color)));
            }
            if (size != null) {
                predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("size"), size)));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        });
    }
}
