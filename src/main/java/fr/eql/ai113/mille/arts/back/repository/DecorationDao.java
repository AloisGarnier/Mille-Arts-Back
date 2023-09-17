package fr.eql.ai113.mille.arts.back.repository;

import fr.eql.ai113.mille.arts.back.entity.Decoration;
import fr.eql.ai113.mille.arts.back.entity.Price;
import fr.eql.ai113.mille.arts.back.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface DecorationDao extends JpaRepository<Decoration, Long> {

    List<Decoration> findAll();
    Decoration findById(long id);

    @Query("SELECT d " +
            "FROM Decoration d " +
            "WHERE d.withdrawalDate = null")
    List<Decoration> findAllActiveDecorations();

    @Transactional
    @Modifying
    @Query("UPDATE Decoration d " +
            "SET d.withdrawalDate = current_time " +
            "WHERE d.id = ?1")
    void DisableDecorationById(long id);

    @Query("SELECT DISTINCT d " +
            "FROM Decoration d " +
            "JOIN DecorationTag dt ON d.id = dt.decoration " +
            "JOIN Tag t ON t.id = dt.tag " +
            "WHERE (d.name LIKE %?1% " +
            "OR t.name LIKE %?1%) " +
            "AND d.withdrawalDate = null")
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

    @Query("SELECT p " +
            "FROM Decoration d " +
            "JOIN DecorationPrice dp ON d.id = dp.decoration " +
            "JOIN Price p ON p.id = dp.price " +
            "WHERE d.id = ?1 " +
            "AND dp.withdrawalDate = null ")
    Price findCurrentPriceClassByDecorationId(Long decorationId);

    @Transactional
    @Modifying
    @Query("UPDATE DecorationPrice dp " +
            "SET dp.withdrawalDate = CURRENT_TIME " +
            "WHERE dp.decoration = ?1 " +
            "AND dp.price = ?2 " +
            "AND dp.withdrawalDate = null")
    void deleteCurrentPriceByDecorationId(Decoration decoration, Price price);

    @Query("SELECT t " +
            "FROM Tag t " +
            "WHERE t.name = ?1")
    Tag findTagByName(String tagName);

    @Query("SELECT p " +
            "FROM Price p " +
            "WHERE p.amount = ?1")
    Price findPriceByAmount(Float amount);

    @Transactional
    @Modifying
    @Query("UPDATE Decoration d " +
            "SET d.name = ?2, " +
            "d.picture = ?3, " +
            "d.description = ?4, " +
            "d.preparationDelay = ?5 " +
            "WHERE d.id = ?1")
    void modifyDecoration(Long id, String name, String picture, String description, Long preparationDelay);
}
