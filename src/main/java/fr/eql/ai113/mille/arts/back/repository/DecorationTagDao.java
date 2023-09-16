package fr.eql.ai113.mille.arts.back.repository;

import fr.eql.ai113.mille.arts.back.entity.Decoration;
import fr.eql.ai113.mille.arts.back.entity.DecorationTag;
import fr.eql.ai113.mille.arts.back.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface DecorationTagDao extends JpaRepository<DecorationTag, Long> {

    @Transactional
    @Modifying
    @Query("DELETE DecorationTag dt " +
            "WHERE dt.decoration = ?1")
    void deleteDTByDecorationId(Decoration decoration);

}
