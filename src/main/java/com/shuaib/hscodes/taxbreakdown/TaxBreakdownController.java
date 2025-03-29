package com.shuaib.hscodes.taxbreakdown;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shuaib.hscodes.taxbreakdown.model.TaxBreakdown;
import com.shuaib.hscodes.taxbreakdown.services.GetTaxBreakdownService;

@RestController
public class TaxBreakdownController {
    private final GetTaxBreakdownService getTaxBreakdownService;
    
    public TaxBreakdownController(GetTaxBreakdownService getTaxBreakdownService) {
        this.getTaxBreakdownService = getTaxBreakdownService;
    }

    @PostMapping
    public ResponseEntity<String> createTaxBreakdown() {
        return ResponseEntity.status(HttpStatus.OK).body("Post");
    }

    @GetMapping
    public ResponseEntity<List<TaxBreakdown>> getTaxBreakdown() {
        return getTaxBreakdownService.execute(null);
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
