package edu.berkeley.aep;

import java.util.HashSet;

// Understands how to calculate the distance between two nodes
public class Edge {
    private final Node child;
    private final int cost;
    public final static HopStrategy HOP_STRATEGY = edge -> 1;
    public final static HopStrategy COST_STRATEGY = edge -> edge.cost;

    public Edge(Node child, int cost) {
        this.child = child;
        this.cost = cost;
    }

    public Path pathTo(Node destination, HashSet<Node> visited, HopStrategy strategy) {
        Path path = child.pathTo(destination, visited, strategy);
        if (path == Path.UNREACHABLE) return Path.UNREACHABLE;
        return path.add(strategy.cost(this));
    }
}