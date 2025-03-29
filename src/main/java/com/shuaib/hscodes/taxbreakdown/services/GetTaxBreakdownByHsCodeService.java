package com.shuaib.hscodes.taxbreakdown.services;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shuaib.hscodes.Query;
import com.shuaib.hscodes.taxbreakdown.TaxBreakdownRepository;
import com.shuaib.hscodes.taxbreakdown.model.TaxBreakdown;
import com.shuaib.hscodes.taxbreakdown.model.TaxBreakdownDTO;


@Service
public class GetTaxBreakdownByHsCodeService implements Query<String, TaxBreakdownDTO>{
    private final TaxBreakdownRepository taxBreakdownRepository;

    public GetTaxBreakdownByHsCodeService(TaxBreakdownRepository taxBreakdownRepository) {
        this.taxBreakdownRepository = taxBreakdownRepository;
    }

    @Override
    public ResponseEntity<TaxBreakdownDTO> execute(String hsCode) {
       Optional<TaxBreakdown> taxBreakdown =  taxBreakdownRepository.findByHsCode(hsCode);
       if(taxBreakdown.isPresent()) {
        return ResponseEntity.ok(new TaxBreakdownDTO(taxBreakdown.get()));
       }
       return null;
 
    }
}
