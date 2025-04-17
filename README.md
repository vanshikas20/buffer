🧩 Project Description
This project is a 3D collision detection visualizer built using JavaFX and an Octree spatial partitioning algorithm. It simulates multiple moving 3D objects in space and efficiently detects collisions using Axis-Aligned Bounding Boxes (AABB).

Each frame, objects move randomly within bounds. An Octree divides the 3D space into smaller regions to optimize collision checks. Colliding objects are visually highlighted in red, while non-colliding ones appear blue.

📚 Data Structures Used
*AABB (Axis-Aligned Bounding Box):
Used to define the bounding box of each object for fast collision checks.

*Octree:
A tree data structure that recursively subdivides 3D space into 8 regions, reducing the number of collision checks by spatially grouping objects.

*Array / ArrayList:
Used to store game objects and manage object lists within each Octree node.
