package fr.eql.ai113.mille.arts.back.service.impl;

import fr.eql.ai113.mille.arts.back.entity.Command;
import fr.eql.ai113.mille.arts.back.repository.CommandDao;
import fr.eql.ai113.mille.arts.back.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandServiceImpl implements CommandService {

    private CommandDao commandDao;

    @Override
    public List<Command> findTodoCommands() {
        return commandDao.findTodoCommands();
    }

    @Autowired
    public void setCommandDao(CommandDao commandDao) {
        this.commandDao = commandDao;
    }
}
