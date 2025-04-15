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

    public CollisionViewer() {
        // Initialize objects
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
        // Animation loop
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        }.start();

        return root;
    }

    private void update() {
        root.getChildren().clear();
        octree = new Octree(new AABB(-50, -50, -50, 50, 50, 50));

        // Update objects and check collisions
        for (GameObject obj : objects) {
            obj.update();
            octree.insert(obj);
            List<GameObject> candidates = octree.query(obj.bounds);
            obj.isColliding = false;
            for (GameObject other : candidates) {
                if (obj != other && obj.bounds.intersects(other.bounds)) {
                    obj.isColliding = true;
                    break;
                }
            }
        }

        // Render objects
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
