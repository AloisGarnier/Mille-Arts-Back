package fr.eql.ai113.mille.arts.back.repository;

import fr.eql.ai113.mille.arts.back.entity.Decoration;
import fr.eql.ai113.mille.arts.back.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureDao extends JpaRepository<Picture, Long> {

    void deleteAllByDecoration(Decoration decoration);

}
