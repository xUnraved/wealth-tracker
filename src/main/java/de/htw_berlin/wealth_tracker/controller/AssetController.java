package de.htw_berlin.wealth_tracker.controller;

import de.htw_berlin.wealth_tracker.model.Asset;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class AssetController {

    @GetMapping("/assets")
    public ResponseEntity<List<Asset>> getAssets() {
        var assets = List.of(
            new Asset(1L, "MSCI World ETF", "STOCK", 5000.00, 4200.00, 10.5, "EUR", LocalDate.of(2024, 1, 15), "Hauptinvestment"),
            new Asset(2L, "Apple Inc.", "STOCK", 2150.00, 1800.00, 12.0, "EUR", LocalDate.of(2023, 6, 4), "Langfristige Position"),
            new Asset(3L, "Bitcoin", "CRYPTO", 8200.00, 6500.00, 0.15, "EUR", LocalDate.of(2023, 11, 22), "Spekulativ"),
            new Asset(4L, "Ethereum", "CRYPTO", 1900.00, 2400.00, 0.8, "EUR", LocalDate.of(2024, 3, 10), "Aktuell im Minus"),
            new Asset(5L, "Tagesgeldkonto", "CASH", 7500.00, 7500.00, 1.0, "EUR", LocalDate.of(2024, 1, 1), "Notgroschen"),
            new Asset(6L, "Eigentumswohnung Berlin", "REAL_ESTATE", 285000.00, 240000.00, 1.0, "EUR", LocalDate.of(2021, 9, 1), "Eigennutzung"),
            new Asset(7L, "Tesla Inc.", "STOCK", 1240.00, 1500.00, 5.0, "EUR", LocalDate.of(2024, 5, 8), "Volatil")
        );
        return ResponseEntity.ok(assets);
    }
}
