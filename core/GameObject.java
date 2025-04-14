package buffer.core;
public class GameObject {
    public double x, y, z;
    public AABB bounds;
    public boolean isColliding = false;

    public GameObject(double x, double y, double z, double size) {
        this.x = x; this.y = y; this.z = z;
        this.bounds = new AABB(x - size, y - size, z - size, x + size, y + size, z + size);
    }

    public void update() {
        // Simple random movement (replace with physics later)
        x += Math.random() * 0.1 - 0.05;
        y += Math.random() * 0.1 - 0.05;
        z += Math.random() * 0.1 - 0.05;
        
        // Update bounding box
        double size = 1.0;
        bounds = new AABB(x - size, y - size, z - size, x + size, y + size, z + size);
    }
}
