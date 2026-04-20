import entity.enums.FuelType;
import entity.MeasurementTable;
import entity.Tank;
import exceptions.InvalidMeasurementException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.TankService;
import util.CsvLoader;

public class FuelTankApp extends Application {

    @Override
    public void start(Stage stage) {

        CsvLoader csv = new CsvLoader();
        TankService service = new TankService();

        // TABELAS
        MeasurementTable table7500 = csv.load("resources/tank_7500.csv");
        MeasurementTable table15000 = csv.load("resources/tank_15000.csv");

        // TANQUES
        Tank dieselS500 = new Tank(1, 15000, FuelType.DIESEL_S500, table15000);
        Tank gasolina = new Tank(2, 15000, FuelType.GASOLINA_COMUN, table15000);
        Tank etanol = new Tank(3, 7500, FuelType.ETANOL, table7500);
        Tank dieselS10 = new Tank(4, 7500, FuelType.DIESEL_S10, table7500);

        // COMPONENTES
        Label titleLabel = new Label("POSTO RA III - MEDIÇÃO DE TANQUES");

        Label tankLabel = new Label("Escolha o tanque:");
        ComboBox<String> tankComboBox = new ComboBox<>();
        tankComboBox.getItems().addAll(
                "Diesel S500",
                "Gasolina Comum",
                "Etanol",
                "Diesel S10"
        );
        tankComboBox.setValue("Diesel S500");

        Label cmLabel = new Label("Digite a medição em CM:");
        TextField cmTextField = new TextField();
        cmTextField.setPromptText("Ex: 90");

        Button calculateButton = new Button("Calcular");
        Button historyButton = new Button("Exibir Histórico de Medições");
        Label resultLabel = new Label("Resultado: ");

        Label historyLabel = new Label("Histórico de medições:");
        ListView<String> historyListView = new ListView<>();
        historyListView.setPrefHeight(150);

        historyLabel.setVisible(false);
        historyLabel.setManaged(false);

        historyListView.setVisible(false);
        historyListView.setManaged(false);

        calculateButton.setOnAction(e -> {
            try {
                int cm = Integer.parseInt(cmTextField.getText());

                Tank selectedTank = null;

                switch (tankComboBox.getValue()) {
                    case "Diesel S500":
                        selectedTank = dieselS500;
                        break;
                    case "Gasolina Comum":
                        selectedTank = gasolina;
                        break;
                    case "Etanol":
                        selectedTank = etanol;
                        break;
                    case "Diesel S10":
                        selectedTank = dieselS10;
                        break;
                    default:
                        resultLabel.setText("Resultado: tanque inválido.");
                        return;
                }

                int liters = service.calculateLiters(selectedTank, cm);

                resultLabel.setText(
                        "Resultado: " + cm + " cm = " + liters + " litros no tanque de " +
                                tankComboBox.getValue()
                );

                String record = tankComboBox.getValue() + " - " + cm + " cm = " + liters + " litros";
                historyListView.getItems().add(record);

            } catch (NumberFormatException ex) {
                resultLabel.setText("Resultado: digite um número inteiro válido.");
            } catch (InvalidMeasurementException ex) {
                resultLabel.setText("Resultado: " + ex.getMessage());
            } catch (Exception ex) {
                resultLabel.setText("Resultado: erro ao calcular.");
            }
        });

        historyButton.setOnAction(e -> {

            boolean visible = historyListView.isVisible();

            historyLabel.setVisible(!visible);
            historyLabel.setManaged(!visible);

            historyListView.setVisible(!visible);
            historyListView.setManaged(!visible);

            if (visible) {
                historyButton.setText("Exibir Histórico de Medições");
            } else {
                historyButton.setText("Ocultar Histórico");
            }
        });


        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(
                titleLabel,
                tankLabel,
                tankComboBox,
                cmLabel,
                cmTextField,
                calculateButton,
                historyButton,
                resultLabel,
                historyLabel,
                historyListView
        );

        Scene scene = new Scene(root, 450, 500);

        stage.setTitle("Medição de Tanques");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
