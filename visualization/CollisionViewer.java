package buffer.visualization;
import java.util.List;
import buffer.core.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.animation.AnimationTimer;

public class CollisionViewer {
    private Group root = new Group();
    private Octree octree = new Octree(new AABB(-50, -50, -50, 50, 50, 50));
    private GameObject[] objects = new GameObject[20];

    public CollisionViewer() {//constructor
        System.out.println("Initializing " + objects.length + " objects"); // Should print "Initializing 20 objects"
        // Initialize objects (unchanged)
        for (int i = 0; i < objects.length; i++) {
            objects[i] = new GameObject(
                Math.random() * 80 - 40,
                Math.random() * 80 - 40,
                Math.random() * 80 - 40,
                1.0
            );
        }
    }

    public Parent createContent() {
        // FIXED: Added FPS control to AnimationTimer
        new AnimationTimer() {
            private long lastTime = 0;
            
            @Override
            public void handle(long now) {
                if (now - lastTime < 16_666_666) return; // Strict 60 FPS
                update();
                lastTime = now;
            }
        }.start();

        return root;
    }

    private void update() {
        root.getChildren().clear();
        octree = new Octree(new AABB(-50, -50, -50, 50, 50, 50));
    
        // Update objects
        for (GameObject obj : objects) {
            obj.update();
            try {
                octree.insert(obj);
            } catch (NullPointerException e) {
                System.err.println("Insert failed for object at " + obj.x + "," + obj.y + "," + obj.z);
            }
        }
    
        // Render objects (unchanged)
        for (GameObject obj : objects) {
            Box box = new Box(2, 2, 2);
            box.setTranslateX(obj.x);
            box.setTranslateY(obj.y);
            box.setTranslateZ(obj.z);
            box.setMaterial(new PhongMaterial(obj.isColliding ? Color.RED : Color.BLUE));
            root.getChildren().add(box);
        }
    }
}