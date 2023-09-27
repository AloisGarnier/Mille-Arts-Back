package fr.eql.ai113.mille.arts.back.service;

import fr.eql.ai113.mille.arts.back.entity.Command;

import java.util.List;

public interface CommandService {

    List<Command> findTodoCommands();
}
