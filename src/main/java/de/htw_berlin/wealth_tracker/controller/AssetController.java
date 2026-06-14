package de.htw_berlin.wealth_tracker.controller;

import de.htw_berlin.wealth_tracker.model.Asset;
import de.htw_berlin.wealth_tracker.repository.AssetRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST-Controller für die Verwaltung von Assets.
 * Stellt Endpunkte zur Verfügung, um Vermögenswerte abzurufen und zu speichern.
 */

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/assets")
public class AssetController {

    // Spring injiziert automatisch das Repository (Dependency Injection)
    private final AssetRepository assetRepository;

    public AssetController(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    /**
     * GET /assets – Gibt alle Assets aus der Datenbank zurück.
     */
    @GetMapping
    public ResponseEntity<List<Asset>> getAssets() {
        return ResponseEntity.ok(assetRepository.findAll());
    }

    /**
     * POST /assets – Speichert ein neues Asset in der Datenbank.
     */
    @PostMapping
    public ResponseEntity<Asset> createAsset(@RequestBody Asset asset) {
        Asset saved = assetRepository.save(asset);
        return ResponseEntity.ok(saved);
    }
}