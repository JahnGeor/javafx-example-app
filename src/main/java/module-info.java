module ru.kidesoft.controller {
    requires javafx.controls;
    requires javafx.fxml;
    requires atlantafx.base;


    opens ru.kidesoft.controller.view.impl to javafx.fxml;
    exports ru.kidesoft.controller.view.impl;
    exports ru.kidesoft;
    opens ru.kidesoft to javafx.fxml;
}