package fr.eql.ai113.mille.arts.back.repository;

import fr.eql.ai113.mille.arts.back.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TagDao extends JpaRepository<Tag, Long> {

}
