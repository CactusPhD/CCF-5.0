package ccf.superwiki;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
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
public class Liv2Controller implements Initializable {

    Parent root;
    Stage stage;
    Scene scene;
    @FXML
    private Pane back;
    @FXML
    private AnchorPane anchor;
    @FXML
    private Text title1;

    @FXML
    private Text desc1;

    @FXML
    private Text url1;

    @FXML
    private Text author1;

    @FXML
    private Text title11;

    @FXML
    private Text desc11;

    @FXML
    private Text url11;

    @FXML
    private Text author11;
    @FXML
    void back(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage = (Stage) anchor.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    //https://newsapi.org/v1/articles?source=google-news&sortBy=&apiKey=56720f37937b4243883d0bf54adddd21
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        InputStreamReader reader = null;
        try {
            URL url = new URL("https://newsapi.org/v1/articles?source=google-news&sortBy=&apiKey=56720f37937b4243883d0bf54adddd21");
            reader = new InputStreamReader(url.openStream());
        } catch (Exception e) {

        }
        Articles articles = new Gson().fromJson(reader, Articles.class);
        author1.setText(articles.articles[0].author);
        author11.setText(articles.articles[1].author);
        url1.setText(articles.articles[0].url);
        url11.setText(articles.articles[1].url);
        desc1.setText(articles.articles[0].description);
        desc11.setText(articles.articles[1].description);
        title11.setText(articles.articles[1].title);
        title1.setText(articles.articles[0].title);
    }
public class Articles {
    Article[] articles;
}
public class Article{
    String author,title,description,url;
}
}
