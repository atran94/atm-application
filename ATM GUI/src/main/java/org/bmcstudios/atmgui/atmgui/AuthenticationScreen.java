package org.bmcstudios.atmgui.atmgui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.bmcstudios.atmgui.atmgui.util.SceneUtil;

import java.io.IOException;

public class AuthenticationScreen {
    @FXML
    private Label titleText;

    @FXML
    protected void onChangeScreenClick() throws IOException {
        SceneUtil.changeScene("home-screen.fxml");
    }
}