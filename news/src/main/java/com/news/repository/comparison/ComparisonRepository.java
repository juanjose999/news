package com.news.repository.comparison;

import com.news.model.comparison.Comparison;

import java.util.List;
import java.util.Optional;

public interface ComparisonRepository {
    Optional<List<Comparison>> allComparison();
    Optional<Comparison> findComparisonById(String  idComparison);
    Comparison addComparison(Comparison comparison);
    Boolean deleteComparisonById(String idComparison);
    Boolean deleteAllComparison();
}
