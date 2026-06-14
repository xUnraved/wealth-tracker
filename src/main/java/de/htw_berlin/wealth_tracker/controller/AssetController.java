package de.htw_berlin.wealth_tracker.controller;

import de.htw_berlin.wealth_tracker.model.Asset;
import de.htw_berlin.wealth_tracker.repository.AssetRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST-Controller für die Verwaltung von Assets.
 * Stellt Endpunkte zum Abrufen, Erstellen, Bearbeiten und Löschen von Assets bereit.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/assets")
public class AssetController {

    private final AssetRepository assetRepository;

    public AssetController(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    /** GET /assets – Alle Assets zurückgeben */
    @GetMapping
    public ResponseEntity<List<Asset>> getAssets() {
        return ResponseEntity.ok(assetRepository.findAll());
    }

    /** POST /assets – Neues Asset speichern */
    @PostMapping
    public ResponseEntity<Asset> createAsset(@RequestBody Asset asset) {
        return ResponseEntity.ok(assetRepository.save(asset));
    }

    /** PUT /assets/{id} – Asset bearbeiten */
    @PutMapping("/{id}")
    public ResponseEntity<Asset> updateAsset(@PathVariable Long id, @RequestBody Asset asset) {
        asset.setId(id);
        return ResponseEntity.ok(assetRepository.save(asset));
    }

    /** DELETE /assets/{id} – Asset löschen */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAsset(@PathVariable Long id) {
        assetRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}