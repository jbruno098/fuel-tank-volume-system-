package services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HistoryFileService {

    private static final String FILE_PATH = "historico_medicoes.csv";
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public void saveMeasurement(String tankName, int cm, int liters) {
        File file = new File(FILE_PATH);
        boolean fileExists = file.exists();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {

            if (!fileExists) {
                bw.write("DataHora,Tanque,CM,Litros");
                bw.newLine();
            }

            String dateTime = LocalDateTime.now().format(FORMATTER);
            String line = dateTime + "," + tankName + "," + cm + "," + liters;

            bw.write(line);
            bw.newLine();

        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar histórico no arquivo.");
        }
    }
}
