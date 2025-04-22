package com.shuaib.hscodes.taxbreakdown.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.shuaib.hscodes.Query;
import com.shuaib.hscodes.taxbreakdown.TaxBreakdownRepository;
import com.shuaib.hscodes.taxbreakdown.model.TaxBreakdown;
import com.shuaib.hscodes.taxbreakdown.model.TaxBreakdownDTO;


@Service
public class SearchTaxBreakdownService implements Query<String, List<TaxBreakdownDTO>>{
    private final TaxBreakdownRepository taxBreakdownRepository;

    public SearchTaxBreakdownService(TaxBreakdownRepository taxBreakdownRepository) {
        this.taxBreakdownRepository = taxBreakdownRepository;
    }

    @Override
    @Cacheable("taxBreakdownCache")
    public List<TaxBreakdownDTO> execute(String hsCode) {
        List<TaxBreakdown> hsList = new ArrayList<>();
        while(hsList.isEmpty() && hsCode.length() != 1) {
            hsList = taxBreakdownRepository.findByHsCodeStartingWith(hsCode);
            hsCode = hsCode.substring(0, hsCode.length()-1);
        }
        List<TaxBreakdownDTO> hsListDTO = hsList.stream().map(TaxBreakdownDTO::new).toList();
        return hsListDTO;
       }
}
