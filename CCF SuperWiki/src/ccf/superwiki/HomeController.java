/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccf.superwiki;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Arc;
import javafx.scene.text.Text;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Ryan
 */
public class HomeController implements Initializable {

    Parent root;
    Stage stage;
    Scene scene;
    private boolean recOn = false, livOn = false;

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
    private Arc livButton3;

    @FXML
    private Arc livButton2;

    @FXML
    private Arc livButton1;

    @FXML
    private Text livText1;

    @FXML
    private Text livText2;

    @FXML
    private Text livText3;

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
    }

    @FXML
    void recOption1(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Rec1.fxml"));
        stage = (Stage) anchor.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void recOption2(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Rec2.fxml"));
        stage = (Stage) anchor.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void recOption3(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Rec3.fxml"));
        stage = (Stage) anchor.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void livMenu(MouseEvent event) {
        recButton.setVisible(livOn);
        tranButton.setVisible(livOn);
        recText.setVisible(livOn);
        tranText.setVisible(livOn);
        recButton.setManaged(livOn);
        tranButton.setManaged(livOn);
        recText.setManaged(livOn);
        tranText.setManaged(livOn);
        livButton1.setVisible(!livOn);
        livButton1.setManaged(!livOn);
        livButton2.setVisible(!livOn);
        livButton2.setManaged(!livOn);
        livButton3.setVisible(!livOn);
        livButton3.setManaged(!livOn);
        livText1.setVisible(!livOn);
        livText1.setManaged(!livOn);
        livText2.setVisible(!livOn);
        livText2.setManaged(!livOn);
        livText3.setVisible(!livOn);
        livText3.setManaged(!livOn);
        livOn = !livOn;
    }

    @FXML
    void livOption1(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Liv1.fxml"));
        stage = (Stage) anchor.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void livOption2(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Liv2.fxml"));
        stage = (Stage) anchor.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void livOption3(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Liv3.fxml"));
        stage = (Stage) anchor.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
