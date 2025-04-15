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
    try {
        CollisionViewer viewer = new CollisionViewer();
        Scene scene = new Scene(viewer.createContent(), 800, 600, true);
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setTranslateZ(-60);
        scene.setCamera(camera);
        stage.setScene(scene);
        stage.show();
    } catch (Exception e) {
        e.printStackTrace();
        System.exit(1);
    }
}
}