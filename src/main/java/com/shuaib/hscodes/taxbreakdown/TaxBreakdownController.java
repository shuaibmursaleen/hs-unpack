package com.shuaib.hscodes.taxbreakdown;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shuaib.hscodes.taxbreakdown.model.TaxBreakdown;
import com.shuaib.hscodes.taxbreakdown.services.CreateTaxBreakdownService;

@RestController
public class TaxBreakdownController {
    private final CreateTaxBreakdownService createTaxBreakdownService;
    
    public TaxBreakdownController(CreateTaxBreakdownService createTaxBreakdownService) {
        this.createTaxBreakdownService = createTaxBreakdownService;
    }

    @PostMapping
    public ResponseEntity<List<TaxBreakdown>>  createTaxBreakdown() {
        return createTaxBreakdownService.execute(null);
    }

    @GetMapping
    public ResponseEntity<String> getTaxBreakdown() {
        return ResponseEntity.status(HttpStatus.OK).body("Got");
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
