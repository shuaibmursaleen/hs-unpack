package com.shuaib.hscodes.taxbreakdown.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shuaib.hscodes.taxbreakdown.entity.TaxBreakdown;

@Repository
public interface TaxBreakdownRepository extends MongoRepository<TaxBreakdown, String> {
    Optional<TaxBreakdown> findByHsCode(String hsCode);
    List<TaxBreakdown> findByHsCodeStartingWith(String hsCode);
}
