package com.news.model.dto.news;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.news.model.comparison.Comparison;
import com.news.model.dto.comparison.ComparisonDto;
import com.news.model.news.IdeologyNews;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsDto {
    private String title;
    private String content;
    private String cover_image;
    private String link_news;
    private IdeologyNews ideologyNews;
    private ComparisonDto comparisonDto;
}
