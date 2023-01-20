package org.bmcstudios.atmgui.atmgui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.bmcstudios.atmgui.atmgui.util.SceneUtil;

import java.io.IOException;

public class HomeScreen {
    @FXML
    private Label titleText;

    @FXML
    protected void onChangeScreenClick() throws IOException {
        SceneUtil.changeScene("authentication-screen.fxml");
    }
}