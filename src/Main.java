import entity.MeasurementTable;
import entity.Tank;
import entity.enums.FuelType;
import services.TankService;
import util.CsvLoader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CsvLoader csv = new CsvLoader();
        TankService service = new TankService();

        // TABELAS
        MeasurementTable table7500 = csv.load("resources/tank_7500.csv");
        MeasurementTable table15000 = csv.load("resources/tank_15000.csv");

        // TANQUES
        Tank dieselS500 = new Tank(1,15000, FuelType.DIESEL_S500, table15000);
        Tank gasolina = new Tank(2,15000, FuelType.GASOLINA_COMUN, table15000);
        Tank etanol = new Tank(3,7500, FuelType.ETANOL, table7500);
        Tank dieselS10 = new Tank(4,7500, FuelType.DIESEL_S10, table7500);

        int teste1 = service.calculateLiters(gasolina, 90);
        int teste2 = service.calculateLiters(etanol, 90);
        int teste3 = service.calculateLiters(etanol, 500); // exceção

        System.out.println(teste1);
        System.out.println(teste2);

        sc.close();
    }
}
