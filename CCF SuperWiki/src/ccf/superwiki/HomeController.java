/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccf.superwiki;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Arc;
import javafx.scene.text.Text;

/**
 *
 * @author Ryan
 */
public class HomeController implements Initializable {

    @FXML
    private Arc recButton;

    @FXML
    private Arc livButton;

    @FXML
    private Arc tranButton;

    @FXML
    private Text recText;

    @FXML
    private Text livText;

    @FXML
    private Text tranText;

    @FXML
    void recMenu(MouseEvent event) {
        livButton.setVisible(false);
        tranButton.setVisible(false);
        livText.setVisible(false);
        tranText.setVisible(false);
        livButton.setManaged(false);
        tranButton.setManaged(false);
        livText.setManaged(false);
        tranText.setManaged(false);
        //System.out.println("CLICKY CLICK BITCH");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
