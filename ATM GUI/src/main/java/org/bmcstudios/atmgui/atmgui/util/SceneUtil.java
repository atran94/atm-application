package org.bmcstudios.atmgui.atmgui.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.bmcstudios.atmgui.atmgui.ATMApplication;

import java.io.IOException;

public class SceneUtil {
    public static final double WIDTH = 800;
    public static final double HEIGHT = 600;

    public static Stage stage;

    public static void changeScene(String resource) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                ATMApplication.class.getResource(resource)
        );

        stage.setScene(
                new Scene(
                        fxmlLoader.load(),
                        WIDTH,
                        HEIGHT
                ));
        stage.show();
    }
}
