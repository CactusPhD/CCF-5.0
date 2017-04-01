package ccf.superwiki;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

public class Liv1Controller implements Initializable {

    //This is weather guys
    Parent root;
    Stage stage;
    Scene scene;
    @FXML
    private Pane back;
    @FXML
    private AnchorPane anchor;
    @FXML
    private Text sumText;
    @FXML
    private ImageView icon;
    @FXML
    private Text temp;
    @FXML
    private Text humid;
    @FXML
    private Text visible;
    @FXML
    private Text windsp;
    @FXML
    private Text ozone;
    @FXML
    private VBox vb;
    @FXML
    private Text temp1;
    @FXML
    private Text date1;
    @FXML
    private Text temp2;
    @FXML
    private Text date2;
    @FXML
    private Text temp3;
    @FXML
    private Text date3;
    @FXML
    private Text temp4;
    @FXML
    private Text date4;
    @FXML
    private Text temp5;
    @FXML
    private Text date5;
    @FXML
    private Text temp6;
    @FXML
    private Text date6;
    @FXML
    private Text temp7;
    @FXML
    private Text date7;
    @FXML
    private Text temp8;
    @FXML
    private Text date8;
    @FXML
    private Text temp9;
    @FXML
    private Text date9;
    @FXML
    private Text temp10;
    @FXML
    private Text date10;

    @FXML
    void back(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage = (Stage) anchor.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        InputStreamReader reader = null;
        try {
            URL url = new URL("https://api.darksky.net/forecast/65f5e1f44ab73266f3bfe6b34c1cf50e/30.2241,-92.0198");
            reader = new InputStreamReader(url.openStream());
        } catch (Exception e) {

        }
        Weather wdata = new Gson().fromJson(reader, Weather.class);
        DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
        
        sumText.setText("It is currently " + wdata.currently.summary.toLowerCase());
        Image image = new Image(getClass().getResourceAsStream("/Resources/" + wdata.currently.icon + ".jpg"));
        icon.setImage(image);
        temp.setText(wdata.currently.temperature + " degrees");
        humid.setText("Humidity is at " + (wdata.currently.humidity * 100) + "%");
        visible.setText("Average visibility is " + wdata.currently.visibility + " miles");
        windsp.setText("Wind speed is " + wdata.currently.windSpeed + " MPH");
        ozone.setText("The ozone is at " + wdata.currently.ozone + " DU");
        temp1.setText(wdata.hourly.data[1].temperature + " degrees");
        date1.setText(dateFormat.format(new java.util.Date(wdata.hourly.data[1].time*1000)).toString());
        temp2.setText(wdata.hourly.data[2].temperature + " degrees");
        date2.setText(dateFormat.format(new java.util.Date(wdata.hourly.data[2].time*1000)).toString());
        temp3.setText(wdata.hourly.data[3].temperature + " degrees");
        date3.setText(dateFormat.format(new java.util.Date(wdata.hourly.data[3].time*1000)).toString());
        temp4.setText(wdata.hourly.data[4].temperature + " degrees");
        date4.setText(dateFormat.format(new java.util.Date(wdata.hourly.data[4].time*1000)).toString());
        temp5.setText(wdata.hourly.data[5].temperature + " degrees");
        date5.setText(dateFormat.format(new java.util.Date(wdata.hourly.data[5].time*1000)).toString());
        temp6.setText(wdata.hourly.data[6].temperature + " degrees");
        date6.setText(dateFormat.format(new java.util.Date(wdata.hourly.data[6].time*1000)).toString());
        temp7.setText(wdata.hourly.data[7].temperature + " degrees");
        date7.setText(dateFormat.format(new java.util.Date(wdata.hourly.data[7].time*1000)).toString());
        temp8.setText(wdata.hourly.data[8].temperature + " degrees");
        date8.setText(dateFormat.format(new java.util.Date(wdata.hourly.data[8].time*1000)).toString());
        temp9.setText(wdata.hourly.data[9].temperature + " degrees");
        date9.setText(dateFormat.format(new java.util.Date(wdata.hourly.data[9].time*1000)).toString());
        temp10.setText(wdata.hourly.data[10].temperature + " degrees");
        date10.setText(dateFormat.format(new java.util.Date(wdata.hourly.data[10].time*1000)).toString());
    }

    private class Weather {

        Double longitude;
        Double latitude;
        String timezone;
        Currently currently;
        Hourly hourly;
    }

    private class Hourly {

        String summary;
        String icon;
        Datah[] data;
    }

    private class Datah {

        long time;
        String summary;
        String icon;
        Double temperature;
        Double apparentTemperature;
        Double humidity;
        Double windSpeed;
        Double visibility;
        Double ozone;
    }

    private class Currently {

        long time;
        String summary;
        String icon;
        Double temperature;
        Double apparentTemperature;
        Double humidity;
        Double visibility;
        Double ozone;
        Double windSpeed;
    }
}
