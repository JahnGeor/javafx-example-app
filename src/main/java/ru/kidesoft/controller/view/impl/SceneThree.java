package ru.kidesoft.controller.view.impl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import ru.kidesoft.controller.view.Controller;
import ru.kidesoft.controller.view.manager.Manager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SceneThree extends Controller {
    @FXML
    void nextScene(ActionEvent event) throws IOException {
        Manager.open(Hello.class);
    }


    public SceneThree(Stage stage) {
        super(stage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setHeight(300.0);
        setWidth(300.0);
    }
}
