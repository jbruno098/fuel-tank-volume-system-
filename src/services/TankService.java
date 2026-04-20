package services;

import entity.MeasurementResult;
import entity.Tank;

import java.util.ArrayList;
import java.util.List;

public class TankService {

    private List<MeasurementResult> results = new ArrayList<>();

    public Integer calculateLiters(Tank tank, Integer cm) {

        Integer liters = tank.getTable().searchLiters(cm);
        MeasurementResult result = new MeasurementResult(tank, cm, liters);
        results.add(result);
        return liters;
    }

    public List<MeasurementResult> getResults() {
        return results;
    }
}
