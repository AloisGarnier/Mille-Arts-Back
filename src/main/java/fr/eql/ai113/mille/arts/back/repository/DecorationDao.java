package fr.eql.ai113.mille.arts.back.repository;

import fr.eql.ai113.mille.arts.back.entity.Decoration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DecorationDao extends JpaRepository<Decoration, Long> {

    List<Decoration> findAll();

    @Query("SELECT DISTINCT d " +
            "FROM Decoration d " +
            "JOIN DecorationTag dt ON d.id = dt.decoration " +
            "JOIN Tag t ON t.id = dt.tag " +
            "WHERE d.name LIKE %?1% " +
            "OR t.name LIKE %?1%")
    List<Decoration> findDecorationsByResearch(String research);

    @Query("SELECT t.name " +
            "FROM Decoration d " +
            "JOIN DecorationTag dt ON d.id = dt.decoration " +
            "JOIN Tag t ON t.id = dt.tag " +
            "WHERE d.id = ?1 " +
            "ORDER BY t.name")
    List<String> findAllTagsByDecorationId(Long id);

    @Query("SELECT p.amount " +
            "FROM Decoration d " +
            "JOIN DecorationPrice dp ON d.id = dp.decoration " +
            "JOIN Price p ON p.id = dp.price " +
            "WHERE d.id = ?1 " +
            "AND dp.withdrawalDate = null ")
    Float findCurrentPriceByDecorationId(Long decorationId);
}
