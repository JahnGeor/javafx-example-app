package ru.kidesoft.controller.view;

import javafx.fxml.Initializable;
import javafx.stage.Stage;

public abstract class Controller implements Initializable {
    private Stage stage;
    private Double width;
    private Double height;

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Controller(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }
}
