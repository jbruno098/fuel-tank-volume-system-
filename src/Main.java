import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {

        Map<Integer, Integer> table_tank_15000 = new HashMap<>();
        Map<Integer, Integer> table_tank_7500 = new HashMap<>();

        String table = "resources/tank_7500.csv";
        String table2 =  "resources/tank_15000.csv";
        loadTable(table2, table_tank_15000);
        loadTable(table, table_tank_7500);

        System.out.println("Teste 90cm (tanque 15.000L) -> " + table_tank_15000.get(90) + " litros");
        System.out.println("teste 90cm (tanque 7500L -> " + table_tank_7500.get(90) + " litros");
    }


    public static void loadTable(String path, Map<Integer, Integer> map) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linha;
            br.readLine(); // pula primeira linha

            while ((linha = br.readLine()) != null) {
                String[] colunas = linha.split(",");
                Integer cm = Integer.parseInt(colunas[0]);
                Integer litros = Integer.parseInt(colunas[1]);
                map.put(cm, litros);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
