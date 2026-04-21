package console;

import entity.MeasurementResult;
import entity.MeasurementTable;
import entity.Tank;
import entity.enums.FuelType;
import exceptions.InvalidMeasurementException;
import services.TankService;
import util.CsvLoader;


import java.util.List;
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
            clearScreen();
            showMainMenu();

            int opcao = readInt(sc);

            switch (opcao) {
                case 1:
                    boolean calculating = true;

                    while (calculating) {
                        clearScreen();
                        showCalculationMenu();
                        int tankOption = readInt(sc);
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
                            case 5:
                                calculating = false;
                                continue;
                            default:
                                System.out.println("Tanque inválido.");
                                continue;
                        }

                        System.out.print("\nDigite a medição em CM: ");
                        int cm = readInt(sc);

                        try {
                            int liters = service.calculateLiters(selectedTank, cm);
                            System.out.println("Resultado: " + liters + " litros");

                        } catch (InvalidMeasurementException e) {
                            System.out.println("ERRO: " + e.getMessage());
                        }

                        System.out.println("------------------------------------");
                        System.out.println("\n [1] - Nova consulta");
                        System.out.println(" [2] - Imprimir resultados");
                        System.out.println(" [3] - Encerrar");
                        System.out.print("\nEscolha: ");

                        int next = readInt(sc);

                        if (next == 2) {
                            List<MeasurementResult> list = service.getResults();

                            if (list.isEmpty()) {
                                System.out.println("Nenhum resultado registrado.");
                            } else {

                                for (MeasurementResult r : list) {
                                    System.out.println("-----------------------------");
                                    System.out.println(r);
                                }
                                pause(sc);
                            }

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
        System.out.println(" [5] Voltar");
        System.out.print("\n Escolha um Tanque: ");
    }

    public static int readInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Entrada inválida. Digite apenas números: ");
            sc.nextLine();
        }
        int value = sc.nextInt();
        sc.nextLine();
        return value;
    }

    public static void clearScreen() {
        for (int i = 0; i < 60; i++) {
            System.out.println();
        }
    }

    public static void pause(Scanner sc) {
        System.out.println("\nPressione ENTER para continuar...");
        sc.nextLine();
    }
}
