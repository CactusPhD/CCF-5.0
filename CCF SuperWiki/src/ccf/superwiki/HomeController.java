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
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Arc;
import javafx.scene.text.Text;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Ryan
 */
public class HomeController implements Initializable {

    private boolean recOn = false;

    @FXML
    private AnchorPane anchor;

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
    private Arc recButton1;

    @FXML
    private Arc recButton2;

    @FXML
    private Arc recButton3;

    @FXML
    private Text recText1;

    @FXML
    private Text recText2;

    @FXML
    private Text recText3;

    @FXML
    void recMenu(MouseEvent event) {
        livButton.setVisible(recOn);
        tranButton.setVisible(recOn);
        livText.setVisible(recOn);
        tranText.setVisible(recOn);
        livButton.setManaged(recOn);
        tranButton.setManaged(recOn);
        livText.setManaged(recOn);
        tranText.setManaged(recOn);
        recButton1.setVisible(!recOn);
        recButton1.setManaged(!recOn);
        recButton2.setVisible(!recOn);
        recButton2.setManaged(!recOn);
        recButton3.setVisible(!recOn);
        recButton3.setManaged(!recOn);
        recText1.setVisible(!recOn);
        recText1.setManaged(!recOn);
        recText2.setVisible(!recOn);
        recText2.setManaged(!recOn);
        recText3.setVisible(!recOn);
        recText3.setManaged(!recOn);
        recOn = !recOn;
        //anchor.getChildren().remove(livButton);
    }
    
    @FXML
    void recOption1(MouseEvent event){
        
    }
    @FXML
    void recOption2(MouseEvent event){
        
    }
    @FXML
    void recOption3(MouseEvent event){
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
