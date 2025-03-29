package com.shuaib.hscodes.taxbreakdown.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shuaib.hscodes.Command;
import com.shuaib.hscodes.taxbreakdown.TaxBreakdownRepository;
import com.shuaib.hscodes.taxbreakdown.model.TaxBreakdown;
import com.shuaib.hscodes.taxbreakdown.model.TaxBreakdownDTO;

@Service
public class GetTaxBreakdownService implements Command<Void, List<TaxBreakdownDTO>>{

    private final TaxBreakdownRepository taxBreakdownRepository;

    public GetTaxBreakdownService(TaxBreakdownRepository taxBreakdownRepository) {
        this.taxBreakdownRepository = taxBreakdownRepository;
    }

    @Override
    public ResponseEntity<List<TaxBreakdownDTO>> execute(Void input) {
        List<TaxBreakdown> taxbreakdown= taxBreakdownRepository.findAll();
        List<TaxBreakdownDTO> taxBreakdownDTOs = taxbreakdown.stream().map(TaxBreakdownDTO::new).toList();
        return ResponseEntity.status(HttpStatus.CREATED).body(taxBreakdownDTOs);
    }
}
