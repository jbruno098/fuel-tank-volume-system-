package services;

import entity.Tank;

public class TankService {

    public Integer calculateLiters(Tank tank, Integer cm) {
        return tank.getTable().searchLiters(cm);
    }
}
