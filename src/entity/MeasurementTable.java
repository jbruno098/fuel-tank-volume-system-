package entity;

import java.util.HashMap;
import java.util.Map;

public class MeasurementTable {

    private Map<Integer, Integer> measures = new HashMap<>();

    public MeasurementTable() {}

    public Map<Integer, Integer> getTable() {
        return measures;
    }

    public void addMeasures(Integer cm, Integer litros) {
        measures.put(cm, litros);
    }

    public Integer findLiters(Integer cm) {
        return  measures.get(cm);
    }
}
