package inrerface.control;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class LabelTreatmentFile extends Label {
    String path;

    public LabelTreatmentFile(String text) {
        super(text);
        super.setOnMouseClicked(new EventHandler<MouseEvent>() {
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

            }
        });
    }

    public String getPath() {
        return path;
    }
}
