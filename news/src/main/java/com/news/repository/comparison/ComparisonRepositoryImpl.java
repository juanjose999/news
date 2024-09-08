package com.news.repository.comparison;

import com.news.model.comparison.Comparison;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ComparisonRepositoryImpl implements ComparisonRepository{
    @Autowired
    public final ComparisonRepositoryMongo comparisonRepositoryMongo;

    public ComparisonRepositoryImpl(ComparisonRepositoryMongo comparisonRepositoryMongo) {
        this.comparisonRepositoryMongo = comparisonRepositoryMongo;
    }

    @Override
    public Optional<List<Comparison>> allComparison() {
        return Optional.of(comparisonRepositoryMongo.findAll());
    }

    @Override
    public Optional<Comparison> findComparisonById(String idComparison) {
        return comparisonRepositoryMongo.findById(idComparison);
    }

    @Override
    public Comparison addComparison(Comparison comparison) {
        return comparisonRepositoryMongo.save(comparison);
    }

    @Override
    public Boolean deleteComparisonById(String idComparison) {
        Optional<Comparison> findComparison = findComparisonById(idComparison);
        if(findComparison.isPresent()){
            comparisonRepositoryMongo.deleteById(idComparison);
            return true;
        }
        return false;
    }

    public Boolean deleteAllComparison (){
        comparisonRepositoryMongo.deleteAll();
        return true;
    }
}
