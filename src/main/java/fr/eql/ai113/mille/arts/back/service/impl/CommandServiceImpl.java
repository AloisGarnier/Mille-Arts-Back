package fr.eql.ai113.mille.arts.back.service.impl;

import fr.eql.ai113.mille.arts.back.entity.Command;
import fr.eql.ai113.mille.arts.back.service.CommandService;

public class CommandServiceImpl implements CommandService {

    @Override
    public boolean isShipmentFree(Command command) {
        return false;
    }

    private float totalPrice(Command command) {
        return 0;
    }
}
