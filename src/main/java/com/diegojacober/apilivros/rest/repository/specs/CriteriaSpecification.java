package com.diegojacober.apilivros.rest.repository.specs;

import org.springframework.data.jpa.domain.Specification;

public interface CriteriaSpecification<T> {
    public Specification<T> toSpecification();
}
