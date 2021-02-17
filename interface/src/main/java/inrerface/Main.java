package inrerface;

import entity.Client;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import read.ReadExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;


public class Main extends Application {
    String path;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        TableView<Client> tableView = new TableView<>();
        TableColumn<Client, String> clientStringTableColumn = new TableColumn<>("Имя клиента");
        TableColumn<Client, Double> clientDoubleTableColumn = new TableColumn<>("Число");
        clientStringTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        clientDoubleTableColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
        tableView.getColumns().addAll(clientStringTableColumn, clientDoubleTableColumn);

        Label lab_Priemka = new Label("Приемка");

        lab_Priemka.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node source = (Node) event.getSource();
                Stage PrimaryStage = (Stage) source.getScene().getWindow();
                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter xlsxFilter = new FileChooser.ExtensionFilter("xlsx files(*.xlsx)", "*.xlsx");
                fileChooser.getExtensionFilters().add(xlsxFilter);
                //fileChooser.getExtensionFilters().addAll(xlsxfilter);
                fileChooser.setTitle("Выбор файла");
                File file = fileChooser.showOpenDialog(PrimaryStage);
                path = file.getPath();

                try {
                    ArrayList<Client> clients = ReadExcel.ReadExcel(new FileInputStream(file));
                    for (Client client: clients) {
                        tableView.getItems().add(client);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InvalidFormatException e) {
                    e.printStackTrace();
                }
            }
        });


        Label lab_Otgruzka = new Label("Отгрузка");
        Label lab_Ostatki = new Label("Остатки");
        VBox vBox = new VBox(lab_Priemka, lab_Otgruzka, lab_Ostatki);
        FlowPane root = new FlowPane(vBox, tableView);
        Scene scene = new Scene(root, 1300, 400);
        primaryStage.setTitle("Кастом сервис");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
