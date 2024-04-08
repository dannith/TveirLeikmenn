package hi.dto2.tveirleikmenn;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("leikur-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        stage.setTitle("Tveir!");
        stage.setScene(scene);
        ((Controller) fxmlLoader.getController()).initControls();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}