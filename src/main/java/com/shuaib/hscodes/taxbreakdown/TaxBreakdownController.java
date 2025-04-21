package com.shuaib.hscodes.taxbreakdown;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shuaib.hscodes.taxbreakdown.model.TaxBreakdownDTO;
import com.shuaib.hscodes.taxbreakdown.services.GetTaxBreakdownByHsCodeService;
import com.shuaib.hscodes.taxbreakdown.services.GetTaxBreakdownService;

@RestController
public class TaxBreakdownController {
    private final GetTaxBreakdownService getTaxBreakdownService;
    private final GetTaxBreakdownByHsCodeService getTaxBreakdownByHsCodeService;
    
    public TaxBreakdownController(GetTaxBreakdownService getTaxBreakdownService, GetTaxBreakdownByHsCodeService getTaxBreakdownByHsCodeService) {
        this.getTaxBreakdownService = getTaxBreakdownService;
        this.getTaxBreakdownByHsCodeService = getTaxBreakdownByHsCodeService;
    }

    @PostMapping
    public ResponseEntity<String> createTaxBreakdown() {
        return ResponseEntity.status(HttpStatus.OK).body("Post");
    }

    @GetMapping
    public ResponseEntity<List<TaxBreakdownDTO>> getTaxBreakdown() {
        return getTaxBreakdownService.execute(null);
    }

    @GetMapping("/{hsCode}")
    public ResponseEntity<List<TaxBreakdownDTO>> getTaxBreakdownbyHsCode(@PathVariable String hsCode) {
        return getTaxBreakdownByHsCodeService.execute(hsCode);
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
