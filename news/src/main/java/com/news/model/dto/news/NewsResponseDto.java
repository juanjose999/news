package com.news.model.dto.news;

import com.news.model.comparison.Comparison;
import com.news.model.dto.comparison.ComparisonDto;
import com.news.model.dto.comparison.ComparisonResponseDto;
import com.news.model.news.IdeologyNews;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsResponseDto {
    private String title;
    private String content;
    private String cover_image;
    private String link_news;
    private IdeologyNews ideologyNews;
}
