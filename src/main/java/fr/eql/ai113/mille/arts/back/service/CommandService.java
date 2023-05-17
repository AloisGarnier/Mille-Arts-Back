package fr.eql.ai113.mille.arts.back.service;

import fr.eql.ai113.mille.arts.back.entity.Command;

public interface CommandService {

    boolean isShipmentFree(Command command);
}
