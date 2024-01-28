module app.home {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens app.home to javafx.fxml;
    exports app.home;
}