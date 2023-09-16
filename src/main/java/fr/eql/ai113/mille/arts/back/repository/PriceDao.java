package fr.eql.ai113.mille.arts.back.repository;

import fr.eql.ai113.mille.arts.back.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceDao extends JpaRepository<Price, Long> {
}
