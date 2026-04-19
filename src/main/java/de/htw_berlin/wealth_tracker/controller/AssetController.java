package de.htw_berlin.wealth_tracker.controller;

import de.htw_berlin.wealth_tracker.model.Asset;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * REST-Controller für die Verwaltung von Assets.
 * Stellt Endpunkte zur Verfügung, um Vermögenswerte abzurufen.
 */
@RestController
public class AssetController {

    /**
     * Gibt eine Liste aller Assets zurück.
     * @return Liste von Assets als JSON
     */
    @GetMapping("/assets")
    public ResponseEntity<List<Asset>> getAssets() {
        var assets = List.of(
                new Asset(1L, "MSCI World ETF", "STOCK", 5000.00, 4200.00, 10.5, "EUR", LocalDate.of(2024, 1, 15), "Hauptinvestment"),
                new Asset(2L, "Bitcoin", "CRYPTO", 1200.00, 800.00, 0.02, "EUR", LocalDate.of(2024, 6, 1), "Klein aber dabei"),
                new Asset(3L, "Tagesgeld", "CASH", 3000.00, 3000.00, 1.0, "EUR", LocalDate.of(2023, 3, 10), "Notfallreserve")
        );
        return ResponseEntity.ok(assets);
    }
}