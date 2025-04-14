package buffer.core;

import java.util.ArrayList;
import java.util.List;

public class Octree {
    private AABB bounds;
    private List<GameObject> objects;
    private Octree[] children;
    private boolean isDivided = false;

    public Octree(AABB bounds) {
        this.bounds = bounds;
        this.objects = new ArrayList<>();
    }

    public void insert(GameObject obj) {
        if (!bounds.intersects(obj.bounds)) return;

        if (!isDivided && objects.size() < 4) {
            objects.add(obj);
        } else {
            if (!isDivided) subdivide();
            for (Octree child : children) child.insert(obj);
        }
    }

    private void subdivide() {
        double midX = (bounds.minX + bounds.maxX) / 2;
        double midY = (bounds.minY + bounds.maxY) / 2;
        double midZ = (bounds.minZ + bounds.maxZ) / 2;

        children = new Octree[8];
        children[0] = new Octree(new AABB(bounds.minX, bounds.minY, bounds.minZ, midX, midY, midZ));
        children[1] = new Octree(new AABB(midX, bounds.minY, bounds.minZ, bounds.maxX, midY, midZ));
        // ... (define all 8 children)
        isDivided = true;
    }

    public List<GameObject> query(AABB range) {
        List<GameObject> found = new ArrayList<>();
        if (!bounds.intersects(range)) return found;

        for (GameObject obj : objects) {
            if (range.intersects(obj.bounds)) found.add(obj);
        }

        if (isDivided) {
            for (Octree child : children) {
                found.addAll(child.query(range));
            }
        }
        return found;
    }
}
