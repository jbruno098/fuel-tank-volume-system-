import entity.MeasurementTable;
import entity.Tank;
import entity.enums.FuelType;
import exceptions.InvalidMeasurementException;
import services.TankService;
import util.CsvLoader;

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

        // ============================= UI ================================

        boolean running = true;

        while (running) {
            showMainMenu();
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    boolean calculating = true;

                    while (calculating) {
                        showCalculationMenu();
                        int tankOption = sc.nextInt();
                        Tank selectedTank = null;

                        switch (tankOption) {

                            case 1:
                                selectedTank = dieselS500;
                                break;
                            case 2:
                                selectedTank = gasolina;
                                break;
                            case 3:
                                selectedTank = etanol;
                                break;
                            case 4:
                                selectedTank = dieselS10;
                                break;
                            default:
                                System.out.println("Tanque inválido.");
                                continue;
                        }

                        System.out.print("\nDigite a medição em CM: ");
                        int cm = sc.nextInt();

                        try {
                            int liters = service.calculateLiters(selectedTank, cm);
                            System.out.println("Resultado: " + liters + " litros");

                        } catch (InvalidMeasurementException e) {
                            System.out.println("ERRO: " + e.getMessage());
                        }

                        System.out.println("------------------------------------");
                        System.out.println("\n [1] - Nova consulta");
                        System.out.println(" [2] - Menu principal");
                        System.out.println(" [3] - Encerrar");
                        System.out.print("Escolha: ");

                        int next = sc.nextInt();

                        if (next == 2) {
                            calculating = false;
                        } else if (next == 3) {
                            calculating = false;
                            running = false;
                        }
                    }

                    break;


                case 2:
                    System.out.println("Encerrando sistema...");
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");

            }
        }

        sc.close();
    }

    // MÉTODOS AUXILIARES

    public static void showMainMenu() {
        System.out.println("\n======== POSTO RA III ========\n");
        System.out.println(" [1] - Calcular Medição");
        System.out.println(" [2] - Sair do Sistema");
        System.out.print("\nEscolha uma opção: ");
    }

    public static void showCalculationMenu() {
        System.out.println("\n====== CÁLCULO DE MEDIÇÃO =======\n");
        System.out.println(" [1] Diesel S500");
        System.out.println(" [2] Gasolina Comum");
        System.out.println(" [3] Etanol");
        System.out.println(" [4] Diesel S10");
        System.out.print("\n Escolha um Tanque: ");
    }
}
