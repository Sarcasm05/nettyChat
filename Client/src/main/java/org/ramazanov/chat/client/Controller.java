package org.ramazanov.chat.client;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public NetWork netWork;

    @FXML
    private TextField msgField;

    @FXML
    private TextArea mainArea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        netWork = new NetWork((args) -> {
            mainArea.appendText((String)args[0] + "\n");
        }); //открывается подключение

    }

    public void sendMsgAction(ActionEvent actionEvent) {
        netWork.sendMessage(msgField.getText());
        msgField.clear();
        msgField.requestFocus();
    }

    public void exitAction() {
        netWork.close();
        Platform.exit();
    }
}
