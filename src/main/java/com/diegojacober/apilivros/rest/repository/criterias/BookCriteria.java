package com.diegojacober.apilivros.rest.repository.criterias;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;

import com.diegojacober.apilivros.domain.entity.Book;
import com.diegojacober.apilivros.rest.repository.specs.CriteriaSpecification;

public class BookCriteria implements CriteriaSpecification {

    private final String isbn;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private final LocalDate minDataLancamento;
    private final LocalDate maxDataLancamento;
    private final BigDecimal minPreco;
    private final BigDecimal maxPreco;
    private final String genero;
    private final List<Long> autores;

    public BookCriteria(String isbn, LocalDate minDataLancamento, LocalDate maxDataLancamento, BigDecimal minPreco, BigDecimal maxPreco, String genero, List<Long> autores) {
        this.isbn = isbn;
        this.minDataLancamento = minDataLancamento;
        this.maxDataLancamento = maxDataLancamento;
        this.minPreco = minPreco;
        this.maxPreco = maxPreco;
        this.genero = genero;
        this.autores = autores;
    }

    @Override
    public Specification<Book> toSpecification() {
        Specification<Book> specification = (root, query, criteriaBuilder) -> criteriaBuilder.conjunction();

        if (Objects.nonNull(isbn)) {
            specification = specification.and((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("isbn"), isbn)
            );
        }

        if (Objects.nonNull(maxPreco) && Objects.nonNull(minPreco)) {
            specification = specification.and((root, query, criteriaBuilder) ->
                criteriaBuilder.between(root.get("price"), minPreco, maxPreco)
            );
        }

        return specification;
    }

    
}
