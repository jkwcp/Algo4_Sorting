package convexHull;


// Smallest convex set containing all points (smallest perimeter fence enclosing the points...)
// Convex hull output: sequence of vertices in couterclockwise order
// Shortest path....Farthest pair problem
//
// Fact: traverse the convex hull by making only counterclockwise turns..
// Fact: The vertices of convex hull appear in
// increasing order or polar angle with respect to point p with lowest y-coordinates

// Starting lowest y coord point(p), sort the points by polar angle by p..counter clockwise turn

// Chanllenge:
// 1. how to find point p with smallest y-coordinates?
// 2. how to sort points by polar angle with respect to p?
// 3. how to determine whether p1->p2->p3 is a counterclockwise turn?
// 4. how to sort efficiently? Mergesort NlogN
// 5. how to handle degeneracies ( three or more points on the line)?


// CCW:
//
public class ConvexHullEx {

}
