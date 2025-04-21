package com.shuaib.hscodes.taxbreakdown;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shuaib.hscodes.taxbreakdown.model.TaxBreakdown;

@Repository
public interface TaxBreakdownRepository extends MongoRepository<TaxBreakdown, String> {
    Optional<TaxBreakdown> findByHsCode(String hsCode);
    List<TaxBreakdown> findByHsCodeContaining(String hsCode);
}
