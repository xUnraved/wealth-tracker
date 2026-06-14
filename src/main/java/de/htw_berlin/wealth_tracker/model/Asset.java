package de.htw_berlin.wealth_tracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

/**
 * Repräsentiert einen finanziellen Vermögenswert im Wealth Tracker.
 * Ein Asset kann eine Aktie, ETF, Krypto, Bargeld, Immobilie oder sonstiger Wert sein.
 * Wird als JPA-Entity in der PostgreSQL-Datenbank gespeichert.
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "assets")
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    private double currentValue;
    private double purchasePrice;
    private double quantity;
    private String currency;
    private LocalDate purchaseDate;
    private String notes;
}