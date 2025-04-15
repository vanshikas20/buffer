package buffer.core;
import java.lang.Math;
public class GameObject {
    public double x, y, z;
    public AABB bounds;
    public boolean isColliding = false;

    public GameObject(double x, double y, double z, double size) {
        this.x = x; this.y = y; this.z = z;
        this.bounds = new AABB(x - size, y - size, z - size, x + size, y + size, z + size);
    }

    // public void update() {
    //     // Simple random movement (replace with physics later)
    //     x += Math.random() * 0.1 - 0.05;
    //     y += Math.random() * 0.1 - 0.05;
    //     z += Math.random() * 0.1 - 0.05;
        
    //     // Update bounding box
    //     double size = 1.0;
    //     bounds = new AABB(x - size, y - size, z - size, x + size, y + size, z + size);
    // }
    public void update() {
        // Constrained movement (-40 to 40 range)
        x = Math.max(-40, Math.min(40, x + (Math.random() * 0.1 - 0.05)));
        y = Math.max(-40, Math.min(40, y + (Math.random() * 0.1 - 0.05)));
        z = Math.max(-40, Math.min(40, z + (Math.random() * 0.1 - 0.05)));
        
        bounds = new AABB(x-1, y-1, z-1, x+1, y+1, z+1);
    }
}
