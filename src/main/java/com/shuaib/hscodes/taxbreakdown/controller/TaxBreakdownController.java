package com.shuaib.hscodes.taxbreakdown.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shuaib.hscodes.taxbreakdown.dto.TaxBreakdownDTO;
import com.shuaib.hscodes.taxbreakdown.exception.TaxBreakdownNotFoundException;
import com.shuaib.hscodes.taxbreakdown.service.GetTaxBreakdownService;
import com.shuaib.hscodes.taxbreakdown.service.SearchTaxBreakdownService;

@RestController
public class TaxBreakdownController {
    private final GetTaxBreakdownService getTaxBreakdownService;
    private final SearchTaxBreakdownService searchTaxBreakdownService;
    
    public TaxBreakdownController(GetTaxBreakdownService getTaxBreakdownService, SearchTaxBreakdownService searchTaxBreakdownService) {
        this.getTaxBreakdownService = getTaxBreakdownService;
        this.searchTaxBreakdownService = searchTaxBreakdownService;
    }

    @PostMapping
    public ResponseEntity<String> createTaxBreakdown() {
        return ResponseEntity.status(HttpStatus.OK).body("Post");
    }

    @GetMapping
    public ResponseEntity<List<TaxBreakdownDTO>> getTaxBreakdown() {
        return getTaxBreakdownService.execute(null);
    }

    @GetMapping("/search")
    public ResponseEntity<List<TaxBreakdownDTO>> searchTaxBreakdown(@RequestParam String hsCode) throws TaxBreakdownNotFoundException {
        List<TaxBreakdownDTO> hsList = searchTaxBreakdownService.execute(hsCode);
        if (!hsList.isEmpty()) {
            return ResponseEntity.ok(hsList);
        }
        throw new TaxBreakdownNotFoundException();
    }

    @PutMapping
    public ResponseEntity<String> updateTaxBreakdown() {
        return ResponseEntity.status(HttpStatus.OK).body("Updated");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteTaxBreakdown() {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted");
    }
}
