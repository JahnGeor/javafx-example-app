package ru.kidesoft.controller.view.manager;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import ru.kidesoft.controller.view.Controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Manager {
    private static List<Controller> controllers = new ArrayList<>();

    @SafeVarargs
    public static void initControllers(Stage stage, Class<? extends Controller> ...controllerClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        for (Class<? extends Controller> controller : controllerClass) {
            Controller c = controller.getConstructor(Stage.class).newInstance(stage);
            controllers.add(c);
        }

        stage.setScene(new Scene(new StackPane()));
    }



    public static void addController(Controller controller) {
        controllers.add(controller);
    }

    public static void removeController(Controller controller) {
        controllers.remove(controller);
    }

    public static List<Controller> getControllers() {
        return controllers;
    }

    public static Controller getController(Class<? extends Controller> controller) throws NullPointerException {
        for (Controller c : controllers) {
            if (c.getClass() == controller) {
                return c;
            }
        }
        throw new NullPointerException();
    }

    public static Controller getController(int index) {
        return controllers.get(index);
    }

    public static void clearControllers() {
        controllers.clear();
    }

    public static int getControllersCount() {
        return controllers.size();
    }

    public static void open(Class<? extends Controller> controllerClass) throws NullPointerException, IOException {
        // NOTE: Получаем экземпляр контроллера из списка по классу
        Controller c = getController(controllerClass);
        // NOTE: Создаем загрузчик FXML
        FXMLLoader loader = new FXMLLoader();
        // NOTE: Устанавливаем экземпляр контроллера в загрузчик
        loader.setController(c);
        // NOTE: Устанавливаем путь до FXML-файла
        loader.setLocation(controllerClass.getResource(controllerClass.getSimpleName().toLowerCase() + ".fxml"));
        // NOTE: Загружаем корневой узел FXML-файла
        AnchorPane next = loader.load();
        // NOTE: Отключаем корневой узел следующего контроллера (для предотвращения нажатий во время анимации)
        next.setDisable(true);
        // NOTE: Получаем корневой узел главной сцены
        StackPane parent = (StackPane) c.getStage().getScene().getRoot();
        // NOTE: Получаем содержимое корневого узла
        ObservableList<Node> parentChildren = parent.getChildren();

        // NOTE: Если в корневом узле нет дочерних узлов, то добавляем новый узел в корневой узел, разблокируем этот узел и показываем главную сцену
        if (parentChildren.isEmpty()) {
            parentChildren.add(next);
            next.setDisable(false);
            c.getStage().show();
        }
        // NOTE: Иначе добавляем новый узел в конец списка дочерних узлов, разблокируем этот узел, перемещаем его в начало списка, удаляем предыдущий узел и показываем главную сцену
        else {
            Node previous = parentChildren.get(0);
            parent.getChildren().add(next);
            next.translateYProperty().set(c.getStage().getScene().getHeight());

            KeyValue kvPrev = new KeyValue(previous.translateYProperty(), -c.getStage().getScene().getHeight(), Interpolator.EASE_OUT);
            KeyFrame kfPrev = new KeyFrame(Duration.seconds(0.5), kvPrev);


            Timeline timeline = new Timeline();
            KeyValue kv = new KeyValue(next.translateYProperty(), 0, Interpolator.EASE_IN);
            KeyFrame kf = new KeyFrame(Duration.seconds(0.5), kv);
            timeline.getKeyFrames().addAll(kf, kfPrev);
            timeline.setOnFinished(event -> {
                next.setDisable(false);
                parent.getChildren().remove(previous);
            });
            timeline.play();
        }













    }
}
