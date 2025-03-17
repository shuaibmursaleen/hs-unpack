package com.shuaib.hscodes.taxbreakdown;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shuaib.hscodes.taxbreakdown.model.TaxBreakdown;

@Repository
public interface TaxBreakdownRepository extends MongoRepository<TaxBreakdown, String> {
    
}
