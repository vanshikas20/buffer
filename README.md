🧩 Project Description
This is a 3D Collision Detection Visualizer using JavaFX and an Octree for efficient spatial partitioning. It simulates moving 3D objects, each with an Axis-Aligned Bounding Box (AABB), and detects collisions in real-time.
Objects are rendered in blue (no collision) or red (collision). The Octree reduces collision checks by dividing 3D space into regions, improving performance over brute-force methods.

📚 Data Structures Used

Octree: Recursively divides space into 8 parts to group nearby objects.
Array / ArrayList: Store and manage objects and Octree nodes.

✨ Features
Real-time 3D rendering and animation
Efficient Octree-based collision detection
Color-coded visual feedback (Red = collision, Blue = safe)
