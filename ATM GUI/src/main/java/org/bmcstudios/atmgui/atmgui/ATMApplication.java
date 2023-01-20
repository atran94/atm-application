package org.bmcstudios.atmgui.atmgui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.bmcstudios.atmgui.atmgui.util.SceneUtil;

import java.io.IOException;

public class ATMApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Store the stage reference
        SceneUtil.stage = stage;

        FXMLLoader fxmlLoader = new FXMLLoader(ATMApplication.class.getResource("home-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), SceneUtil.WIDTH, SceneUtil.HEIGHT);

        stage.setTitle("ATM Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}