module Login.Register.DB {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires com.jfoenix;
    requires de.jensd.fx.glyphs.fontawesome;
    requires javafx.media;
    requires java.sql;

    opens view to javafx.fxml;
    opens model to javafx.controls;
    opens controller to javafx.fxml;
    exports model ;
    exports App;
}