package de.htw_berlin.wealth_tracker;

import de.htw_berlin.wealth_tracker.model.Asset;
import de.htw_berlin.wealth_tracker.repository.AssetRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DataLoader {

    private final AssetRepository assetRepository;

    public DataLoader(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    @PostConstruct
    public void loadData() {
        if (assetRepository.count() > 0) return; // Nur laden wenn DB leer ist

        assetRepository.saveAll(List.of(
                new Asset(null, "MSCI World ETF", "STOCK", 5000.00, 4200.00, 10.5, "EUR", LocalDate.of(2024, 1, 15), "Hauptinvestment"),
                new Asset(null, "Apple Inc.", "STOCK", 2150.00, 1800.00, 12.0, "EUR", LocalDate.of(2023, 6, 4), "Langfristige Position"),
                new Asset(null, "Bitcoin", "CRYPTO", 8200.00, 6500.00, 0.15, "EUR", LocalDate.of(2023, 11, 22), "Spekulativ"),
                new Asset(null, "Ethereum", "CRYPTO", 1900.00, 2400.00, 0.8, "EUR", LocalDate.of(2024, 3, 10), "Aktuell im Minus"),
                new Asset(null, "Tagesgeldkonto", "CASH", 7500.00, 7500.00, 1.0, "EUR", LocalDate.of(2024, 1, 1), "Notgroschen"),
                new Asset(null, "Eigentumswohnung Berlin", "REAL_ESTATE", 285000.00, 240000.00, 1.0, "EUR", LocalDate.of(2021, 9, 1), "Eigennutzung"),
                new Asset(null, "Tesla Inc.", "STOCK", 1240.00, 1500.00, 5.0, "EUR", LocalDate.of(2024, 5, 8), "Volatil")
        ));
    }
}