module org.bmcstudios.atmgui.atmgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.bmcstudios.atmgui.atmgui to javafx.fxml;
    exports org.bmcstudios.atmgui.atmgui;
}