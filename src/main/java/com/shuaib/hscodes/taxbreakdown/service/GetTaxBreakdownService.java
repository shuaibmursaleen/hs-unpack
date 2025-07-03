package com.shuaib.hscodes.taxbreakdown.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shuaib.hscodes.taxbreakdown.dto.TaxBreakdownDTO;
import com.shuaib.hscodes.taxbreakdown.entity.TaxBreakdown;
import com.shuaib.hscodes.taxbreakdown.repository.TaxBreakdownRepository;
import com.shuaib.hscodes.util.Command;

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
