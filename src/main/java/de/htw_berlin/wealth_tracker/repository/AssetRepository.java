package de.htw_berlin.wealth_tracker.repository;

import de.htw_berlin.wealth_tracker.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {
}