package ru.kidesoft;

import atlantafx.base.theme.PrimerDark;
import atlantafx.base.theme.PrimerLight;
import javafx.application.Application;
import javafx.stage.Stage;
import ru.kidesoft.controller.view.impl.Hello;
import ru.kidesoft.controller.view.impl.SceneThree;
import ru.kidesoft.controller.view.impl.SceneTwo;
import ru.kidesoft.controller.view.manager.Manager;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        setUserAgentStylesheet(new PrimerLight().getUserAgentStylesheet());
        setUserAgentStylesheet(new PrimerDark().getUserAgentStylesheet());

        Manager.initControllers(stage, Hello.class, SceneTwo.class, SceneThree.class);
        Manager.open(Hello.class);
    }

    public static void main(String[] args) {
        launch();
    }
}