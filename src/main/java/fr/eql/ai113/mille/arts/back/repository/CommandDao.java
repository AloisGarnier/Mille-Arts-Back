package fr.eql.ai113.mille.arts.back.repository;

import fr.eql.ai113.mille.arts.back.entity.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommandDao extends JpaRepository<Command, Long> {

    @Query("SELECT c " +
            "FROM Command c " +
            "WHERE c.realizationDate = null")
    List<Command> findTodoCommands();
}
