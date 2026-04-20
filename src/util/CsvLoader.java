package util;

import entity.MeasurementTable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvLoader {

    public MeasurementTable load(String path) {
        MeasurementTable table = new MeasurementTable();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linha;
            br.readLine(); // pula primeira linha

            while ((linha = br.readLine()) != null) {
                String[] colunas = linha.split(",");
                Integer cm = Integer.parseInt(colunas[0]);
                Integer litros = Integer.parseInt(colunas[1]);
                table.addMeasures(cm, litros);
            }

        } catch (IOException e) {
            System.out.println("Arquivo CSV não encontrado" + e.getMessage());
        }
        return table;
    }
}
