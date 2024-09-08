package com.news.controller;

import com.news.model.dto.comparison.ComparisonDto;
import com.news.model.dto.comparison.ComparisonResponseDto;
import com.news.service.comparison.ComparisonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comparison")
@CrossOrigin("*")
public class ComparisonController {
    private final ComparisonService comparisonService;

    @GetMapping()
    public ResponseEntity<List<ComparisonResponseDto>> allComparison (){
        return new ResponseEntity(comparisonService.allComparison(),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ComparisonResponseDto> saveComparison(@RequestBody ComparisonDto comparisonDto){
        return new ResponseEntity<>(comparisonService.addComparison(comparisonDto), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteComparisonById(@PathVariable String id){
        return new ResponseEntity<>(comparisonService.deleteComparisonById(id),HttpStatus.OK);
    }

    @DeleteMapping("/all")
    public Boolean deleteAllComparison(){
        return comparisonService.deleteAllComparison();
    }
}
