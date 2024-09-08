package com.news.service.comparison;

import com.news.model.comparison.Comparison;
import com.news.model.dto.comparison.ComparisonDto;
import com.news.model.dto.comparison.ComparisonResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
public interface ComparisonService {
    Optional<List<ComparisonResponseDto>> allComparison();
    ComparisonResponseDto findComparisonById(String idComparison);
    ComparisonResponseDto addComparison(ComparisonDto comparisonDto);
    Boolean deleteComparisonById(String idComparison);
    Boolean deleteAllComparison();
}
