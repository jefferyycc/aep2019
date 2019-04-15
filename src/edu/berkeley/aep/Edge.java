package edu.berkeley.aep;

import java.util.HashSet;

public class Edge {
    private final Node child;
    private final int cost;

    public Edge(Node child, int cost) {
        this.child = child;
        this.cost = cost;
    }

    public int countTo(Node destination, HashSet<Node> visited) {
        return child.countTo(destination, visited);
    }

    public int costTo(Node destination, HashSet<Node> visited) {
        int cost = child.costTo(destination, visited);
        if (cost == -1) return -1;
        return cost + this.cost;
    }
}
