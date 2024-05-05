package ru.kidesoft.controller.view.impl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import ru.kidesoft.controller.view.Controller;
import ru.kidesoft.controller.view.manager.Manager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Hello extends Controller {
    @FXML
    private Label welcomeText;

    public Hello(Stage stage) {
        super(stage);
    }

    @FXML
    protected void nextScene(ActionEvent event) throws IOException {
        Manager.open(SceneTwo.class);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setHeight(300.0);
        setWidth(300.0);
    }
}