package buffer.visualization;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        CollisionViewer viewer = new CollisionViewer();
        Scene scene = new Scene(viewer.createContent(), 800, 600, true);
        scene.setCamera(new PerspectiveCamera());
        stage.setScene(scene);
        stage.setTitle("3D Collision Detection");
        stage.show();
    }
}