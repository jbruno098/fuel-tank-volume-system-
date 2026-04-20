package entity;

import exceptions.InvalidMeasurementException;

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

    public Integer searchLiters(Integer cm) {
        if (!measures.containsKey(cm)) {
            throw new InvalidMeasurementException(
                    "Medição inválida: " + cm + " cm não encontrada na tabela.");
        }
        return measures.get(cm);
    }
}
